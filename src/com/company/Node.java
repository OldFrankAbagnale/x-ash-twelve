package com.company;

public class Node
{
    // (x, y) координаты
    // dist - минимальная дистанция
    int x, y, dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = 0;
    }
};