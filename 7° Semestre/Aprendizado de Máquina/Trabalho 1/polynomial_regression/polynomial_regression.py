import matplotlib.pyplot as plt
import numpy as np


class PolynomialRegression:
    def __init__(self, degree):
        self.degree = degree
        self.coefficients = None

    def fit(self, X, y):
        self.coefficients = np.polyfit(X, y, self.degree)

    def predict(self, X):
        return sum(coef * (X ** exp) for coef, exp in zip(self.coefficients, range(self.degree, -1, -1)))

    def mse(self, X, y):
        y_pred = self.predict(X)
        return np.mean((y - y_pred) ** 2)

    def plot(self, X, y):
        plt.scatter(X, y, color='blue', label='Data')
        X_sorted = np.linspace(min(X), max(X), 100)
        y_pred = self.predict(X_sorted)
        plt.plot(X_sorted, y_pred, color='yellow', label=f'Polynomial (degree {self.degree})')
        plt.legend()
        plt.title(f'Polynomial Regression (Degree {self.degree})')
        plt.show()
