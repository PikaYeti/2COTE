package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int [][] arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		
		for (int i = 0 ; i < arr.length ; i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < arr[0].length ; j ++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		int max = 0; // 최대값은 0으로 설정
		for (int i = 0 ; i < arr.length ; i++) {
			int min = arr[i][0]; // 각 행의 최소값을 찾기 위해 각 행의 0번지를 일단 최소값으로 설정
			for (int j = 0 ; j < arr[0].length ; j ++) {
				if(arr[i][j] < min) {
					min = arr[i][j]; // 만약 최소값보다 작은 값이 있다면 그 값을 최소값으로 설정
				}
			}
			if(min > max) {
				max = min; // 지금까지의 최대값보다 큰 최소값을 찾으면 최대값을 교체
			}
		}
		System.out.println(max);
	}

}
