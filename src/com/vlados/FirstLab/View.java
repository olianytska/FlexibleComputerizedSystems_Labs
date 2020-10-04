package com.vlados.FirstLab;

import java.util.Scanner;

public class View {
    private String getUsersLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public int getNumOfRows() {
        return Integer.parseInt(getUsersLine());
    }
}
