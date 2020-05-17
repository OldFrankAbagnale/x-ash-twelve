package com.company;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[][] mat =
                {
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                        { 2, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
                        { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                        { 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 },


                };
        System.out.println(mat.length);
        System.out.println(mat[0].length);

         /*System.out.println(mat.length);
         System.out.println(mat[0].length);*/
        // Кратчайший путь из (0, 0) в
        // точку (7, 5)
        Lee solver1 = new Lee(mat);

        Node a = new Node(0,0);
        Node b = new Node(9,9);
        solver1.BFS(mat,0,0,9,9);

        Lee.PrintMatrixAccessibility(mat,a,b);



    }
}
