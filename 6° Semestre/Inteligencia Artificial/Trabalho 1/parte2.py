import numpy as np
import matplotlib.pyplot as plt
from IPython.display import clear_output
import heapq
import random
from collections import deque

COLS = 10
ROWS = 10

matrix: any

def main():
  global matrix
  generate_matrix()

  posAPAx = 0
  posAPAy = 0

  if (ROWS > 2) and (COLS > 2):
    posAPAx = np.random.choice([1, ROWS - 2])
    posAPAy = np.random.choice([1, COLS - 2])

  current_position = (posAPAx, posAPAy)
  visited = set()

  show(current_position)

  dijkstra(matrix, current_position)


def dijkstra(matrix, start):
  queue = deque([start])
  visited = set()
  directions = [
    (0, 1), (1, 0), (0, -1), (-1, 0)
  ]

  while queue:
    x, y = queue.popright()

    if (x, y) in visited:
      continue

    visited.add((x, y))

    if matrix[x][y] == 2:
      matrix[x][y] = 0

    show((x, y))

    for dx, dy in directions:
      nx, ny = x + dx, y + dy
      if (nx, ny) not in visited and matrix[nx][ny] != 1:
        queue.append((nx, ny))
        x = dx
        y = dy
        if matrix[nx][ny] == 2:
          continue


def valid_moviments(current_position):
  x, y = current_position
  moviments = []

  if x > 1:
      moviments.append((x - 1, y))
  if x < ROWS - 2:
      moviments.append((x + 1, y))
  if y > 1:
      moviments.append((x, y - 1))
  if y < COLS - 2:
      moviments.append((x, y + 1))

  return moviments


def generate_matrix():
  global matrix
  matrix = np.zeros((ROWS, COLS), dtype=int)

  matrix[0, :] = 1
  matrix[-1, :] = 1
  matrix[:, 0] = 1
  matrix[:, -1] = 1

  if ROWS > 2 or COLS > 2:
    matrix[1:-1, 1:-1] = np.random.choice([0, 2], size=(ROWS-2, COLS-2))


def show(current_position):
  plt.pause(0.5)
  clear_output(wait=True)

  global matrix
  x, y = current_position

  plt.imshow(matrix, 'Blues')
  plt.nipy_spectral()

  plt.plot([y],[x], marker='o', color='r', ls='')

  plt.show(block=False)

  plt.pause(0.5)
  plt.clf()


if __name__ == "__main__":
  main()