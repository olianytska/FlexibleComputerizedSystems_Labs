package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.List;

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

    public List<List<Integer>> getGroups(Integer[][] adjacencyMatrix) {
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> operations = new ArrayList<>();
        for(int i = 0; i < adjacencyMatrix.length; i++) {
            operations.add(i+1);
        }
        List<int[]> coords = new ArrayList<>();
        int maxElem = -1;
        int maxElemRow = -1;
        int maxElemColumn = -1;
        do {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    if(adjacencyMatrix[i][j] > maxElem) {
                        maxElem = adjacencyMatrix[i][j];
                        maxElemRow = i;
                        maxElemColumn = j;
                    }
                }
            }
            coords.add(new int[]{maxElemRow, maxElemColumn});
            for(int i = 0; i < coords.size(); i++) {
                for (int j = 0; j < adjacencyMatrix.length; j ++) {
                    if (adjacencyMatrix[coords.get(i)[0]][j] == maxElem)
                        coords.add(new int[]{coords.get(i)[0], j});
                    if (adjacencyMatrix[j][coords.get(i)[0]] == maxElem)
                        coords.add(new int[]{j, coords.get(i)[0]});
                }
            }
            groups.add(new ArrayList<>());
            for (int[] coord : coords) {
                if (!groups.get(groups.size() - 1).contains(coord[0] + 1)) {
                    groups.get(groups.size() - 1).add(coord[0] + 1);
                }
                if (!groups.get(groups.size() - 1).contains(coord[1] + 1)) {
                    groups.get(groups.size() - 1).add(coord[1] + 1);
                }
            }
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int k = 0; k < groups.get(groups.size()-1).size(); k++) {
                    adjacencyMatrix[k][i] = 0;
                    adjacencyMatrix[i][k] = 0;
                    operations.remove((Integer) k);
                }
            }

        } while(maxElem != 0);
        if(operations.size() == 1) groups.add(new ArrayList<>(operations.get(0)));
        return groups;
    }
}
