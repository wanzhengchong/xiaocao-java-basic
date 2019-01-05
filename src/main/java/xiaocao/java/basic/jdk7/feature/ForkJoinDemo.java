package xiaocao.java.basic.jdk7.feature;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8240492710380090410L;
	static final int THRESHOLD = 100;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
    this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(String.format("compute %d~%d = %d", start, end, sum));
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        // 优化写法
        // 父线程会在派发任务的同时自己保留一个任务运行
        // 充分利用线程池，保证没有空闲的不干活的线程
        invokeAll(subtask1, subtask2);
        // 普通写法：父线程纯粹当监工，停下来不干活等待
        // subtask1.fork();
        // subtask2.fork();
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}

/**
 * 
 * @ClassName: ForkJoinDemo 
 * @Description: Fork/Join模型
 * @author zhengchong.wan
 * @date 2019年1月5日 下午10:55:17
 *
 */
public class ForkJoinDemo {
	
	public static void main(String[] args) {
		// 创建随机数组成的数组:
	    long[] array = new long[400];
	    for (int i = 0; i < array.length; i++) {
	    	array[i] = i;
	    }
	    // fork/join task:
	    ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
	    ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
	    long startTime = System.currentTimeMillis();
	    Long result = fjp.invoke(task);
	    long endTime = System.currentTimeMillis();
	    System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
	}

}
