package com.ssafy.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class City {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		Queue<Integer> nextcity = new LinkedList<>(); // 출발 도시를 저장할 큐를 선언
		
		int [] info = new int[4]; // 도시 수, 도로 수, 거리 정보, 출발 도시 번호를 담을 배열 선언
		
		for (int i = 0 ; i < 4 ; i++) { // 도시 수, 도로 수, 거리 정보, 출발 도시 번호 설정
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		int [][] city = new int[info[1]][2]; // 도시의 이동가능 경로를 담아줄 배열 선언
		int [] cm = new int[info[0]]; // 출발 도시 번호에서 몇번만에 n번도시 (인덱스 + 1)로 이동 가능한지
		
		for (int i = 0 ; i < info[1] ; i ++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < 2 ; j++) {
				city[i][j] = Integer.parseInt(st1.nextToken()); // 도시의 이동 가능 경로 설정
			}
		}
		
		nextcity.add(info[3]); // 출발 도시 번호를 큐에 넣어줌
		
		while(!nextcity.isEmpty()) {
			int n = nextcity.poll();
			for (int i = 0 ; i < city.length ; i ++) {
				if (city[i][0] == n) { // 만약 city[i][0] - 출발 도시 경로가 n이면
					
					if (cm[city[i][1] - 1] > 0) { // 이미 도착 지점에 값이 저장되어 있다면 최소값이 저장되어 있는 것이므로 건드리지 X
						cm[city[i][1] - 1] = cm[city[i][0] - 1];
					}
					else { // 도착지점에 출발지점의 값 + 1(1번 이동햇으니가)
						cm[city[i][1] - 1] = cm[city[i][0] - 1] + 1;
					}
					nextcity.add(city[i][1]);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0 ; i < cm.length ; i++) {
			if (cm[i] == info[2]) { // 만약 저장 경로가 거리 정보와 같다면
				System.out.println(i+1); //출력
			} else {
				cnt ++;
			}
		}
		if (cnt == cm.length) { // 저장된값이 없다면
			System.out.println(-1); // -1 출력
		}
	}

}
