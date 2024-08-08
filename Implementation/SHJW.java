package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SHJW {
	
	static Boolean inMap(int x, int y, int lng) { // 지도에서 나갔는지 확인하는 함수
		if ((( 0 <= x ) && ( x < lng)) && (( 0 <= y ) && ( y < lng))) {
			return true; // 이동 위치가 지도 안쪽이라면 true 반환
		} else {
			return false; // 이동 위치가 지도 바깥쪽이라면 false 반환
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String str = new String(bf.readLine());
		
		String [] move = str.split(" "); // 입력받은 문자열 잘라 이동 계획 만들기
		
		int x = 0, y = 0; // 초기 위치 0,0 설정
		
		for (int i = 0 ; i < move.length ; i++) {
			if (move[i].equals("L")) { // 만약 L이면 왼쪽 이동
				if (inMap(x, y - 1, n)) { // 이동 위치가 지도 안쪽인지 확인
					y -= 1; // 맞다면 y 좌표 -1
				}
			}else if (move[i].equals("R")) { // 만약 R이면 오른쪽 이동
				if (inMap(x, y + 1, n)) { 
					y += 1; // 맞다면 y 좌표 -1
				}
			}else if (move[i].equals("U")) { // 만약 U이면 오른쪽 이동
				if (inMap(x - 1, y, n)) {
					x -= 1; // 맞다면 X 좌표 -1
				}
			}else { // 만약 D이면 오른쪽 이동
				if (inMap(x + 1, y, n)) { 
					x += 1; // 맞다면 X 좌표 -1
				}
			}
		}
		System.out.println((char)(x + 48 + 1) + " " + (char)(y+48 + 1)); // 시작 위치가 1,1 이므로 INT 였던 값을 +1 더해주고 CHAR로 반환하여 출력
		
	}

}
