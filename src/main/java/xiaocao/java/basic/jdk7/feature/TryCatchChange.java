package xiaocao.java.basic.jdk7.feature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 * @ClassName: TryCatchChange 
 * @Description: try-with-resources可以自动释放资源
 * @author zhengchong.wan
 * @date 2019年1月5日 下午10:50:38
 *
 */
public class TryCatchChange {
	
	// try-with-resources,可以自动关闭相关的资源（只要该资源实现了AutoCloseable接口
	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
	
	// 捕获多个异常
	static void catchMultiException(int i) throws Exception {
		try {
			if (i == 1) throw new SQLException();
			if (i == 2) throw new IOException();
		} catch (IOException|SQLException ex) {
			 throw ex;  
		}
	}
	
	static void reThrowException(int i) throws SQLException, IOException {
		try {
			if (i == 1) throw new SQLException();
			if (i == 2) throw new IOException();
		} catch (Exception ex) {
			 throw ex;  
		}
	}

}
