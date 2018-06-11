import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by HP on 2017/6/19.
 */
public class workerCmdOnServer {

    static  ProcessBuilder builder = new ProcessBuilder();

    public static void main(String[] args) throws Exception {
        stopWorker8_20();
        updateSVNWorkerJar8_20();
        startWorker8_20();
    }

    /**
     * ��8.20��Kafka ��worker�ķ���ֹͣ
     * @throws Exception
     */
    private static void stopWorker8_20() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"D:\\Workspaces\\863-consumer-worker\"" +

                        "& D:\\Workspaces\\863-consumer-worker\\stopAllWorkers.bat"

        );
        ExcuteCmd(builder);
    }

    /**
     * ��8.20���������ϵ�kafka��Worker����
     * @throws Exception
     */
    private static void updateSVNWorkerJar8_20() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"D:\\Workspaces\\863-consumer-worker\"" +

                        "& svn update \"D:\\Workspaces\\863-consumer-worker\\worker-autosolve-1\\application\""+
                        "& svn update \"D:\\Workspaces\\863-consumer-worker\\worker-autosolve-2\\application\""+
                        "& svn update \"D:\\Workspaces\\863-consumer-worker\\worker-autosolve-3\\application\""


        );
        ExcuteCmd(builder);
    }

    /**
     * ��8.20 Kafka ��worker�ķ�����
     * @throws Exception
     */
    private static void startWorker8_20() throws Exception {
        builder.command(
                "cmd.exe", "/c", "cd \"D:\\Workspaces\\863-consumer-worker\"" +

                        "& D:\\Workspaces\\863-consumer-worker\\startAllWorkers.bat"

        );
        ExcuteCmd(builder);
    }
    public static void ExcuteCmd(ProcessBuilder builder) throws Exception{
        builder.redirectErrorStream(true);
        //ִ������
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
