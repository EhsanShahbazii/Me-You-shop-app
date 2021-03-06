package modules.tools;

import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {

    //create simple date format
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");

    //this method get live date and time
    public void LiveDateSwing(Text textField) {

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Date date = getDate();
                    String dateString = simpleDateFormat.format(date);
                    textField.setText(dateString);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }

    public static java.util.Date getDate() {
        java.util.Date date = new java.util.Date();
        return date;
    }
}