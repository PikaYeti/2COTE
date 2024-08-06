package Greedy;
 
//볼링공 고르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bowling {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int [] input = new int[2];
		for (int i = 0 ; i < 2 ; i ++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] bowling = new int[input[0]];
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		for (int i = 0 ; i < input[0] ; i++) {
			bowling[i] = Integer.parseInt(st1.nextToken());
		}
		
		int choice = 0; // 두 사람이 고르는 볼링공 조합 갯수 -> 처음엔 0
		
		for (int i = 0 ; i < input[0] ; i++) {
			for (int j = i+1 ; j < input[0] ; j++) { // 다른 공을 골라야 하므로 두번째 사람은 처음 사람이 고른 공 다음부터 고르기
				if (bowling[i] != bowling[j]) { // 무게가 같은 공을 고를 수 없으므로 공의 무게가 다를 때
					choice++; // 조합수 + 1
				}
			}
		}
		
		System.out.println(choice);
		
	}

}
