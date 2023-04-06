//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class SimpleClock extends JFrame implements ActionListener{
    
        Calendar calendar = Calendar.getInstance();
        TimeZone gmt = TimeZone.getTimeZone("GMT");
        TimeZone est = TimeZone.getTimeZone("EST");
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;

        boolean firstClock = false;

        JButton toggleFormat;
        JButton toggleTimezone;
        boolean isMilitary = false;
        boolean isGMT = false;

        SimpleClock() {

            toggleFormat = new JButton();
            toggleFormat.setBounds(200, 100, 100, 50);
            toggleFormat.addActionListener(this::militaryStandard);
            toggleFormat.setText("Toggle Format");

            toggleTimezone = new JButton();
            toggleTimezone.setBounds(200, 200, 100, 50);
            toggleTimezone.addActionListener(this::changeTimesZone);
            toggleTimezone.setText("Toggle Timezone");

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(350, 220);
            this.setResizable(false);
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
    
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));
    
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.setVisible(true);
            this.add(toggleFormat);
            this.add(toggleTimezone);
    
            setTimer();
        }

    private void changeTimesZone(ActionEvent actionEvent) {
        if (isGMT) {
            timeFormat.setTimeZone(gmt);
            isGMT = false;
        } else {
            timeFormat.setTimeZone(est);
            isGMT = true;
        }
    }

    private void militaryStandard(ActionEvent actionEvent) {
            if (isMilitary) {
                timeFormat = new SimpleDateFormat("HH:mm:ss a");
                isMilitary = false;
            } else {
                timeFormat = new SimpleDateFormat("hh:mm:ss a");
                isMilitary = true;
            }
    }

    public void setTimer() {
            while (true) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }

        Thread firstThread = new Thread();
            public void run() {
                while(!firstClock) {

                }
            }

        public static void main(String[] args) {
            new SimpleClock();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == toggleFormat) {
            //Change format
        } else if (e.getSource() == toggleTimezone) {
            //Change timezone
        }
    }

}
