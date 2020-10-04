package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.List;

public class MatrixService {
    Matrix matrix;

    public void createMatrix(int numOfRows) {
        matrix = new Matrix(numOfRows);
    }

    public void fillMatrix(List<List<String>> matrix) {
        this.matrix.setMatrix(matrix);
    }

    public ArrayList<String> getUniqueOperations() throws NullPointerException {
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
        return uniqueOperations;
    }
}
