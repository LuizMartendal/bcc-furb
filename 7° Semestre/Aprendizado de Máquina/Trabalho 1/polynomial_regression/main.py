import numpy as np
import pandas as pd

from polynomial_regression import PolynomialRegression


def show_by_degree(x_test, y_test, x_train, y_train, degree):
    model = PolynomialRegression(degree)
    model.fit(x_train, y_train)
    error = model.mse(x_train, y_train)
    print(f'Degree {degree}: MSE = {error}')
    model.plot(x_train, y_train)


def compare_degrees(x_test, y_test, x_train, y_train):
    show_by_degree(x_test, y_test, x_train, y_train, 1)
    show_by_degree(x_test, y_test, x_train, y_train, 2)
    show_by_degree(x_test, y_test, x_train, y_train, 3)
    show_by_degree(x_test, y_test, x_train, y_train, 8)


def build_test_set(X, y):
    indices = np.arange(len(X))
    np.random.shuffle(indices)

    X = X[indices]
    y = y[indices]

    split_index = int(0.9 * len(X))

    x_train = X[:split_index]
    y_train = y[:split_index]

    x_test = X[split_index:]
    y_test = y[split_index:]

    return x_test, y_test, x_train, y_train


def demo_regressaop():
    data = pd.read_csv('data_preg.csv').to_numpy()
    X = data[:, 0]
    y = data[:, 1]

    x_test, y_test, x_train, y_train = build_test_set(X, y)

    compare_degrees(x_test, y_test, x_train, y_train)


demo_regressaop()
