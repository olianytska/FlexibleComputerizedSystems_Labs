package com.vlados.FirstLab;

public class Controller {
    private static final MatrixService matrixService = new MatrixService();
    private static final View view = new View();
    private static final TestData testData = new TestData();
    public void run() {
//        int rows = view.getNumOfRows();
//        matrixService.createMatrix(rows);
//        matrixService.fillMatrix(view.getMatrixFromUser(rows));
//        matrixService.setUniqueOperations();
//        System.out.println(matrixService.getUniqueOperations());
//        Integer[][] adjacencyMatrix = matrixService.getAdjacencyMatrix();
        view.printMatrix(testData.adjacencyMatrix4);
        view.printGroups(matrixService.getGroups(testData.adjacencyMatrix3));

    }
}
