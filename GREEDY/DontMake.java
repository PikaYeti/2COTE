package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DontMake {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		 int n = Integer.parseInt(bf.readLine());
		 int [] input = new int[n];
		 
		 StringTokenizer st = new StringTokenizer(bf.readLine());
		 
		 for (int i = 0 ; i < n ; i++) {
			 input[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 Arrays.sort(input); // 양의 정수 금액 중 최소값을 찾아야 하므로 일단 input받은 값을 정렬해줌
		 
		 int target = 1; // 양의 정수이기 때문에 최솟값 찾는 target 1로 설정
		 
		 for (int i = 0 ; i < n ; i++) {
			 if (input[i] > target) {
				 break; // 만약 input[i]값이 최솟값보다 크다면 만들 수 없는 수이기 때문에 break문으로 반복문 빠져나오기
			 } else {
				 target += input[i]; // 값을 더해 target 최솟값 재정의
			 }
		 }
		 
		 System.out.println(target);
	}

}
