package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupService {
    Matrix matrix;
    List<Set<Integer>> groups;

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public List<Set<Integer>> getGroups() {
        return groups;
    }

    public void setGroups(List<Set<Integer>> groups) {
        this.groups = groups;
    }

//    public List<ArrayList<String>> getOperationGroups() {
//        List<ArrayList<String>> operationGroups = new ArrayList<>();
//        for (Set<Integer> group: groups) {
//            for (Integer elem : group) {
//                matrix.getMatrix().get()
//            }
//        }
//        return operationGroups;
//    }

}
