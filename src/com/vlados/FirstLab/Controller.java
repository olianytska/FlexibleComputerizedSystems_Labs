package com.vlados.FirstLab;

import java.util.Set;

public class Controller {
    private static final MatrixService matrixService = new MatrixService();
    private static final View view = new View();

    public void run() {
//        int rows = view.getNumOfRows();
//        matrixService.createMatrix(rows);
//        matrixService.fillMatrix(view.getMatrixFromUser(rows));
//        matrixService.setUniqueOperations();
//        System.out.println(matrixService.getUniqueOperations());
//        view.printMatrix(matrixService.getAdjacencyMatrix());
        for(Set<Integer> group : matrixService.getGroups(matrixService.adjacencyMatrix2)) {
            System.out.print(group);
        }

    }
}
