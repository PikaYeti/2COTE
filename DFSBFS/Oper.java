
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 앗쉬 문제 잘못봐서 몇시간 날림,,,,

public class Oper {
	
	// 최대 최소 값이 10억, -10억이므로 처음 초기화를 그것보다 +1, -1한 값으로 설정
	
	static int min = 1000000001;
	static int max = -1000000001;
	
	// 이건 밖에 안써도 되는데 고치기 싫어서,, => 주어진 operator 저장하는 변수
	static int [] operator = new int[4];
	
	
	// 저번시간에 배웠던 순열 이용해서 연산자 순서 순열 만들어줌
	static void combination(int [] oper, int [] arr, boolean [] visit, int [] save, int x, int y) {
		
		
		
		if (x == y) {
			
			
			int b = arr[0];
			int a = 1;
			
			for (int i = 0 ; i < oper.length ; i ++) {
				
				if ((oper[i] == 3) && (arr[a] == 0)) { // 0으로 나누는 오류 피하기 위해 설정
					return;
				}
				
				if (oper[i] == 0) { // oper[i]가 0이면 연산자의 0번째 인덱스 즉 +이므로 +해주기 밑 if문도 동일
					b = b + arr[a];
				} 
				else if (oper[i] == 1) {
					b = b - arr[a];
				} 
				else if (oper[i] == 2) {
					b = b * arr[a];
				} 
				else if (oper[i] == 3) {
					b = b / arr[a];
				} 
				
				a++;
			}
			
			
			if (b > max) {
				max = b;
			}
			
			if (b < min) {
				min = b;
			}
			
			return;
		}
		
		// 순열 구하는 for문
		for (int i = 0 ; i < y ; i ++) {
			if (!visit[i]) {
				visit[i] = true;
				oper[x] = save[i];
				combination(oper, arr, visit, save, x + 1, y);
				visit[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int [] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0 ; i < n ; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		
		// 연산자 조합 순열 순서 저장할 배열, 순열이 될 연산자 저장할 배열, 방문했는지 체크할 배열 설정
		int [] maxo = new int[n - 1];
		int [] save = new int[n - 1];
		boolean [] visit = new boolean[n - 1];
		
		// 연산자 갯수 저장하며 해당 연산자 갯수만큼 save배열에 저장 ex. 만약 operator[0] (더하기)가 2이면 0을 두번 넣어줌
		int cnt = 0;
		for (int i = 0 ; i < 4 ; i++) {
			operator[i] = Integer.parseInt(st1.nextToken());
			for (int j = 0 ; j < operator[i] ; j++) {
				save[cnt++] = i;
			}
		}	
		
		// 함수 불러주기
		combination(maxo, arr, visit, save, 0, n - 1);
		
		System.out.println(max); // 최댓값 출력
		System.out.print(min); // 최솟값 출력

	}

}
