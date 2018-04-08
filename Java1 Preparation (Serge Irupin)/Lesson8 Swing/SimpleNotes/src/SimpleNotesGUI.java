import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleNotesGUI extends JFrame{
    JFrame jfr;
    JTextArea ta;
    JButton pushButton;
    JScrollPane jscp;

    SimpleNotesGUI(){
        jfr = new JFrame("Simple Notes");
        jfr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr.setSize(320, 265);
        jfr.setLocation(800,250);
        jfr.setResizable(false);
        jfr.setAlwaysOnTop(true);
        jfr.setLayout(new FlowLayout());

        ta= new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        pushButton = new JButton("Push");

        jscp = new JScrollPane(ta);
        jscp.setPreferredSize(new Dimension(290,190));

        jfr.add(jscp);
        jfr.add(pushButton);

        jfr.setVisible(true);

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.record = new Record();
                Main.record.setTextMemo(ta.getText());
                Main.pushNewTextLineToFile();
                ta.setText("");
                jfr.dispose();
            }
        });
    }
}
