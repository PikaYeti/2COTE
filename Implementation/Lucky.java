package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lucky {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String num = new String(bf.readLine()); //숫자 길이를 구하기 위해 String으로 입력 받기
		
		int lng = num.length() / 2 ; //절반 갈라버리깃
		
		int fsum = 0; // 왼쪽 부분 합
		int lsum = 0; // 오른쪽 부분 합
		
		for (int i = 0 ; i < lng ; i++) { // 왼쪽 부분 합 구하기
			fsum += (int)(num.charAt(i)) - 48; // 각 자리수를 charAt(index)로 뽑아내 int형으로 만들어 더하기
		}
		for (int i = lng ; i < num.length() ; i++) { // 오른쪽 부분 합 구하기
			lsum += (int)(num.charAt(i)) - 48; // 각 자리수를 charAt(index)로 뽑아내 int형으로 만들어 더하기
		}
		
		if (fsum == lsum) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
	}

}
