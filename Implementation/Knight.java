package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knight {
	
	public static boolean chess(int x, int y) { // 이동한 경로가 체스판 위에 있는지 확인
		if (((0 <= x) && (x < 8)) && ((0 <= y) && (y < 8))) {
			return true; // 체스판 위면 true
		} else {
			return false; // 체스판 밖이면 false
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String word = new String(bf.readLine());
		
		int [][] ifmove = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
		// 이동가능한 경로를 배열에 넣어 설정
		
		int x = word.charAt(0) - 96 -1; // 문자열 앞이 char 이니 배열식으로 확인하기 위해 int로 바꿔 0부터 시작하도록 -1
		int y = word.charAt(1) - 48 -1; // 아스키숫자로 변환되니 -48후 0부터 시작되기 -1
		int answer = 0; // 답 변수 선언

		for(int i = 0 ; i < ifmove.length ; i ++) {
			
			int mx = x + ifmove[i][0]; // 이동한 좌표 값 구해주기
			int my = y + ifmove[i][1];
			if (chess(mx, my)) { // 체스판 위에 있는지 확인하고
				answer += 1; // 맞다면 +1
			}
		}
		
		System.out.println(answer);
		
	}

}
