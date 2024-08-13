package com.ssafy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game {
	
	static boolean ifmap (int x, int y, int row, int col) {
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		int [][] map = new int [Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		int [][] visit = new int [map.length][map[0].length];
		int [][] dir = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		int cx = Integer.parseInt(st1.nextToken());
		int cy = Integer.parseInt(st1.nextToken());
		int cd = Integer.parseInt(st1.nextToken());
		
		visit[cx][cy] = 1;
		
		for (int i = 0 ; i < map.length ; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < map[1].length ; j ++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int dx = 0, dy = 0, d = 0, cnt = 1;
		
		while (true) {
			cd += 1;
			
			if (cd > 3) {
				cd = 0;
			}
			
			dx = cx + dir[cd][0];
			dy = cy + dir[cd][1];
			if ((map[dx][dy] == 0) && (visit[dx][dy] == 0)) {
				cx = dx;
				cy = dy;
				visit[cx][cy] = 1;
				cnt++;
			} else {
				d += 1;
			}
			
			if (d == 4) {
				if (cd <= 1) {
					if (map[cx +dir[cd + 2][0]][cy + dir[cd + 2][1]] == 1) {
						break;
					} else {
						cx = cx + dir[cd + 2][0];
						cy = cy + dir[cd + 2][1];
						visit[cx][cy] = 1;
						d = 0;
					}
				}
				else {
					if (map[cx +dir[cd - 2][0]][cy + dir[cd - 2][1]] == 1) {
						break;
					} else {
						cx = cx + dir[cd - 2][0];
						cy = cy + dir[cd - 2][1];
						visit[cx][cy] = 1;
						d = 0;
					}
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
	}

}
