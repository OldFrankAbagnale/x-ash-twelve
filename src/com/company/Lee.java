package com.company;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public  class Lee
{
    int field[][];
    Lee(int[][] matrix)
    {
        this.field=matrix;
    }
    // M x N матрица
    final int M=10;
    final int N=10;
   /* Lee(int[][] mat)
    {
        this.M =mat.length; // количество строк (вниз)
        this.N=mat[0].length; // количесвто столбцов (вправо)
    }*/
    // вспомогательные массивы
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    // Функция проверки доступности (row, col)
    // с текущей позиции. Возвращает false если (row, col)
    // за границами ИЛИ в ней 0 ИЛИ уже посещена
    private static void PrintMatrix(int[][] mat)
    {
        for (int[] line : mat) {
            for (int i : line) {
                System.out.printf("%2d", i);
            }
            System.out.print("\n");

        }
    }
    public static void PrintMatrixAccessibility(int[][] mat, Node a, Node b)
    {   System.out.print("\n");
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat[i].length ; j++) {
                if (i == a.y && j==a.x)
                {
                    System.out.printf("\u001B[34m"); //синий
                    System.out.printf("%2d", mat[i][j]);
                    continue;
                }
                if (i == b.y && j==b.x)
                {
                    System.out.printf("\u001B[31m"); //red
                    System.out.printf("%2d", mat[i][j]);
                    continue;
                }

                if (mat[i][j] > 0) {
                    System.out.printf("\u001B[32m");
                    System.out.printf("%2d", mat[i][j]);
                } else {
                    System.out.printf("\u001B[0m");
                    System.out.printf("%2d", mat[i][j]);
                }

            }
            System.out.print("\n");
        }
    }

    public static void PrintMatrixPoint(int[][] mat, Node a, Node b)
    {   System.out.print("\n");
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j < mat[i].length ; j++) {
                if (i == a.y && j==a.x)
                {
                    System.out.printf("\u001B[34m"); //синий
                    System.out.printf("%2d", mat[i][j]);
                    continue;
                }
                if (i == b.y && j==b.x)
                {
                    System.out.printf("\u001B[31m"); //red
                    System.out.printf("%2d", mat[i][j]);
                    continue;
                }

                if (mat[i][j] > 0) {
                    System.out.printf("\u001B[32m");
                    System.out.printf("%2d", mat[i][j]);
                } else {
                    System.out.printf("\u001B[0m");
                    System.out.printf("%2d", mat[i][j]);
                }

            }
            System.out.print("\n");
        }
    }

    private boolean isValid(int mat[][], boolean visited[][], int row, int col)
    {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N)
                && mat[row][col] == 1 && !visited[row][col];
    }


    // Ищем наиболее короткий путь
    // из  клетки (i, j) в клетку (x, y)
    public void BFS(int mat[][], int i, int j, int x, int y)
    {
        // матрица посещенных вершин
        boolean[][] visited = new boolean[M][N];

        // пустая очередь
        Queue<Node> q = new ArrayDeque<>();

        // отмечаем нацальную клетку как посещеную, добавляем ее в очередь
        visited[i][j] = true;
        q.add(new Node(i, j, 0));

        // храним самый короткий путь, инициализируем большим числом
        int min_dist = Integer.MAX_VALUE;

        // цикл пока очередь не пуста
        while (!q.isEmpty())
        {
            // извлекаем фронт и обрабатываем его
            Node node = q.poll();

            // (i, j) координаты текущей клетки и ее
            // минимальное расстояние до начала
            i = node.x;
            j = node.y;
            int dist = node.dist;

            // если дошли до пункта назначения, обновляем дистанцию
            if (i == x && j == y)
            {
                min_dist = dist;
                break;
            }

            // проверяем все 4 направления из текущей клетки
            // добавляем в очередь все доступные движения
            for (int k = 0; k < 4; k++)
            {
                //  проверка доступности
                // (i + row[k], j + col[k]) с текущей позиции
                if (isValid(mat, visited, i + row[k], j + col[k]))
                {
                    // помечаем следующую клетку и добавляем ее в очередь
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.print("Самый короткий путь " +
                    "имеет длинну " + min_dist);
        }
        else {
            System.out.print("Точка не может быть достигнута");
        }
    }
    private LinkedList<Node> backtraceFromGoal(Node Target, Node Start) {

       // ArrayList pathList = new ArrayList<Node>();
        LinkedList<Node> pathList = new LinkedList<>();

        pathList.add(Target);
        Node currentNode = null;
        /*ЕСЛИ финишная ячейка помечена
        ТО
        перейти в финишную ячейку
        ЦИКЛ
        выбрать среди соседних ячейку, помеченную числом на 1 меньше числа в текущей ячейке
        перейти в выбранную ячейку и добавить её к пути
        ПОКА текущая ячейка — не стартовая
        ВОЗВРАТ путь найден
                ИНАЧЕ
        ВОЗВРАТ путь не найден*/


        return pathList;
    }


    // кратчайший путь в лабиринте

}