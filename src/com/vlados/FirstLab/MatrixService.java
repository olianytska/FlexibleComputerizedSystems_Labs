package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.Arrays;
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
}
