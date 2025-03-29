import numpy as np
import pandas as pd
import plotly.graph_objects as go

# Carregar os dados do CSV (sem cabeçalho)
data = pd.read_csv("/content/data.csv", header=None)

# Definir as variáveis independentes X (tamanho da casa e número de quartos)
X = data[[0, 1]].values

# Definir a variável dependente y (preço da casa)
y = data[2].values  # Preço da casa

# Adicionar uma coluna de 1's para o termo de interceptação (b0)
X = np.c_[np.ones(X.shape[0]), X]  # Isso transforma X em uma matriz de forma (n, 3)

# Calcular os coeficientes (beta) usando a fórmula (X^T X)^-1 X^T y
Xt = X.T
XtX = np.dot(Xt, X)
XtX_inv = np.linalg.inv(XtX)
Xty = np.dot(Xt, y)
beta = np.dot(XtX_inv, Xty)

# Verificando os coeficientes
print(f"Coeficientes (beta): {beta}")


def generate_meshgrid(X, num_points=30):
    ranges = [np.linspace(X[:, i].min(), X[:, i].max(), num_points) for i in range(X.shape[1])]
    grids = np.meshgrid(*ranges)

    # Achata todas as grades e empilha como colunas
    X_mesh = np.column_stack([grid.ravel() for grid in grids])

    return grids, X_mesh


def calculate_Z(X_mesh, beta):
    X_mesh = np.c_[np.ones(X_mesh.shape[0]), X_mesh]
    Z = X_mesh @ beta

    return Z.reshape((X_mesh.shape[0],))


grids, X_mesh = generate_meshgrid(X[:, 1:])

Z_grid = calculate_Z(X_mesh, beta).reshape(grids[0].shape)  # Cálculo da regressão


def correlacao(x, y):
    if len(x) == len(y):
        x_mean = np.mean(x)
        y_mean = np.mean(y)

        sum_xy = sum((x - x_mean) * (y - y_mean))

        sum_x_sqrd = sum((x - x_mean) ** 2)
        sum_y_sqrd = sum((y - y_mean) ** 2)

        corr = sum_xy / np.sqrt(sum_x_sqrd * sum_y_sqrd)
    return corr


x = data[[0, 1]]
y = data[[2]]

correlacao_val_x1 = correlacao(x[0], y[2])
correlacao_val_x2 = correlacao(x[1], y[2])

# Dados reais (dispersão dos pontos)
scatter = go.Scatter3d(
    x=data[0], y=data[1], z=data[2],
    mode='markers',
    marker=dict(size=5, color='blue', opacity=0.8),
    name='Dados reais'
)

# Superfície de regressão
surface = go.Surface(
    z=Z_grid,
    x=grids[0],
    y=grids[1],
    colorscale='Reds',
    opacity=0.5,
    showscale=False
)

# Layout da figura
layout = go.Layout(
    title=f'Regressão Linear Múltipla - Correlação: {correlacao_val_x1}, {correlacao_val_x2}',
    scene=dict(
        xaxis_title='Tamanho da Casa',
        yaxis_title='Número de Quartos',
        zaxis_title='Preço da Casa'
    ),
    updatemenus=[dict(
        type='buttons',
        showactive=False,
        buttons=[dict(label='Play',
                      method='animate',
                      args=[None, dict(frame=dict(duration=200, redraw=True), fromcurrent=True)])]
    )]
)

# Animação
frames = [go.Frame(
    data=[go.Surface(
        z=Z_grid,
        x=grids[0],
        y=grids[1],
        colorscale='Blues',
        opacity=0.5,
        showscale=False
    )],
    name=str(i)
) for i in range(50)]  # 50 frames de animação

# Gráfico final
fig = go.Figure(
    data=[scatter, surface],
    layout=layout,
    frames=frames
)

# Mostrar o gráfico animado
fig.show()