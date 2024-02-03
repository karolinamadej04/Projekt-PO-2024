import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DifferenceGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    private JComboBox month1ComboBox;
    private JTextField year1Field;
    private JComboBox day1ComboBox;
    private JComboBox day2ComboBox;
    private JComboBox month2ComboBox;
    private JTextField year2Field;
    private JLabel AnswerLabel;
    private JButton goBackButton;
    private JButton OKButton;
    private int selectedDay1;
    private int selectedMonth1;
    private int selectedDay2;
    private int selectedMonth2;
    private int year1;
    private int year2;

    public DifferenceGUI(){
        super("Difference between dates");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=700, height=350;
        this.setSize(width,height);
        setResizable(false);
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        day1ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDay1=day1ComboBox.getSelectedIndex();
            }
        });
        month1ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMonth1=month1ComboBox.getSelectedIndex();
            }
        });

        day2ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDay2=day2ComboBox.getSelectedIndex();
            }
        });
        month2ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMonth2=month2ComboBox.getSelectedIndex();
            }
        });



        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    year1 = Integer.parseInt(year1Field.getText());
                    year2 = Integer.parseInt(year2Field.getText());
                    Data pierwszaData = new Data(selectedDay1, selectedMonth1, year1);
                    Data drugaData = new Data(selectedDay2, selectedMonth2, year2);
                    if (!pierwszaData.existsDate() || !drugaData.existsDate()) {
                        AnswerLabel.setText("Set a valid year, including the date!");
                    } else {
                        int roznica = pierwszaData.roznicaDat(pierwszaData, drugaData);
                        AnswerLabel.setText("The difference between these two dates is " + roznica + " days.");
                    }
                }
                catch (NumberFormatException o){
                    AnswerLabel.setText("Set a valid year, including the date!");
                }
            }
        });
    }
}
