package Greedy;

// Greedy - 거스름돈
// 거슬러 줘야 하는 동전의 최소 갯수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnyMoney {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		// 초기 돈 : 1260원 500 / 100 / 50 / 10
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int money = Integer.parseInt(bf.readLine()); // 초기 돈 받기
		int any = 0; // 거스름돈 변수 선언
		
		// 처음엔 500원 갯수 구하기
		any = money % 500;
		money = money / 500;
		System.out.println("500원 :" + money + " 거스름돈 : " + any);
		
		// 100원 갯수 구하기
		money = any / 100;
		any = any % 100;
		System.out.println("100원 :" + money + " 거스름돈 : " + any);
		
		// 50원 갯수 구하기
		money = any / 50;
		any = any % 50;
		System.out.println("50원 :" + money + " 거스름돈 : " + any);
		
		// 10원 갯수 구하기
		money = any / 10;
		any = any % 10;
		System.out.println("10원 :" + money + " 거스름돈 : " + any);
	}

}
