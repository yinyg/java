package tech.hiyinyougen.demo.runnable;

/**
 * @author yinyg
 * @date 2019/7/2
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        Print print = new Print();
//        print.print(10);
//
//        System.out.println("------------");

        for (int i = 1; i <= 2; i++) {
            Print2Thread thread = new Print2Thread();
            thread.setName("name" + i);

            thread.start();
        }

    }
}

class Print {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal();

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

    public void print(int num) {
        for (int i = 0; i < num; i++) {
            threadLocal.set(i);
            print();
        }
    }
}

class Print2Thread extends Thread {
    private ThreadLocal<String> threadLocal = new ThreadLocal();

    @Override
    public void run() {
        print(Thread.currentThread().getName());
    }

    public void print(String name) {
        threadLocal.set(name);
        for (int i = 0; i < 20; i++) {
            System.out.println(name + " " + threadLocal.get());
        }
    }

}
