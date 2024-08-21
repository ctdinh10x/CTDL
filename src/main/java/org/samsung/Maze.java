package org.samsung;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    int[][] A;
    int n,m, startRow, startCol;
    boolean[][] visited;

    public void loadData() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String line = in.readLine();
            String[] s = line.split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            startRow = Integer.parseInt(s[2]);
            startCol = Integer.parseInt(s[3]);
            A = new int[n+1][m+1];
            for (int i = 1; i <= n; i++) {
                line = in.readLine();
                s = line.split(" ");
                for (int j = 1; j <= m; j++) {
                    A[i][j] = Integer.parseInt(s[j-1]);
                }
            }
            in.close();
        }catch (Exception ex){}
    }
    public boolean checkTarget(int r, int c) {
        return r < 1 || r > n || c < 1 || c > m;
    }
    public int search() {
        visited = new boolean[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) visited[i][j] = false;
        }
        Queue<Position2> Q = new LinkedList<>();
        Position2 start = new Position2(startRow, startCol, 0);
        Q.add(start);
        visited[start.r][start.c] = true;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!Q.isEmpty()) {
            Position2 p = Q.poll();
            for (int k = 0; k < 4; k++) {
                int newR = p.r + dr[k];
                int newC = p.c + dc[k];
                if (checkTarget(newR, newC)) return p.s + 1;
                if (A[newR][newC] == 0 && visited[newR][newC] == false) {
                    Position2 np = new Position2(newR, newC, p.s + 1);
                    Q.add(np);
                    visited[newR][newC] = true;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Maze app = new Maze();
        app.loadData();
        System.out.println(app.search());;
    }
}

class Position2 {
    public int r;
    public int c;
    public int s;

    public Position2(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}