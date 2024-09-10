import numpy as np
import matplotlib.pyplot as plt
from IPython.display import clear_output
import random

COL_SIZE = 6
LINE_SIZE = 6

matrix: any

def main():
  global matrix
  generate_matrix()

  posAPAx = 0
  posAPAy = 0

  if (LINE_SIZE > 2) and (COL_SIZE > 2):
    posAPAx = np.random.choice([1, LINE_SIZE - 2])
    posAPAy = np.random.choice([1, COL_SIZE - 2])

  current_position = (posAPAx, posAPAy)

  show(current_position)

  while True:
    moviments = valid_moviments(current_position)

    if moviments == []:
      current_position = (posAPAx, posAPAy)
    else:
      current_position = random.choice(moviments)

    show(current_position)


def valid_moviments(current_position):
  x, y = current_position
  moviments = []

  if x > 1:
    if matrix[x - 1][y] == 2:
      return [(x - 1, y)]
    moviments.append((x - 1, y))
  if x < LINE_SIZE - 2:
    if matrix[x + 1][y] == 2:
      return [(x + 1, y)]
    moviments.append((x + 1, y))
  if y > 1:
    if matrix[x][y - 1] == 2:
      return [(x, y - 1)]
    moviments.append((x, y - 1))
  if y < COL_SIZE - 2:
    if matrix[x][y + 1] == 2:
      return [(x, y + 1)]
    moviments.append((x, y + 1))

  return moviments


def generate_matrix():
  global matrix
  matrix = np.zeros((LINE_SIZE, COL_SIZE), dtype=int)

  matrix[0, :] = 1
  matrix[-1, :] = 1
  matrix[:, 0] = 1
  matrix[:, -1] = 1

  if LINE_SIZE > 2 or COL_SIZE > 2:
    matrix[1:-1, 1:-1] = np.random.choice([0, 2], size=(LINE_SIZE-2, COL_SIZE-2))


def show(current_position):
  plt.pause(0.5)
  clear_output(wait=True)

  global matrix
  x, y = current_position

  matrix[x][y] = 0

  plt.imshow(matrix, 'gray')
  plt.nipy_spectral()

  plt.plot([y],[x], marker='o', color='r', ls='')

  plt.show(block=False)

  plt.pause(0.5)
  plt.clf()


if __name__ == "__main__":
  main()