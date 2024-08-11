package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Guild {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int [] tgroup = new int[Integer.parseInt(bf.readLine())];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < tgroup.length ; i++) {
			tgroup[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tgroup); // 최댓값을 설정해야 하므로 작은 순서대로 그룹을 만들어 처리
		
		int howHorror = 0; // 현재 index의 공포도 저장
		int aindex = 0; // 탐색해야할 index가 어디인지
		int answer = 0; // 정답 저장
		
		
		
		while(aindex < tgroup.length) {
			howHorror = tgroup[aindex]; // 현재 인덱스 모험가의 공포도 측정
			if (howHorror < tgroup.length - aindex) { 
				aindex += howHorror; // 공포도만큼 그룹을 구성하고 다음 공포도를 측정할 인덱스를 찾기위해 +
				answer += 1; // 정답 +1
			}else { // 만약 배열의 값이 남은 인덱스 길이보다 크다면 그룹을 만들지 못하므로
				break;
			}
			
		}
		
		System.out.println(answer);
		
		

	}

}
