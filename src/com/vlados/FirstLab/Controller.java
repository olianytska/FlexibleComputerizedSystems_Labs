package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controller {
    private static final MatrixService matrixService = new MatrixService();
    private static final View view = new View();
    private static final TestData testData = new TestData();
    private static final  GroupService groupService = new GroupService();
    public void run() {
        int rows = view.getNumOfRows();
        matrixService.createMatrix(rows);
        matrixService.fillMatrix(view.getMatrixFromUser(rows));
        matrixService.setUniqueOperations();
        System.out.println(matrixService.getUniqueOperations());
        Integer[][] adjacencyMatrix = matrixService.getAdjacencyMatrix();
        view.printMatrix(adjacencyMatrix);
        List<ArrayList<Integer>> groups = matrixService.getGroups(adjacencyMatrix);
        view.printGroups(groups);

        groupService.setMatrix(matrixService.getMatrix());
        groupService.setGroups(groups);

        List<ArrayList<String>> groupElements = groupService.getOperationGroups();
        view.printGroups(groupElements);

//        List<ArrayList<String>> sortedGroupElements = groupService.sortOperationGroups(groupElements, groups);
//        view.printGroups(sortedGroupElements);
//
//        view.printGroups(groupService.absorbGroups());
    }
}
