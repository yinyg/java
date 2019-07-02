package tech.hiyinyougen.demo.io;

import java.io.*;
import java.util.Random;

/**
 * @author yinyg
 * @date 2019/7/2
 * 字符流demo
 */
public class ReaderWriterDemo {
    public static void main(String[] args) {
        String source = "/Users/yinyougen/projects/demo/java/src/main/resources/static/io.txt";
        String target = "/Users/yinyougen/projects/demo/java/src/main/resources/static/io_"
                + new Random().nextInt(9999)
                + ".txt";

        TxtFileUtils.copy(source, target);
    }
}

class TxtFileUtils {
    public static void copy(String source, String target) {
//        File sourceFile = new File(source);
//        File targetFile = new File(target);

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
//            fileReader = new FileReader(sourceFile);
//            fileWriter = new FileWriter(targetFile);

            fileReader = new FileReader(source);
            fileWriter = new FileWriter(target);

            int flag = -1;

            while (-1 != (flag = fileReader.read())) {
                fileWriter.write(flag);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fileReader) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fileWriter) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("文本文件复制成功");
    }
}
