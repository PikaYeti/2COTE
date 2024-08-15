package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {
	
	static int row;
	static int col;
	
	static boolean ifvirus(int x, int y) { // 바이러스 실험관 밖으로 나갔는지 확인하는 함수
		if (((0 <= x) && (x < row)) && ((0 <= y) && (y < col))) {
			return true;
		} else {
			return false;
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] virus = new int[n][n]; // 바이러스 값이 들어올 배열 설정
		
		row = virus.length; // 세로길이 설정
		col = virus[0].length; // 가로길이 설정
		
		Queue<int[]> wvirus = new LinkedList<>(); // 바이러스 값, 바이러스 x좌표, 바이러스 y좌표 넣을 큐 선언
		int [][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 사방탐색 위한 배열 선언 후 값 추가
		int cv = 0; // 바이러스가 배열에 얼마나 포진해있는지 확인하기 위한 변수
		
		for (int i = 0 ; i < virus.length ; i++) {
			StringTokenizer v = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < virus[0].length ; j++) {
				virus[i][j] = Integer.parseInt(v.nextToken());
				if (virus[i][j] != 0) {
					wvirus.add(new int[] {i, j, virus[i][j]}); // 바이러스 x, y 좌표와 무슨 바이러스인지 큐에 넣기
					cv += 1; // 바이러스가 존재하면 +1
				}
			}
		}
		
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		int s = Integer.parseInt(st1.nextToken()); // 초
		int x = Integer.parseInt(st1.nextToken()); // 찾을 x좌표
		int y = Integer.parseInt(st1.nextToken()); // 찾을 y좌표
		
		int cnt = 0; // 더이상 바이러스가 사방으로 퍼지지 못할때 큐에서 값이 삭제되는데 poll에서 오류나지 않게 하기 위해 큐 사이즈 측정해주는 변수 선언
		
		for (int i = 0 ; i < s ; i++) { // 시간 for 문 설정
			
			if (wvirus.size() == 0) { // 만약 큐에 아무것도 들어가있지 않다면 탐색할 곳이 없는것이므로 바로 종료
				break;
			}

			for (int l = 1 ; l <= k ; l ++) { // 1부터 k까지 바이러스 찾기 위해 for문 설정 -> 작은 바이러스 순서대로 증식해야 하므로 for문
				int a = 0; // 큐 몇번째까지 돌았는지 확인하기 위해 배열 선언
				cnt = wvirus.size(); // cnt를 큐 사이즈로 설정
				while (a < cnt) { // 현재 큐 사이즈 만큼만 while문 돌도록 설정
					int [] cl = wvirus.poll(); // 큐에서 x, y, 바이러스 값 빼주고
					if (cl[2] == l) { // 만약 큐에서 뺀 값이 현재 증식가능한 바이러스라면
						for (int z = 0 ; z < dir.length ; z++) { // 사방탐색
							int vx = cl[0] + dir[z][0];
							int vy = cl[1] + dir[z][1];
							if (ifvirus(vx, vy)) { // 시험관 안쪽이고
								if (virus[vx][vy] == 0) { // 바이러스가 증식되지 않은 칸 이라면
									cv += 1; // 현재 포진된 바이러스 값 +1
									virus[vx][vy] = cl[2]; // 증식시켜주기
									wvirus.add(new int[] {vx, vy, cl[2]}); // 다시 사방탐색 돌리기 위해 큐에 넣기
								}
							}
						}
	
					}
					else {
						wvirus.add(cl); // 현재 증식 불가능한 바이러스라면 다시 큐에 넣기
					}
					a += 1; // 큐 돈 횟수 +1
				}
			}
			

			
			if (cv >= (row * col)) { // 만약 바이러스 포진 수가 현재 배열 넓이보다 커지거나 같아지면 for문 종료
				break;
			}
		}
		
		System.out.println(virus[x - 1][y - 1]);


	}

}
