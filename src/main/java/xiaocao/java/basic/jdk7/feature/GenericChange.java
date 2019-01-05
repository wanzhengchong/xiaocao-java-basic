package xiaocao.java.basic.jdk7.feature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: GenericChange 
 * @Description: 泛型的菱形语法
 * @author zhengchong.wan
 * @date 2019年1月5日 下午10:52:42
 *
 */
public class GenericChange {
	
	public static void main(String[] args) {
		// 泛型的菱形语法
		List<String> list = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		
	}
	
	// 堆污染的提示
	// @SafeVarargs消除
	// @SuppressWarnings({"unchecked", "varargs"})消除
	// 使用编译器参数 –Xlint:varargs;
	public static <T> void addToList(List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}

}
