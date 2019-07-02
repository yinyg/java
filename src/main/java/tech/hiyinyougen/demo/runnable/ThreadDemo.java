package tech.hiyinyougen.demo.runnable;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author yinyg
 * @date 2019/7/2
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Print print = new Print();
        print.print(10);
    }
}

class Print {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal();

    @Transactional
    public void print() {
        if (5 == threadLocal.get()) {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadLocal.get());
    }

    @Transactional
    public void print(int num) {
        for (int i = 0; i < num; i++) {
            threadLocal.set(i);
            print();
        }
    }
}
