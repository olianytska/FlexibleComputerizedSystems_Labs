package com.vlados.FirstLab;

import java.util.*;

public class GroupService {
    Matrix matrix;
    List<ArrayList<Integer>> groups;
    List<ArrayList<String>> operationGroups;


    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public List<ArrayList<Integer>> getGroups() {
        return groups;
    }

    public void setGroups(List<ArrayList<Integer>> groups) {
        this.groups = groups;
    }

    public List<ArrayList<String>> getOperationGroups() {
        List<ArrayList<String>> operationGroups = new ArrayList<>();
        for (ArrayList<Integer> group: groups) {
            operationGroups.add(new ArrayList<>());
            for (Integer groupElem : group) {
               for (int i = 0; i < matrix.getMatrix().get(groupElem - 1).size(); i++) {
                   if(!operationGroups.get(operationGroups.size() - 1).contains(matrix.getMatrix().get(groupElem - 1).get(i)))
                       operationGroups.get(operationGroups.size() - 1).add(matrix.getMatrix().get(groupElem - 1).get(i));
               }

            }
        }
        this.operationGroups = operationGroups;
        return operationGroups;
    }

    public List<ArrayList<String>> sortOperationGroups(List<ArrayList<String>> lists, List<ArrayList<Integer>> groups) {
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue(new GroupComparator()));

        for (int i = 0; i < lists.size() - 1; i++)
            for (int j = 0; j < lists.size() - i - 1; j++)
                if (lists.get(j).size() < lists.get(j+1).size()) {
                    ArrayList<String> temp = lists.get(j);
                    lists.set(j, lists.get(j+1));
                    lists.set(j+1, temp);

                    ArrayList<Integer> tempInt = groups.get(j);
                    groups.set(j, groups.get(j+1));
                    groups.set(j+1, tempInt);
                }
        this.groups = groups;
        this.operationGroups = lists;
        return  lists;
    }

    public List<ArrayList<String>> absorbGroups() {
        for (int i = 0; i < operationGroups.size() - 1; i++) {
            for (int j = i + 1; j < operationGroups.size(); j++) {
                if(operationGroups.get(i).containsAll(operationGroups.get(j))) {
                    groups.get(i).addAll(groups.get(j));
                    groups.remove(j);
                    operationGroups.remove(j);
                }
                else {
                    for(int k = 0; k < groups.get(j).size(); k++) {
                        if(operationGroups.get(i).containsAll(matrix.getMatrix().get(groups.get(j).get(k) - 1))) {
                            groups.get(i).add(groups.get(j).get(k));
//                            operationGroups.get(j).removeAll(matrix.getMatrix().get(groups.get(j).get(k) - 1));
                            operationGroups.get(j).clear();
                            for(int n = 0; n < groups.get(j).size(); n++) {
                                for (int m = 0; m < matrix.getMatrix().get(groups.get(j).get(n) - 1).size(); m++ ) {
                                    if(n != k &&
                                            !operationGroups.get(j).contains(matrix.getMatrix().get(groups.get(j).get(n) - 1).get(m))) {
                                        operationGroups.get(j).add(matrix.getMatrix().get(groups.get(j).get(n) - 1).get(m));
                                    }
                                }
                            }
                            groups.get(j).remove(k);//????????????
                        }
                    }
                }
            }
        }
        return operationGroups;
    }
}
