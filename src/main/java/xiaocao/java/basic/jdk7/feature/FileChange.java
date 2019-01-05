package xiaocao.java.basic.jdk7.feature;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;

/**
 * 
 * @ClassName: FileChange 
 * @Description: 文件监控
 * @author zhengchong.wan
 * @date 2019年1月5日 下午11:03:32
 *
 */
public class FileChange {
	
	public static void main(String[] args) {
		newFileAPI();
	}
	
	public static void newFileAPI() {
		Path path = Paths.get("d://test//testX");
		System.out.println("Number of Nodes:" + path.getNameCount());
		System.out.println("File Name:" + path.getFileName());
		System.out.println("File Root:" + path.getRoot());
		System.out.println("File Parent:" + path.getParent());
	}
	
	// 文件改变通知
	public static void fileChangeWatch() {
		Path path = Paths.get("d:\\test");
		WatchService watchService = null;
		try {
			watchService = FileSystems.getDefault().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e) {
			System.out.println("IOException" + e.getMessage());
		}

		WatchKey key = null;
		while (true) {
			try {
				key = watchService.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					Kind<?> kind = event.kind();
					System.out.println("Event on " + event.context().toString() + " is " + kind);
				}
			} catch (InterruptedException e) {
				System.out.println("InterruptedException: " + e.getMessage());
			}
			boolean reset = key.reset();
			if (!reset) break;
		}
	}

}
