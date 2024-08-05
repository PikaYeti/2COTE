package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Greedy- 큰 수의 법칙
// 가장 큰수 n번 더하고 그 다음 큰수 1번 더해서 M번 채우기
public class BigNumberRule {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int [] input = new int[3];
		
		StringTokenizer st = new StringTokenizer(bf.readLine()); // 배열 크기 / M / K 받기
		StringTokenizer st1 = new StringTokenizer(bf.readLine()); // 배열 입력 받기
		
		for (int i = 0 ; i < 3 ; i++) {
			input[i] = Integer.parseInt(st.nextToken()); // 첫째줄 입력 배열에 삽입
		}
		
		int [] arr = new int[input[0]];
		
		for (int i = 0 ; i < input[0] ; i++) {
			arr[i] = Integer.parseInt(st1.nextToken()); // 배열 하나하나 배열에 삽입
		}
		
		Arrays.sort(arr); // 제일 큰 값, 그 다음 큰수 구하기 위해 배열 정렬시키기
		int big = (input[1] / input[2]) * input[2]; // 큰 배열 몇번 더할것인지 M/K하여 K * big하기
		int nbig = input[1] - big; // 다음 큰 수 몇번 더할것? -> 전체에서 구한 big 수 빼기
		
		int sum = arr[input[0] - 1] * big + arr[input[0] - 2] * nbig; // 결과값 구하기 -> 최대값 * big + 다음큰수 * nbig
		System.out.println(sum);
	}

}
