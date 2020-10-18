package com.vlados.FirstLab;

import java.util.*;

public class MatrixService {
    private Matrix matrix;
    private List<String> uniqueOperations;


    public void createMatrix(int numOfRows) {
        matrix = new Matrix(numOfRows);
    }

    public void fillMatrix(List<List<String>> matrix) {
        this.matrix.setMatrix(matrix);
    }

    public void setUniqueOperations() throws NullPointerException {
        ArrayList<String> uniqueOperations = new ArrayList<>();
        List<String> row;
        for (int i = 0; i < matrix.getNumOfRows(); i++) {
            row = matrix.getMatrix().get(i);
            for(String operation : row) {
                if(!uniqueOperations.contains(operation)) {
                    uniqueOperations.add(operation);
                }
            }
        }
        this.uniqueOperations = uniqueOperations;
    }

    public List<String> getUniqueOperations() {
        return uniqueOperations;
    }

    public Integer[][] getAdjacencyMatrix() {
        Integer[][] intermediateMatrix = new Integer[this.matrix.getNumOfRows()][this.uniqueOperations.size()];
        for (int i = 0; i < intermediateMatrix.length; i++) {
            for (int j = 0; j < intermediateMatrix[i].length; j++) {
                intermediateMatrix[i][j] = matrix.getMatrix().get(i).contains(this.uniqueOperations.get(j)) ? 1 : 0;
            }
        }
//        return intermediateMatrix;
        Integer[][] adjacencyMatrix = new Integer[matrix.getNumOfRows()][matrix.getNumOfRows()];
        int count = 0;
        for (int i = 0; i < intermediateMatrix.length - 1; i++) {
            for (int j = i + 1; j < intermediateMatrix.length; j++) {
                for(int k = 0; k < uniqueOperations.size(); k++) {
                    if(intermediateMatrix[i][k] + intermediateMatrix[j][k] == 1) {
                        count++;
                    }
                }
                adjacencyMatrix[j][i] = count;
                adjacencyMatrix[i][j] = 0;
                count = 0;
            }
        }
      for(int i = 0; i < adjacencyMatrix.length; i++) {
          adjacencyMatrix[i][i] = 0;
      }
      return  adjacencyMatrix;
    }

    public List<Set<Integer>> getGroups(Integer[][] adjacencyMatrix) {
        List<Set<Integer>> groups = new ArrayList<>();
        List<Integer> operations = new LinkedList<>();
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            operations.add(i+1);
        }
        List<Point> coordinates = new ArrayList<>();
        int maxElem;
        int maxElemRow;
        int maxElemColumn;
        int row;
        int column;
        do {
            maxElem = 0;
            maxElemRow = -1;
            maxElemColumn = -1;
            //шукаємо максимальний елемент та його координати
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    if(adjacencyMatrix[i][j] > maxElem) {
                        maxElem = adjacencyMatrix[i][j];
                        maxElemRow = i;
                        maxElemColumn = j;
                    }
                }
            }
            if (maxElem == 0) break;
            //додаємо координати максимального елемента в
            coordinates.add(new Point(maxElemRow, maxElemColumn));
            //шукаємо ще максимальні елемени в рядку/стовпці, де було знайдено перший максимальний елемент
            
            for (int i = 0; i < coordinates.size(); i++) {
                for (int j = 0; j < adjacencyMatrix.length; j ++) {
                    if (adjacencyMatrix[coordinates.get(i).getRow()][j] == maxElem
                            && !coordinates.contains(new Point(coordinates.get(i).getRow(), j)))
                    coordinates.add(new Point(coordinates.get(i).getRow(), j));
                    if (adjacencyMatrix[j][coordinates.get(i).getColumn()] == maxElem
                            && !coordinates.contains(new Point(j, coordinates.get(i).getColumn())))
                        coordinates.add(new Point(j, coordinates.get(i).getColumn()));
                }
            }
            //додаємо нову групу
            groups.add(new HashSet<>());
            for (Point coord : coordinates) {
                if(!groups.isEmpty()) {
                    groups.get(groups.size() - 1).add(coord.getRow() + 1);
                    groups.get(groups.size() - 1).add(coord.getColumn() + 1);
                }
            }
            coordinates.clear();
            //обнуляємо рядок/стовпець відповідно до груп
            for (Integer elem : groups.get(groups.size() - 1)) {
                 for (int i = 0; i < adjacencyMatrix.length; i++) {
                    adjacencyMatrix[elem - 1][i] = 0;
                    adjacencyMatrix[i][elem - 1] = 0;
//                    operations.remove(k);
                }
            }
            operations.removeAll(groups.get(groups.size() - 1));
        } while(maxElem != 0);
        if(operations.size() == 1) groups.add(new HashSet<>(operations));
        return groups;
    }
}
