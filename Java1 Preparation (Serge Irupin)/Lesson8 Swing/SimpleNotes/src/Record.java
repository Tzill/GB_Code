import java.time.LocalDateTime;

public class Record {
    private LocalDateTime timePoint;
    private String dateAndTime;
//    private String[] tags;
    private String textMemo;

//    public void parseTags(String tagLine) {
//
//    }
    public Record(){
        timePoint = LocalDateTime.now();
        dateAndTime = new String(timePoint.toString());
    }

    public void setTextMemo(String textMemo) {
        this.textMemo = textMemo;
    }

    public String getResultLine(){
        return dateAndTime + " :: " + textMemo;
    }

}
