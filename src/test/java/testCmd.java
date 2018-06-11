import org.junit.Test;
import util.CmdUtil;

/**
 * Created by HP on 2017/7/20.
 */
public class testCmd {
    @Test
    public void testKillCmd() throws Exception {
//        CmdUtil.ExcuteCmd("@mshta vbscript:msgbox(\"程序出错请检查\",64,\"提示框Title\")(window.close)");
        CmdUtil.killProcessByName("cmd.exe");
        CmdUtil.killProcessByName("100.exe");
    }
    @Test
    public void testStartCmd() throws Exception {
        CmdUtil.ExcuteCmd("d: & cd  D:\\Charles_863_V2_2016-3-28\\autosolve-worker\\bin\\ & daemon.bat");
    }
}
