// 	shift 연산자
// 	1) 10진수 5를 2진수로 -> 101 (빈자리에는 0 채우기)
// 	2) 101000 32+8 = 40

// 	그래서 이걸 어디에 써먹어?
// 	정렬 : 목록중에 하나 선택
// 	속성 : 목록중에 다중 선택 ★
//	이탤릭 	: 1 << 0 -> 1
//	굵게 		: 1 << 1 -> 2
//	밑줄 		: 1 << 2 -> 4
// 	텍스트박스.속성 = 3; 이탤릭,굵게 1+2
// 	텍스트박스.속성 = 7; 이탤릭,굵게, 밑줄 1+2+4
//	텍스트박스.속성 = 0; X
//	텍스트박스.속성 = 5; 이텔릭, 밑줄
//	-> 조건의 조합으로 판단함.

// 	ex) 카페의 속성 필터링
//		24시간 	1 << 0 : 1
//		주차장 	1 << 1 : 2
//		와이파이 	1 << 2 : 4
//		흡연실 	1 << 3 : 8
//		위 속성들의 조합으로 필터링 가능
//	ex)	매장.속성 = 11;
//		매장.속성 = (1 << 2) + (1 << 3);
//		매장.속성 = 주차장 + 와이파이;

public class OMain3 {
	
	public static void main(String[] args) {
	
		int x = 5 << 3; // 40
		System.out.println(x);
		
	}
}