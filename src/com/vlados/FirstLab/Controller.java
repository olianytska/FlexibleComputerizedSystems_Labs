package com.vlados.FirstLab;

public class Controller {
    private static final MatrixService matrixService = new MatrixService();
    private static final View view = new View();

    public void run() {
        int rows = view.getNumOfRows();
        matrixService.createMatrix(rows);
        matrixService.fillMatrix(view.getMatrixFromUser(rows));
        matrixService.setUniqueOperations();
        System.out.println(matrixService.getUniqueOperations());
        view.printMatrix(matrixService.getAdjacencyMatrix());
        System.out.print(matrixService.getGroups(matrixService.getAdjacencyMatrix()));
    }
}
