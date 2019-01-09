package xiaocao.java.basic.jdk8.feature;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 
 * @ClassName: Base64s 
 * @Description: jdk8本身支持base64编码，不在需要引入第三方类库
 * @author zhengchong.wan
 * @date 2019年1月9日 下午7:49:49
 *
 */
public class Base64s {

	public static void main(String[] args) {
		final String text = "Base64 finally in Java 8!";
		final String encoded = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
		System.out.println(encoded);
		final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
		System.out.println(decoded);
	}

}
