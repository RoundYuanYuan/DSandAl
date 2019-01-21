package callableImpleMulTithrea;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * implement steps
 * 1、创建Callable接口的实现类，并实现call()方法，该call()方法作为线程执行体,且该call()方法有返回值
 * 2、创建Callable实现类的实例，使用FutureTask类来包装Callable对象,该FutureTask对象封装了该Callable对象的call()
 * 方法的返回值。
 * 3、使用FutureTask对象作为Thread对象的target创建并启动新线程。
 * 4、调用FutureTask对象的get()方法来获得子线程执行结束后的返回值。
 */
public class ThirdThread implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		for (; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量的值:" + i);
		}
		return i;
	}

	public static void main(String[] args) throws Exception, ExecutionException {
		ThirdThread rt = new ThirdThread();

		FutureTask<Integer> futureTask = new FutureTask<>(rt);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值:" + i);
			if (i == 20) {
				new Thread(futureTask, "有返回值的线程").start();
			}
		}
		System.out.println(futureTask.get());

	}

}
