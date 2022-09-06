package enum_;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * enum(Week2)을 활용하여
		 * 
		 * 주말 까지 몇일 남았는지 출력 (주말이면 "이미 주말!!!" 출력)
		 * 
		 * 예) 오늘은 X요일... 주말까지 X일 남았다!
		 *  
		 * */
		Week2 week = Week2.토;
		
//		week == Week2.토 || week.equals(Week2.일)
		if(week.ordinal() > Week2.금.ordinal()) { // 주말
			System.out.println("이미 주말!!!");
		} else { // 평일
			System.out.println("오늘은 " + week.name() + "요일... 주말까지 "
					+ Week2.토.compareTo(week) + "일 남았다!");
		}
		
		
	}

}

enum Week2 {
	월, 화, 수, 목, 금, 토, 일
}








