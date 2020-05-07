import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnumTest {
	public static final int MONTH_MIN = 1, MONTH_MAX = 12;		//月の範囲
	
	public static final int DAY_MIN = 1;
	public static int DAY_MAX;		//日の範囲

	static Scanner scanner = new Scanner(System.in);	//キーボード入力受付用
	static String str;	//キーボード入力文字列格納
	static String regex = "^[0-9]*$";	//正の半角数字列の正規表現
	static Pattern p = Pattern.compile(regex);
	static Matcher m;
	static int year, month, day;	//年月
	
	public static void main(String[] args){
		System.out.println("******** 星座判定プログラム ********");
		
		//各変数入力/設定
		InputYear();
		InputMonth();
		setDayMax();
		InputDay();
		
		//結果表示
		System.out.println(year + "年" + month + "月" + day + "日"
				+ "生まれのあなたの星座は" + Constellation.getType(year, month, day).getName() + "です");
		
		scanner.close();
	}
	
	//年入力用関数
	static void InputYear(){
		while(true){
			System.out.print("誕生年(半角数字)を入力して下さい > ");
			str = scanner.next();
			m = p.matcher(str);
			if(!m.find()){
				System.out.println("[Error]自然数	を入力して下さい");
				continue;
			}
			
			year = Integer.parseInt(str);
			break;
		}
	}
	
	//月入力用関数
	static void InputMonth(){
		while(true){
			System.out.print("誕生月(半角数字)を入力して下さい > ");
			str = scanner.next();
			m = p.matcher(str);
			if(!m.find()){
				System.out.println("[Error]正の整数を入力して下さい");
				continue;
			}
			
			month = Integer.parseInt(str);
			
			if(!(MONTH_MIN <= month && month <= MONTH_MAX)){
				System.out.println("[Error]" + MONTH_MIN + "から" + MONTH_MAX + "の範囲で入力して下さい");
			}else{
				break;
			}
		}
		return;
	}
	
	//日入力用関数
	static void InputDay(){
		while(true){
			System.out.print("誕生日(半角数字)を入力して下さい > ");
			str = scanner.next();
			m = p.matcher(str);
			if(!m.find()){
				System.out.println("[Error]正の整数を入力して下さい");
				continue;
			}
			
			day = Integer.parseInt(str);
			
			if(!(DAY_MIN <= day && day <= DAY_MAX)){
				System.out.println("[Error]" + DAY_MIN + "から" + DAY_MAX + "の範囲で入力して下さい");
			}else{
				break;
			}
		}
		return;
	}
	
	//誕生月の最終日を設定
	static void setDayMax(){
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);	//翌月初め
		c.add(Calendar.DATE, -1);	//その前日=当月末日
		DAY_MAX = c.get(Calendar.DATE);
	}
}