package D_0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boki {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [n];
		
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		for (int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(arr);
		int sum = 0;
		int start = 0;
		int end = arr[n - 1];
		int mid = 0;
		
		while(sum != m) {
			
			sum = 0;
			mid = (start + end) / 2;
			
			for (int i = 0 ; i < n ; i ++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}
			
			if (sum > m) {
				start = mid;
			} else {
				end = mid;
			}
			
		}
		
		System.out.println(mid);
	}

}
