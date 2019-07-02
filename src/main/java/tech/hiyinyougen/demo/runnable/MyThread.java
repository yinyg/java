package tech.hiyinyougen.demo.runnable;

/**
 * @author yinyg
 * @date 2019/7/1
 */
public class MyThread extends Thread {

    private int i = 0;

    @Override
    public synchronized void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(4000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

