import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;

public class Main {
    static LocalDateTime timePoint = LocalDateTime.now();
    static File file = new File(String.valueOf(timePoint.getMonth() + ".html"));
    static Record record = new Record();

    public static void main(String[] args){
        try{
            if (!file.exists() || file.length()==0) {
                file.createNewFile();
                FileWriter writer = new FileWriter(file);
                writer.write("<html>\r\n" +
                        "<head>\r\n" +
                        "<meta http-equiv=\"Content-Type\"" + " content=\"text/html; charset=utf-16\">\r\n" +
                        //"<title></title>\n" +
                        "</head>\r\n" +
                        "<body>\r\n" +
                        "<h1>" + String.valueOf(timePoint.getMonth()) + "</h1>\r\n" +
                        "<p></p>\r\n" +
                        "</body>\r\n" +
                        "</html>");
                writer.flush();
                writer.close();
            }
        } catch (IOException ioe) {
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleNotesGUI();
            }
        });
    }

    static public void pushNewTextLineToFile(){
        try {
            FileReader reader = new FileReader(file);
            String s = reader.getEncoding();

            int c;
            StringBuffer allText = new StringBuffer("");
            while((c=reader.read()) != -1){
                allText.append((char)c);
            }
            reader.close();
            int appendIndex = allText.indexOf("<p>");

            StringBuffer resultText =  new StringBuffer("<p>" + record.getResultLine() + "</p>\r\n");
            allText.insert(appendIndex, resultText.toString());

            BufferedWriter  writer = new BufferedWriter(new FileWriter(file));
            writer.write(allText.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
