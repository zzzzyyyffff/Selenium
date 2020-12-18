package com.po.page;

import java.util.ArrayList;

public class Arraylist {
    public static void main(String ars[]) {
//
//      ArrayList<ArrayList<Integer> > list=new ArrayList<ArrayList<Integer> >();
//      ArrayList<Integer> ss=new ArrayList<Integer>();
//      ArrayList<Integer> ss1=new ArrayList<Integer>();
//      ss.add(1);
//      ss.add(5);
//      ss.add(6);
//      list.add(ss);
//      ss1.add(8);
//      ss1.add(7);
//      list.add(ss1);
//      System.out.print(list);
//    }
        int arr[][] = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " + ");
            }
            System.out.println("   ");
        }
    }
}