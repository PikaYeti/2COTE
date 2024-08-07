package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StrReSort {

	public static void main(String[] args) throws IOException {
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String num = new String(bf.readLine()); //숫자 길이를 구하기 위해 String으로 입력 받기
		
		char [] sarr = new char[num.length()]; // 배열 정렬 위해 char 배열 생성
		
		for (int i = 0 ; i < num.length() ; i++) {
			sarr[i] = num.charAt(i); // 문자열 하나하나 저장
		}
		
		Arrays.sort(sarr); // 배열 정렬
		num = String.valueOf(sarr);
		
		String sstr = new String(); // 정렬 값 중 문자열 값 저장
		String snum = new String(); // 정렬 값 중 숫자 값 저장
		
		for (int i = 0 ; i < sarr.length ; i++) {
			if ((int)sarr[i] >= 65) { // 정렬하면 숫자가 앞에 오기 때문에 만약 문자값을 만나면
				snum = num.substring(0, i); // 배열 처음 - (i-1) 까지 잘라 숫자값 저장
				sstr = num.substring(i); // 배열 i - 마지막값까지 잘라 문자값 저장
				break; //바로 탈출
			}
		}
		num = sstr + snum; // 문자열 앞으로 보내 num 저장
		System.out.println(num);
	}

}
