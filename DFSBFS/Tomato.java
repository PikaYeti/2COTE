package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	
	static boolean ifto(int x, int y, int row, int col) {
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		int[][] tbox = new int [row][col];
		int[][] visit = new int [row][col];
		int[][] dir = new int [][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		Queue<int[]> tomato = new LinkedList<>();
		
		int zero = 0;
		int day = 0;
		
		for (int i = 0 ; i < row ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < col ; j++) {
				tbox[i][j] = Integer.parseInt(st1.nextToken());
				if (tbox[i][j] == 0) {
					zero += 1;
				}
			}
		}
		while (zero > 0) {
			
		}
		if (zero != 0) {
			while( zero <= 0) {
				if (tomato.isEmpty()) {
					for (int i = 0 ; i < row ; i++) {
						for (int j = 0 ; j < col ; j++) {
							if ((tbox[i][j] == 1) && (visit[i][j] != 1)) {
								visit[i][j] = 1;
								for (int[] d : dir) {
									int dx = i + d[0];
									int dy = j + d[1];
									if (ifto(dx, dy, row, col)) {
										if ((tbox[dx][dy] == 0) && (visit[dx][dy] != 1)) {
											zero --;
											tbox[dx][dy] = 1;
											tomato.add(new int[] {dx, dy});
										}
									}
								}
							}
						}
					}
				}
				
				if (tomato.size() == 0) {
					break;
				}
				
				while(!tomato.isEmpty()) {
					int cntto = tomato.size();
					int cnt = 0;
					System.out.println(cntto);
					while(cnt < cntto) {
						int [] toma = tomato.poll();
						visit[toma[0]][toma[1]] = 1;
						for (int[] d : dir) {
							int dx = toma[0] + d[0];
							int dy = toma[1] + d[1];
							if (ifto(dx, dy, row, col)) {
								if ((tbox[dx][dy] == 0) && (visit[dx][dy] != 1)) {
									zero --;
									tbox[dx][dy] = 1;
									tomato.add(new int[] {dx, dy});
								}
							}
						}
						System.out.println(cnt);
						cnt ++;
					}
				}
				
				
			}
		} else { // 처음부터 토마토가 모두 완전히 익어있는 상태
			System.out.println(0);
		}
		
		System.out.println("끝");
		

	}

}
