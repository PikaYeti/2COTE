package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baechu {
	
	static boolean ifbc(int x, int y, int row, int col) {
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(bf.readLine());
		
		for (int t = 0 ; t < tc ; t++) {
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Queue<int[]> zirung = new LinkedList<>();
			
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			
			int [][] baechu = new int [row][col];
			int [][] visit = new int [row][col];
			int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			
			int n = Integer.parseInt(st.nextToken());
			
			for (int i = 0 ; i < n ; i++) {
				StringTokenizer st1 = new StringTokenizer(bf.readLine());
				int c = Integer.parseInt(st1.nextToken());
				int r = Integer.parseInt(st1.nextToken());
				baechu[r][c] = 1;
			}
			
			int sum = 0;
			
			for (int i = 0 ; i < row ; i ++) {
				for (int j = 0 ; j < col ; j++) {
					if ((baechu[i][j] != 0) && (visit[i][j] != 1)) {
						zirung.add(new int[] {i, j});
						while(!zirung.isEmpty()) {
							int [] rung = zirung.poll();
							visit[rung[0]][rung[1]] = 1;
							for (int [] d : dir) {
								int dx = rung[0] + d[0];
								int dy = rung[1] + d[1];
								if (ifbc(dx, dy, row, col)) {
									if ((baechu[dx][dy] != 0) && (visit[dx][dy] != 1)) {
										zirung.add(new int[] {dx, dy});
									}
								}
							}
						}
						sum += 1;
					}
				}
			}
			
			System.out.println(sum);
			
		}

	}

}
