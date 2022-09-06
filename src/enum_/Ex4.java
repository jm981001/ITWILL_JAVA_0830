package enum_;

import java.util.Scanner;

enum PayType {
	ACCOUNT_TRANSFER("계좌이체"),
	REMITTANCE("무통장입금"),
	ON_SITE_PAYMENT("현장결제"),
	TOSS("토스"),
	PAYCO("페이코"),
	CARD("신용카드"),
	KAKAO_PAY("카카오페이"),
	BEMIN_PAY("배민페이"),
	NAVER_PAY("네이버페이"),
	POINT("포인트"),
	COUPON("쿠폰");
	String title;
	private PayType(String title) {
		this.title = title;
	}
}

enum PayGroup {
	CASH("현금", new PayType[] {PayType.ACCOUNT_TRANSFER, PayType.REMITTANCE, PayType.ON_SITE_PAYMENT, PayType.TOSS}),
	CARD("카드", new PayType[] {PayType.PAYCO, PayType.CARD, PayType.KAKAO_PAY, PayType.BEMIN_PAY, PayType.NAVER_PAY}),
	ETC("기타", new PayType[] {PayType.POINT, PayType.COUPON}),
	EMPTY("없음", new PayType[] {});
	
	private String title;
	private PayType[] payTypes;

	private PayGroup(String title, PayType[] payTypes) {
		this.title = title;
		this.payTypes = payTypes;
	}

	public String getTitle() {
		return title;
	}
	
	
	// findByPayType
	// 문자열("계좌이체") 를 전달받아 해당되는 PayGroup을 리턴하는 findByPayType() 메서드 정의
	public static PayGroup findByPayType(String data){
		PayGroup result = EMPTY;
		
		// 일반 for문
//		PayGroup[] pgs = {CASH, CARD, ETC};
//
//		for(int i=0; i<pgs.length; i++) {
//			PayGroup pg = pgs[i];	// CASH, CARD, ETC
//			for(int j=0; j < pg.payTypes.length; j++) {
//				if(pg.payTypes[j].title.equals(data)) {
//					return pg;
//				}
//			}
//		}
		
		// 향상된 for문
		for(PayGroup pg : PayGroup.values()) {
			for(PayType p : pg.payTypes) {
				if(p.title.equals(data))	return pg;
			}
		}
		
		return result;
	}
	
}




public class Ex4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		
		// 	data: 계좌이체
		//  pg: CASH (enum 타입)
		PayGroup pg = PayGroup.findByPayType(data);
		
		switch (pg) {
		case CASH: System.out.println("현금 결재 로직으로 이동");
			break;
		case CARD: System.out.println("카드 결제 로직으로 이동");
			break;
		case ETC: System.out.println("기타 결재 로직으로 이동");
			break;
		case EMPTY:
			System.out.println(pg.getTitle());
			System.out.println("존재하지 않는 결재 코드 입니다.");
			System.out.println("에러 처리 로직으로 이동");
			break;
		}
		
	}

}










