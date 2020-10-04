package com.vlados.FirstLab;

public class Controller {
    private static final MatrixService matrixService = new MatrixService();
    private static final View view = new View();

    public void run() {
        int rows = view.getNumOfRows();
        matrixService.createMatrix(rows);
        matrixService.fillMatrix(view.getMatrixFromUser(rows));
//        System.out.println(matrixService.getUniqueOperations());
    }
}
