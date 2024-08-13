package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 분기마다 값 구하기
public class Miro {
	
	static boolean ifmiro(int x, int y, int n, int m) {
		if (((0 <= x) && (x < n)) && ((0 <= y) && (y < m))) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		Queue<int[]> inmiro = new LinkedList<>();
		
		int n = Integer.parseInt(st.nextToken()); // 가로 / 세로 길이 받기
		int m = Integer.parseInt(st.nextToken());
		
		int [][] miro = new int[n][m];
		int [][] visit = new int[n][m];
		int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int cnt = 0;
		
		for (int i = 0 ; i < n ; i ++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < m ; j ++) {
				miro[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		int dx = 0, dy = 0;
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				if ((miro[i][j] == 1) && (visit[i][j] == 0)) { // 만약 괴물이 없고 방문하지 않은 곳이라면
					visit[i][j] = 1; // 방문 표시 띡
					inmiro.add(new int[]{i, j}); // 큐에 넣어 사방으로 갈 수 있는 곳 탐색
					while(!inmiro.isEmpty()) { // 큐가 비지 않을 때 까지
						int [] nextmiro = inmiro.poll(); // 넣었던 좌표 빼주기
						for (int[] e : dir) { // 사방 탐색하기
							dx = nextmiro[0] + e[0]; // 갈 방향으로 좌표 설정
							dy = nextmiro[1] + e[1];
							if (ifmiro(dx, dy, n, m)) { // 만약 미로를 나가지 않는다면
								if ((miro[dx][dy] == 1) && (visit[dx][dy] == 0)) { // 그리고 그 좌표가 괴물이 있고 방문하지 않은 곳이라면
									visit[dx][dy] = 1; // 방문 표시 띡
									miro[dx][dy] = miro[nextmiro[0]][nextmiro[1]] + miro[dx][dy]; // 이동 경로 표시하기 위해 현재 좌표 값에 이전 좌표 값 더하기
									inmiro.add(new int[] {dx, dy}); // 현재 좌표를 큐에 넣기
								}
							}
						}
					}
				}
			}
		}
		System.out.println(miro[n -1][m -1]); // nm 좌표 출력하기
	}

}
