package tech.hiyinyougen.demo.io;

import java.io.*;
import java.util.Random;

/**
 * @author yinyg
 * @date 2019/7/2
 * 字节流demo
 */
public class StreamDemo {
    public static void main(String[] args) {
        String source = "/Users/yinyougen/projects/demo/java/src/main/resources/static/io.txt";
        String target = "/Users/yinyougen/projects/demo/java/src/main/resources/static/io_"
                + new Random().nextInt(9999)
                + ".txt";

        ImgUtils.copy(source, target);
    }
}

class ImgUtils {
    /**
     * copy图片
     * @param source 源文件路径
     * @param target 目标文件路径
     */
    public static void copy(String source, String target) {
//        File sourceFile = new File(source);
//        File targetFile = new File(target);

        InputStream in = null;
        OutputStream out = null;

        try {
//            in = new FileInputStream(sourceFile);
//            out = new FileOutputStream(targetFile);

            in = new FileInputStream(source);
            out = new FileOutputStream(target);

            byte[] bytes = new byte[1024];
            int len = -1;

            while (-1 != (len = in.read(bytes))) {
                out.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("文件复制成功");
    }
}
