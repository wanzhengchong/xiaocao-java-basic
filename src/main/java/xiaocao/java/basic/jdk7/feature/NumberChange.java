package xiaocao.java.basic.jdk7.feature;

/**
 * 
 * @ClassName: NumberChange 
 * @Description: 数字书写的改变
 * @author zhengchong.wan
 * @date 2019年1月5日 下午10:51:42
 *
 */
public class NumberChange {
	
	public static void main(String[] args) {
		// 可以采用二进制表示整数
		byte nByte = 0b0001;  
		System.out.println(nByte);
		short nShort = 0B0010;  
		System.out.println(nShort);
		int nInt = 0b0011;  
		System.out.println(nInt);
		long nLong = 0b0100L;  
		System.out.println(nLong);
		
		// 数字中可以出现下划线
		int a = 10_0000_0000; 
		System.out.println(a);
		long b = 0xffff_ffff_ffff_ffffl;  
		System.out.println(b);
		byte c = 0b0001_1000; 
		System.out.println(c);
	}

}
