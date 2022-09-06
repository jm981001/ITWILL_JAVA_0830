package enum_;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * enum에 속성 추가
		 * 
		 * 1. ordinal 은 마치 배열처럼 0부터 시작한다.
		 * 	  그리고, ordinal은 정수 데이터이다.
		 * - 특정 데이터를 지정해 주고싶다!
		 * 예) 지역번호: (서울: 02, 경기도: 031, 인천: 032, 부산: 051...)
		 *     URL: NAVER("https://www.naver.com"), 
		 *     		DAUM("https://www.daum.net"), 
		 *     		GOOGLE("https://www.google.com")
		 * 
		 * 2. 시스템 유지보수중 enum의 멤버가 추가되거나 변경된다면?
		 * - 기존 ordinal이 깨질 수 있다.
		 * 	 => ordinal로 계산하고 있던 모든 로직을 찾아 수정해야한다.
		 *   예) 평일만 관리하고 있었다. (월, 화, 수, 목, 금 -> 0,1,2,3,4)
		 *       주말도 관리해야 할것 같다 (일, 월, 화, 수, 목, 금, 토 -> 0,1,2,3,4,5,6)
		 * 
		 * 3.* 모두 같은 뜻인데 DB의 테이블마다 다른 데이터로 관리되고 있다.
		 * 	 예) 학교 데이터 (졸업여부: Y/N)
		 *      공장 생산관리 데이터 (입고완료여부: 1/0)
		 *      				(출고완료여부: true/false)
		 *      배민 (결재완료여부: T/F)
		 *          (배달전/배달중/배달완료 0/1/2)
		 * 
		 * */
		
		// 1. 지역번호
		Area area = Area.인천;
		System.out.println(area);
		System.out.println(area.number); 
		
		// 2. 사이트
		Site 구글 = Site.GOOGLE;
		System.out.println(구글);
		System.out.println(구글.url);
		
		
		// 3. 같은 뜻인데 다른 데이터로 관리되고 있을 경우
		Status s = Status.Y;
		System.out.println(s);
		System.out.println(s.value1); // int
		System.out.println(s.value2); // boolean
		System.out.println(s.value3); // String
		
		// if문에 조건식에 활용도 가능하다
		if(s.value2) {}
		
		s = Status.N;
		System.out.println(s);
		System.out.println(s.value1); // int
		System.out.println(s.value2); // boolean
		System.out.println(s.value3); // String
		
		System.out.println("---------------------------");
		
		System.out.println(EnumTest.Y.e);
		System.out.println(EnumTest.Y.c.d);
		
		// if문 조건식에 활용가능
		if(EnumTest.Y.c.b) {}
		
	}

}

//1. 지역번호
enum Area {
	// enum에 멤버 추가시 상수 마지막은 ;으로 끝나야함
	서울("02"), 경기도("031"), 인천("032"), 부산("051");
	String number;
	
	private Area(String number) {
		this.number = number;
	}
}

//2. 사이트
enum Site {
	NAVER("https://www.naver.com"),
	DAUM("https://www.daum.net"),
	GOOGLE("https://www.google.com");
	
	String url;
	
	private Site(String url) {
		this.url = url;
	}
}

// 3. 같은 뜻인데 다른 데이터로 관리되고 있을 경우 (상태값)
enum Status {
	Y(1, true, "T"), 
	N(0, false, "F");
	
	int value1;
	boolean value2;
	String value3;
	
	private Status(int value1, boolean value2, String value3) {
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
}


enum EnumTest {
	Y(EnumType.T, new ClassType(1, true, 1.0, "T")),
	N(EnumType.F, new ClassType(0, false, 0.0, "F"));
	
	EnumType e;
	ClassType c;
	
	private EnumTest(EnumType e, ClassType c) {
		this.e = e;
		this.c = c;
	}
	
}

enum EnumType {
	T, F
}

class ClassType {
	int i;
	boolean b;
	double d;
	String s;
	
	public ClassType(int i, boolean b, double d, String s) {
		this.i = i;
		this.b = b;
		this.d = d;
		this.s = s;
	}
}




























