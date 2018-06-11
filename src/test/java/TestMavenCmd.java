import svnkitV1.SvnUserImplV1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by CharlesYang on 2017/6/19.
 * 这个程序 2017-6-20 完成，自动化打包成功
 */
public class TestMavenCmd {
    static  ProcessBuilder builder = new ProcessBuilder();
    static String consumer_autosolve_application_path="D:\\Charles_863_V2_2016-3-28\\autosolve-worker\\application";
    static String autosolve_kafka_worker__resources_path = "E:\\测试文档_YMX\\autosolve-kafka-worker_3.10\\src\\main\\resources";
    static String autosolve_kafka_worker__target_path =  "E:\\测试文档_YMX\\autosolve-kafka-worker_3.10\\target";
    static String mathengine_nlu_resources_path = "D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\\mathengine-nlu\\src\\main\\resources" ;
    static String maven_repo_path = "E:\\development\\repo\\com\\tsinghuabigdata\\edu";

    public static void main(String[] args) throws Exception {
        autoPackageMethod();
    }

    /**
     * 自动化程序的主接口，方便以后可能进行的远程调用操作(也有可能用不到，哈哈)
     * @throws Exception
     */

    public static void autoPackageMethod() throws Exception {
        DeleteMvnRepo();
        MvnInstallForMathEngine();
        replaceFileOfNlu();
        MvnInstallForKafka();
        updateWorkerJar();
        CopyFileOfWorkerJar();
        uploadWorkerJar();
        showTheRegularStopInfo();
    }

    private static void updateWorkerJar() {
        if(SvnUserImplV1.getSingleInstanceFor86().updateProjectFromSvn(new File( consumer_autosolve_application_path))){
            System.out.println("SVN 更新："+ consumer_autosolve_application_path+" 成功");
        }else{
            System.err.println("SVN 更新："+ consumer_autosolve_application_path+" 成功");
        };
    }

    /**
     * 打包kafka
     * @throws Exception
     */
    public static void MvnInstallForKafka() throws Exception {
        builder.command(
                "cmd.exe", "/c", "e: & cd \"E:\\测试文档_YMX\\autosolve-kafka-worker_3.10\""+

                        " & mvn install package -DskipTests"
        );
        ExcuteCmd(builder);
    }

    /**
     * SVN上传替换好的woker Jar包
     */
    public static void uploadWorkerJar() throws Exception {
        SvnUserImplV1 svnUserImplV1  = SvnUserImplV1.getSingleInstanceFor86();
        if (svnUserImplV1.commitProjectToSvn(  consumer_autosolve_application_path,"\\kafka-worker-executable-2.1.1-SNAPSHOT.jar")){
            System.out.println("上传目录完成");
        }else{
            System.err.println("上传目录失败");
        };
    }

    /**
     * 将kafka worker 打包后的jar 放入到消费者项目worker下
     * @throws Exception
     */
    public static void CopyFileOfWorkerJar() throws Exception {
        builder.command(
                "cmd.exe", "/c", "e: & cd " +autosolve_kafka_worker__resources_path+
                        "& copy "+autosolve_kafka_worker__target_path+"\\kafka-worker-executable-2.1.1-SNAPSHOT.jar " +
                        consumer_autosolve_application_path+"\\kafka-worker-executable-2.1.1-SNAPSHOT.jar"
        );
        ExcuteCmd(builder);
    }

    /**
     * 将kafka项目中的nlu文件夹替换为mathengine中的nlu的模板文件
     *
     * rd 删除文件夹，其下的文件，del 删除文件，md创建文件夹，xcopy 复制
     * 后来验证可以不用删除也可以，哈哈，
     */
    public static void replaceFileOfNlu() throws Exception {
        builder.command(
                "cmd.exe", "/c", "e: & cd " +autosolve_kafka_worker__resources_path+
//                        "& rd  /s /q "+autosolve_kafka_worker__resources_path+"\\classify "+
//                        "& rd  /s /q "+autosolve_kafka_worker__resources_path+"\\dict "+
//                        "& rd  /s /q "+autosolve_kafka_worker__resources_path+"\\newdic "+
//                        "& rd  /s /q "+autosolve_kafka_worker__resources_path+"\\relationTable "+
//                        "& rd  /s /q "+autosolve_kafka_worker__resources_path+"\\template "+
//                        "& rd  /s /q "+autosolve_kafka_worker__resources_path+"\\xml "+
//                        "& del  "+autosolve_kafka_worker__resources_path+"\\IKAnalyzer.cfg.xml"+
//                        "& del  "+autosolve_kafka_worker__resources_path+"\\EIKAnalyzer.cfg.xml"+
//                        "& del  "+autosolve_kafka_worker__resources_path+"\\relation_parameter.properties"+
//                        "& del  "+autosolve_kafka_worker__resources_path+"\\template_matcher_service.properties"+

                        "& md "+autosolve_kafka_worker__resources_path+"\\classify"+

                        "& xcopy "+mathengine_nlu_resources_path+"\\classify " +
                        autosolve_kafka_worker__resources_path+"\\classify /e"+" /y" +

                        "& md "+autosolve_kafka_worker__resources_path+"\\dict"+

                        "& xcopy "+mathengine_nlu_resources_path+"\\dict " +
                        autosolve_kafka_worker__resources_path+"\\dict /e"+" /y" +

                        "& md "+autosolve_kafka_worker__resources_path+"\\newdic"+

                        "& xcopy "+mathengine_nlu_resources_path+"\\newdic " +
                        autosolve_kafka_worker__resources_path+"\\newdic /e"+" /y" +

                        "& md "+autosolve_kafka_worker__resources_path+"\\relationTable"+

                        "& xcopy "+mathengine_nlu_resources_path+"\\relationTable " +
                        autosolve_kafka_worker__resources_path+"\\relationTable /e"+" /y" +


                        "& md "+autosolve_kafka_worker__resources_path+"\\template"+

                        "& xcopy "+mathengine_nlu_resources_path+"\\template " +
                        autosolve_kafka_worker__resources_path+"\\template /e"+" /y" +//这个参数/e 使得目录中的子目录中的 文件也可以得到复制，否则，template的子目录得不到复制

                        "& md "+autosolve_kafka_worker__resources_path+"\\xml"+

                        "& xcopy "+mathengine_nlu_resources_path+"\\xml " +
                        autosolve_kafka_worker__resources_path+"\\xml /e /y" +

                        "& copy "+mathengine_nlu_resources_path+"\\IKAnalyzer.cfg.xml " +
                        autosolve_kafka_worker__resources_path+" /y " +

                        "& copy "+mathengine_nlu_resources_path+"\\EIKAnalyzer.cfg.xml " +
                        autosolve_kafka_worker__resources_path+" /y" +

                        "& copy "+mathengine_nlu_resources_path+"\\relation_parameter.properties " +
                        autosolve_kafka_worker__resources_path+" /y" +

                        "& copy "+mathengine_nlu_resources_path+"\\template_matcher_service.properties " +
                        autosolve_kafka_worker__resources_path+" /y" +

                        "");
        ExcuteCmd(builder);
    }
    /**
     * 将mathengine项目信息安装好，也即是打包
     * @throws Exception
     */
    public static void MvnInstallForMathEngine() throws Exception{
        builder.command(
                "cmd.exe", "/c", "cd \"D:\\Charles_863_V2_2016-3-28\\mathengine_2017afterExam\" & mvn install package -DskipTests");
        ExcuteCmd(builder);
    }

    /**
     * 删除仓库中的mathengine几个包，防止等会儿kafka打包不更新
     * @throws Exception
     */
    public static void DeleteMvnRepo() throws Exception{
        builder.command(
                "cmd.exe", "/c", "e: & cd "+maven_repo_path+" "+
                        "& rd  /s /q "+maven_repo_path+"\\mathengine"+
                        "& rd  /S /Q "+maven_repo_path+"\\mathengine-cas"+
                        "& rd  /S /Q "+maven_repo_path+"\\mathengine-context"+
                        "& rd  /S /Q "+maven_repo_path+"\\mathengine-model"+
                        "& rd  /S /Q "+maven_repo_path+"\\mathengine-nlptk"+
                        "& rd  /S /Q "+maven_repo_path+"\\mathengine-nlu"+
                        "& rd  /S /Q "+maven_repo_path+"\\mathengine-nlu-judge"
        );
        ExcuteCmd(builder);
    }

    /**
     * 运行cmd命令
     * @param builder 产生的运行指令都在这里面
     * @throws Exception
     */
    public static void ExcuteCmd(ProcessBuilder builder) throws Exception{
        builder.redirectErrorStream(true);
        //start() 执行命令
        Process p = builder.start();

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }

            System.out.println(line);
            if (line.contains("[ERROR]")){
                showTheErrorStopInfo();
                System.exit(-1);
            }
        }
        p.destroy();

    }

    /**
     * 给出一个windows弹出框提示程序正常结束,这样你就不用老是看控制台的信息了
     * @throws Exception
     */
    public static void showTheRegularStopInfo() throws Exception{
        builder.command(
                "cmd.exe", "/c", "@mshta vbscript:msgbox(\"自动程序已经正常结束\",64,\"提示框Title\")(window.close)"
        );
        ExcuteCmd(builder);
    }
    /**
     * 给出一个windows弹出框提示程序出错
     * @throws Exception
     */
    public static void showTheErrorStopInfo() throws Exception{
        builder.command(
                "cmd.exe", "/c", "@mshta vbscript:msgbox(\"程序出错请检查\",64,\"提示框Title\")(window.close)"
        );
        ExcuteCmd(builder);
    }
    /**
     * 获得本机的IP 用在日志信息中，
     * @return
     * @throws SocketException
     */
    public static String getIPFromRunningComputer() throws SocketException {
        Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        while (allNetInterfaces.hasMoreElements())
        {
            NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
//            System.out.println(netInterface.getName());
            Enumeration addresses = netInterface.getInetAddresses();
            while (addresses.hasMoreElements())
            {
                ip = (InetAddress) addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address)
                {
                    if (!ip.getHostAddress().equals("127.0.0.1")){
//                        System.out.println("本机的IP = " + ip.getHostAddress());
                        return ip.getHostAddress().toString();
                    }
                }
            }
        }
        return "IP CAN'T GET";
    }
}

