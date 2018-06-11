package googleJoiner;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by HP on 2017/7/11.
 */
public class addSeperator {
    public static void main(String[] args) {
        System.out.println(joinByGuava(getQuestionIDFromTxt("E:\\oldwindows\\Users\\HP\\Desktop\\系统测试4.txt"),"#%#"));
//        System.out.println(joinByGuava(getQuestionIDFromTxt("C:\\Users\\Administrator\\Documents\\Tencent Files\\910713585\\FileRecv\\function_ok _0901.txt"),"#%#"));
    }

    /**
     *  该方法将list中的字符串指定的分隔符串联起来
     * @param stringList 字符串List,每个list等会儿都要被分割
     * @param delimiter 分隔符
     * @return
     */
    public static String joinByGuava(List stringList, String delimiter){
        return    Joiner
                .on(delimiter)
                .skipNulls()
                .join(stringList);
    }
    //从txt中按行将数据存储在list中
    public static List<String> getQuestionIDFromTxt(String fileName){
        File file = new File(fileName);
        List<String> list = Lists.newArrayList();
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                tempString = tempString.replaceAll(" ","-");
                tempString = tempString.replaceAll("\\t","-");
                // 显示行号
                System.out.println("line " + line + ": " + tempString);

                line++;
                list.add(tempString);
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
        return list;
    }
}

