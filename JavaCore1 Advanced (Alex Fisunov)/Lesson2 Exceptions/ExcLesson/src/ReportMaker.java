import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

public class ReportMaker {
    public static void savePDF(String txt, String path) throws IOException {
            FileOutputStream out = new FileOutputStream(path);
            out.write(txt.getBytes());
            out.close();
    }
}
