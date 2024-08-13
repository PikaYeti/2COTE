package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Juice {

	static boolean ifice (int x, int y, int n, int m) {
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
		
		Queue<int[]> iceQ = new LinkedList<>(); // 현재 위치에서 사방탐색하여 아직 가지 않은곳 찾기 위해 queue 선언
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [][] ice = new int[n][m];
		int [][] visit = new int[n][m];
		int [][] dir = new int[][] {{-1 , 0}, {1, 0}, {0, -1}, {0, 1}}; // 현재 위치에서 사방탐색하기 위해 dir 배열 선언
		
		for (int i = 0 ; i < n ; i ++) {
			StringTokenizer freeze = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < m ; j ++) {
				ice[i][j] = Integer.parseInt(freeze.nextToken());
			}
		}
		
		int dx = 0, dy = 0; // 다음 위치 설정해 주기 위해 변수 선언
		int cnt = 0; // 정답 카운트할 변수 선언
		
		for (int i = 0 ; i < n ; i ++) {
			for (int j = 0 ; j < m ; j ++) {
				if ((ice[i][j] == 0) && (visit[i][j] == 0)) { // 만약 구멍부분이고 방문하지 않은 곳이라면
					visit[i][j] = 1; // 방문표시 남겨주기
					iceQ.add(new int[] {i, j}); // 방문 인덱스 큐에 넣기
					while (!iceQ.isEmpty()) { // 큐가 비지 않을 때 까지
						int [] inice = iceQ.poll();
						for (int[] k : dir) { // 사방탐색 for문 돌리기
							dx = inice[0] + k[0]; // 탐색해야할 x, y 좌표 설정
							dy = inice[1] + k[1];
							if (ifice(dx, dy, n, m)) { // 좌표가 얼음틀안쪽인지 확인
								if ((ice[dx][dy] == 0) && (visit[dx][dy] == 0)) { // 만약 그 좌표가 구멍부분이고 방문하지 않은 곳이라면
									visit[dx][dy] = 1; // 방문 체크
									iceQ.add(new int[]{dx, dy}); // 그 위치에서 다시 사방탐색하기 위해 큐에 넣기
								}
							}
						}
					}
					cnt ++; // ice[i][j]가 0이라는것은 얼음이라는 뜻이므로 큐를 돌리던 말던 정답하나 올려주기

				}
			}
		}
		
		System.out.println(cnt);
		

	}

}
