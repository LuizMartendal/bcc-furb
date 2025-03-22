import pandas as pd
import plotly.express as px
import numpy as np

x1 = [10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5]
y1 = [8.04, 6.95, 7.58, 8.81, 8.33, 9.96, 7.24, 4.26, 10.84, 4.82, 5.68]

x2 = [10, 8, 13, 9, 11, 14, 6, 4, 12, 7, 5]
y2 = [9.14, 8.14, 8.47, 8.77, 9.26, 8.10, 6.13, 3.10, 9.13, 7.26, 4.74]

x3 = [8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 19]
y3 = [6.58, 5.76, 7.71, 8.84, 8.47, 7.04, 5.25, 5.56, 7.91, 6.89, 12.50]

# Organizando em um dicionário para fácil manipulação
datasets = {"x1": x1, "y1": y1, "x2": x2, "y2": y2, "x3": x3, "y3": y3}


# Função para plotar cada dataset separadamente
def plotar_scatter(x, y, titulo):
    df = pd.DataFrame({'x': x, 'y': y})
    fig = px.scatter(df, x='x', y='y', title=titulo)
    fig.show()


# Plotando gráficos individuais
plotar_scatter(x1, y1, 'Gráfico de Dispersão - Dataset 1')
plotar_scatter(x2, y2, 'Gráfico de Dispersão - Dataset 2')
plotar_scatter(x3, y3, 'Gráfico de Dispersão - Dataset 3')


def correlacao(x, y):
    if len(x) == len(y):
        x_mean = np.mean(x)
        y_mean = np.mean(y)

        sum_xy = sum((x - x_mean) * (y - y_mean))

        sum_x_sqrd = sum((x - x_mean) ** 2)
        sum_y_sqrd = sum((y - y_mean) ** 2)

        return sum_xy / np.sqrt(sum_x_sqrd * sum_y_sqrd)


def regressao(x, y):
    if len(x) == len(y):
        x_mean = np.mean(x)
        y_mean = np.mean(y)

        sum_xy = sum((x - x_mean) * (y - y_mean))
        sum_x_sqrd = sum((x - x_mean) ** 2)
        b1 = sum_xy / sum_x_sqrd
        b0 = y_mean - (b1 * x_mean)
        y = b0 + np.array(x) * b1
        return b0, b1, y


def plotar_scatter(x, y):
    correlacao_val = correlacao(x, y)

    b0, b1, y_regressao = regressao(x, y)

    titulo_completo = f'Correlação: {round(correlacao_val, 5)}, B0: {round(b0, 5)}, B1: {round(b1, 5)}'

    df = pd.DataFrame({'x': x, 'y': y})

    fig = px.scatter(df, x='x', y='y', title=titulo_completo)

    fig.add_scatter(x=df['x'], y=y_regressao, mode='lines', name='Regressão Linear', line=dict(color='red'))

    fig.show()


plotar_scatter(x1, y1)
plotar_scatter(x2, y2)
plotar_scatter(x3, y3)

# Qual dos datasets não é apropriado para regressão linear?
# R:
# O dataset 01 é apropriado.
# Os dados do dataset 02 apresentam uma tendência parabólica, o que indica uma curvatura nos pontos. Isso indica que estamos lidando com um problema polinomial, não apenas linear.
# O dataset 3 não é apropriado pois muitos dados (a maioria) é igual, não existindo um variação. Desse forma, não é possível identificar uma correlação entre as variáveis. O alto inidice de correlação se da por um elemento outlier que acaba trazendo um falso positivo.
