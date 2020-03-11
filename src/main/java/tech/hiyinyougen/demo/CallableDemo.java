package tech.hiyinyougen.demo;

import java.util.concurrent.*;

/**
 * @Author yinyg
 * @CreateTime 2020/3/9 14:32
 * @Description
 */
public class CallableDemo implements Callable {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 20; i++) {
            System.out.println("i=" + i);
        }
        return 1;
    }

    public static void main(String[] args) {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        CallableDemo callableDemo = new CallableDemo();
        CallableDemo callableDemo2 = new CallableDemo();
        CallableDemo callableDemo3 = new CallableDemo();

        executor.submit(callableDemo);
        executor.submit(callableDemo2);
        executor.submit(callableDemo3);
    }
}
