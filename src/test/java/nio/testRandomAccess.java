package nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by HP on 2017/7/7.
 */
public class testRandomAccess {
    public static void main(String[] args) throws IOException {
//        RandomAccessFile rf = new RandomAccessFile("rtest.dat", "rw");
//        for (int i = 0; i < 10; i++) {
//            //写入基本类型double数据
//            rf.writeDouble(i * 1.414);
//        }
//        rf.close();
//        rf = new RandomAccessFile("rtest.dat", "rw");
//        //直接将文件指针移到第5个double数据后面
//        rf.seek(5 * 8);
//        //覆盖第6个double数据
//        rf.writeDouble(47.0001);
//        rf.close();
//        rf = new RandomAccessFile("rtest.dat", "r");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Value " + i + ": " + rf.readDouble());
//        }
//        rf.close();
        readFileByLines("C:\\Users\\HP\\Desktop\\Test.log");
    }

    static long length = 0x8000000; // 128 Mb

    @Test
    public void testMapRandom() throws Exception {
        // 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。
        FileChannel fc = null;

        fc = new RandomAccessFile("C:\\Users\\HP\\Desktop\\Test.log", "rw").getChannel();
        length = fc.size();
//        //注意，文件通道的可读可写要建立在文件流本身可读写的基础之上
        MappedByteBuffer out = null;
//
        out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);

        byte dst[] = new byte[(int) length];
        StringBuilder stringBuilder = new StringBuilder("");
        System.out.println(out.order());
//
//        for (long i = 0; i < 2000l; i++) {
////            stringBuilder.append(out.getChar((int) i));
////
////            if (out.getChar((int) i) == '\n') {
////                System.out.print(stringBuilder.toString());
////            }
//
//
//        }
//

        fc.close();


    }


    public void MapRandom2(ByteBuffer byteBuffer) throws Exception {

        ByteArrayInputStream bis = new ByteArrayInputStream(byteBuffer.array());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int ch = 0;

        while ((ch = bis.read()) != -1) {

            bos.write(ch);

        }

        System.out.println(bos.toString());


    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);

                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
