package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    private int numOfRows;
    private List<List<String>> matrix = new ArrayList<>();

    {
        for (int i = 0; i < numOfRows; i++) {
            matrix.add(new ArrayList<>());
        }
    }

    public Matrix(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public List<List<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<String>> matrix) {
        this.matrix = matrix;
    }
}
