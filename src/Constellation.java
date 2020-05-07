import java.time.LocalDate;
import java.time.MonthDay;

public enum Constellation{
	Aries("牡羊座", MonthDay.of(3, 21), MonthDay.of(4, 19)),
	Taurus("牡牛座", MonthDay.of(4, 20), MonthDay.of(5, 20)),
	Gemini("双子座", MonthDay.of(5, 21), MonthDay.of(6, 21)),
	Cancer("蟹座", MonthDay.of(6, 22), MonthDay.of(7, 22)),
	Leo("獅子座", MonthDay.of(7, 23), MonthDay.of(8, 22)),
	Virgo("乙女座", MonthDay.of(8, 23), MonthDay.of(9, 22)),
	Libra("天秤座", MonthDay.of(9, 23), MonthDay.of(10, 23)),
	Scorpio("蠍座", MonthDay.of(10, 24), MonthDay.of(11, 22)),
	Sagittarius("射手座", MonthDay.of(11, 23), MonthDay.of(12, 21)),
	Capricorn("山羊座", MonthDay.of(12, 22), MonthDay.of(1, 19)){	//基礎コースの抽象クラスの応用でこいつだけメソッドを書き換え
		boolean check(int year, int month, int day){
			LocalDate start = LocalDate.of(year - 1, this.getStart().getMonth(), this.getStart().getDayOfMonth());
			LocalDate end = LocalDate.of(year, this.getEnd().getMonth(), this.getEnd().getDayOfMonth());
			LocalDate birth = LocalDate.of(year, month, day);
			return start.compareTo(birth) <= 0 && end.compareTo(birth) >= 0;
		}
	},
	Aquarius("水瓶座", MonthDay.of(1, 20), MonthDay.of(2, 18)),
	Pisces("魚座", MonthDay.of(2, 19), MonthDay.of(3, 20));
	
	private final String name;
	private final MonthDay start, end;
	
	private Constellation(String name, MonthDay start, MonthDay end){
		this.name = name;
		this.start = start;
		this.end = end;
	}
	
	boolean check(int year, int month, int day){
		LocalDate start = LocalDate.of(year, this.getStart().getMonth(), this.getStart().getDayOfMonth());
		LocalDate end = LocalDate.of(year, this.getEnd().getMonth(), this.getEnd().getDayOfMonth());
		LocalDate birth = LocalDate.of(year, month, day);
		return start.compareTo(birth) <= 0 && end.compareTo(birth) >= 0;
	}
	
	public static Constellation getType(int year, int month, int day){
		for(Constellation cons: values()){
			if(cons.check(year, month, day)) return cons;
		}
		return null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public MonthDay getStart(){
		return this.start;
	}
	
	public MonthDay getEnd(){
		return this.end;
	}
}