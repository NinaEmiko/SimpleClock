//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;



public class SimpleClock extends JFrame implements ActionListener{
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        String time;
        String day;
        String date;

        JButton toggleFormat;
        JButton toggleTimezone;

        SimpleClock() {

            toggleFormat = new JButton();
            toggleFormat.setBounds(200, 100, 100, 50);
            toggleFormat.addActionListener(this);
            toggleFormat.setText("Toggle Format");

            toggleTimezone = new JButton();
            toggleTimezone.setBounds(200, 200, 100, 50);
            toggleTimezone.addActionListener(this);
            toggleTimezone.setText("Toggle Timezone");

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(350, 220);
            this.setResizable(false);
            this.add(toggleFormat);
            this.add(toggleTimezone);
    
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
    
            setTimer();
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


        public void toggleFormat(boolean buttonPress) {
            if (buttonPress) {
                timeFormat = new SimpleDateFormat("hh:mm:ss a");
            } else {
                timeFormat = new SimpleDateFormat("HH:mm:ss a");
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
