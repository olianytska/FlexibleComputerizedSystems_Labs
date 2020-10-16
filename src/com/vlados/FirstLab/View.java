package com.vlados.FirstLab;

import java.util.*;

public class View {
    private String getUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public int getNumOfRows() {
        return Integer.parseInt(getUsersLine());
    }

    public List<List<String>> getMatrixFromUser(int numOfRows) {
        List<List<String>> matrix = new ArrayList<>();
        for(int i = 0; i < numOfRows; i++) {
            matrix.add(new ArrayList<>(Arrays.asList(getUsersLine().split(" "))));
        }
        return matrix;
    }

    public <T> void printMatrix(T[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printGroups(List<Set<Integer>> groups) {
        for(Set<Integer> group : groups) {
            System.out.println(group);
        }
    }
}
