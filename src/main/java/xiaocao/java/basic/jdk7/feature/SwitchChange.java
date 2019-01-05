package xiaocao.java.basic.jdk7.feature;

/**
 * 
 * @ClassName: SwitchChange 
 * @Description: switch也能支持字符串了
 * @author zhengchong.wan
 * @date 2019年1月5日 下午10:48:53
 *
 */
public class SwitchChange {
	
	public static void main(String[] args) {
		switchString("one");
		switchString("two");
		switchString("three");
	}
	
	private static void switchString(String str) {
		switch (str) {
			case "one" : 
				System.out.println("1");
				break;
			case "two" : 
				System.out.println("2");
				break;
			default :
				System.out.println("err");
		}
	}

}
