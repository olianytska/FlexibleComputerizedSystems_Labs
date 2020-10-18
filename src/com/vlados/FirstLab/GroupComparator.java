package com.vlados.FirstLab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class GroupComparator implements Comparator<ArrayList<String>> {
    @Override
    public int compare(ArrayList<String> list1, ArrayList<String> list2) {
        return  list2.size() - list1.size();
    }
}
