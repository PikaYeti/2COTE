package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 큐 이용하면 쉽게 풀 수 있을것같은데
// 시간이 없어서 일단 하드코딩 해서 내겠읍니당..

public class MuziFood {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int [] input = new int[3]; // 배열자체를 입력으로 받아오는 법을 몰라서 일단 입출력 예시에 나온대로 배열길이 3
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i= 0 ; i < 3 ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		long k = Long.parseLong(bf.readLine());
		int lng = input.length -1;
		int start = 0;
		
		String [] intrue = new String[3];
		while (k > 0) {
			System.out.println(Arrays.toString(input));
			if (input[start] > 0) {
				input[start] -= 1;
				if (input[start] > 0) {
					intrue[start] = "1"; // 0을 넘는 수가 존재하는지 확인하기 위해 boolean 변수 설정
				} else {
					intrue[start] = "0"; // 0이 되는 순간 그 index false로 설정
				}
				start += 1;
				if (start > lng) {
					start = 0;
				}
			} else {
				if (Arrays.asList(intrue).contains("1")) { // 0을 넘는 수가 존재한다면 그 index 찾기 위해 while문 돌림
					while(input[start] > 0) {
						start += 1;
						if (start > lng) {
							start = 0;
						}
					}
				} else { // 만약 true 값이 존재하지 않는다면 while문 즉시 중지
					break;
				}
			}
			k--; // 1초씩 줄여나가기
		}
		
		System.out.println(start);
	}

}
