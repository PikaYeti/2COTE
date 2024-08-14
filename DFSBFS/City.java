package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class City {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> nextcity = new LinkedList<>(); // 출발 도시를 저장할 큐를 선언
		
		int [] info = new int[4]; // 도시 수, 도로 수, 거리 정보, 출발 도시 번호를 담을 배열 선언
		
		for (int i = 0 ; i < 4 ; i++) { // 도시 수, 도로 수, 거리 정보, 출발 도시 번호 설정
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		int [][] city = new int[info[1]][2]; // 도시의 이동가능 경로를 담아줄 배열 선언
		int [] visit = new int[info[0]];
		int [] answer = new int[info[0]];
		
		for (int i = 0 ; i < info[1] ; i ++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < 2 ; j++) {
				city[i][j] = Integer.parseInt(st1.nextToken()); // 도시의 이동 가능 경로 설정
			}
		}
		
//		for (int i = 0; i < info[1] ; i++) {
//			cityG[city[i][0] - 1][city[i][1] - 1] = 1;
//		}
		nextcity.add(info[3]); 
		
		while (!nextcity.isEmpty()) {
			int n = nextcity.poll();
			for (int j = 0 ; j < city.length ; j++) {
				if ((city[j][0] == n) && (visit[city[j][1] - 1] != 1)){
					answer[city[j][1] - 1] = answer[city[j][0] - 1] + 1;
					visit[city[j][1] - 1] = 1;
					nextcity.add(city[j][1]);
				}
			}
			
		}
		
		int cnt = 0;
		for (int i = 0 ; i < answer.length ; i++) {
			if (answer[i] == info[2]) { // 만약 저장 경로가 거리 정보와 같다면
				sb.append(i + 1).append("\n"); //출력
			} else {
				cnt ++;
			}
		}
		if (cnt == answer.length) { // 저장된값이 없다면
			sb.append(-1); // -1 출력
		}
		System.out.println(sb);
		
	}

}

