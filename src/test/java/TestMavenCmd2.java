import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by CharlesYang on 2017/6/19.
 */
public class TestMavenCmd2 {

    static  ProcessBuilder builder = new ProcessBuilder();

    public static void main(String[] args) throws Exception {
        DeleteMvnRepo();
        MvnInstallForMathEngine();
        replaceFileOfNlu();
        CopyFileOfWorkerJar();
        uploadWorkerJar();
    }

    /**
     * SVN上传替换好的woker Jar包
     */
    private static void uploadWorkerJar() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"E:\\测试文档_YMX\\consumer-autosolve\\application\"" +
                        "& svn commit" );
        ExcuteCmd(builder);
    }

    /**
     * 将kafka worker 打包后的jar 放入到消费者worker下
     * @throws Exception
     */
    private static void CopyFileOfWorkerJar() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\"" +
                        "& copy \"E:\\测试文档_YMX\\autosolve-kafka-worker\\target\\kafka-worker-executable-2.1.1-SNAPSHOT.jar\" " +
                        "\"E:\\测试文档_YMX\\consumer-autosolve\\application\\kafka-worker-executable-2.1.1-SNAPSHOT.jar\""
        );
        ExcuteCmd(builder);
    }

    /**
     * 替换nlu中的模板文件
     */
    public static void replaceFileOfNlu() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" " +
                        "& rd  /s /q \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\classify \""+
                        "& rd  /s /q \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\dict \""+
                        "& rd  /s /q \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\newdic \""+
                        "& rd  /s /q \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\relationTable \""+
                        "& rd  /s /q \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\template \""+
                        "& rd  /s /q \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\xml \""+
                        "& del  \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\IKAnalyzer.cfg.xml\""+
                        "& del  \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\EIKAnalyzer.cfg.xml\""+
                        "& del  \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\relation_parameter.properties\""+
                        "& del  \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\\template_matcher_service.properties\""+



                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\classify\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\dict\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\newdic\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\relationTable\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\template\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\xml\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\IKAnalyzer.cfg.xml\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y " +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\EIKAnalyzer.cfg.xml\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\relation_parameter.properties\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +

                        "& copy \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources\\template_matcher_service.properties\" " +
                        "\"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\" /y" +


                        "");
        ExcuteCmd(builder);
    }
    /**
     * 将包中的信息安装好，也即是打包
     * @throws Exception
     */
    public static void MvnInstallForMathEngine() throws Exception{
        builder.command(
                "cmd.exe", "/c", "cd \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\" & mvn install package -DskipTests");
        ExcuteCmd(builder);
    }

    /**
     * 删除仓库中的几个包
     * @throws Exception
     */
    public static void DeleteMvnRepo() throws Exception{
        builder.command(
                "cmd.exe", "/c", "cd \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\" " +
                        "& rd  /s /q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine\""+
                        "& rd  /S /Q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine-cas\""+
                        "& rd  /S /Q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine-context\""+
                        "& rd  /S /Q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine-model\""+
                        "& rd  /S /Q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine-nlptk\""+
                        "& rd  /S /Q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine-nlu\""+
                        "& rd  /S /Q \"E:\\development\\repo\\com\\tsinghuabigdata\\edu\\mathengine-nlu-judge\""
        );
        ExcuteCmd(builder);
    }
    public static void ExcuteCmd(ProcessBuilder builder) throws Exception{
        builder.redirectErrorStream(true);
        //执行命令
        Process p = builder.start();


        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }
}

