import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Created by HP on 2017/6/20.
 */
public class cmd {
//    public static Log log = LogFactory.getLog(test.class);
    static  ProcessBuilder builder = new ProcessBuilder();
    public static void main(String[] args) throws Exception {

//        DeleteMvnRepo();
//        MvnInstallForMathEngine();
//        replaceFileOfNlu();
        CopyFileOfWorkerJar();
//        uploadWorkerJar();
    }
    /**
     * 将kafka worker 打包后的jar 放入到消费者worker下
     * @throws Exception
     */
    private static void CopyFileOfWorkerJar() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"E:\\测试文档_YMX\\autosolve-kafka-worker\\src\\main\\resources\""+
                        "& copy \"E:\\测试文档_YMX\\autosolve-kafka-worker\\target\\kafka-worker-executable-2.1.1-SNAPSHOT.jar\" " +
                        "\"E:\\测试文档_YMX\\consumer-autosolve\\application\\kafka-worker-executable-2.1.1-SNAPSHOT.jar\""
        );
        ExcuteCmd(builder);
    }
    public static void ExcuteCmd(ProcessBuilder builder) throws Exception{
        builder.redirectErrorStream(true);
        //执行命令
        Process p = builder.start();


        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
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
