import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDaysGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    private JButton goBackBtn;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JTextField yearField;
    private JTextField addDaysField;
    private JComboBox formComboBox;
    private JButton OKBtn;
    private JLabel Answer;
    private int day1;
    private int month1;
    private int year1;
    private int numOfDays;
    private int selectedForm;

    public AddDaysGUI(){
        super("Add days");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=800, height=350;
        this.setSize(width,height);
        setResizable(false);
        goBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        dayComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                day1=dayComboBox.getSelectedIndex();
            }
        });
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                month1=monthComboBox.getSelectedIndex();
            }
        });
        formComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedForm=formComboBox.getSelectedIndex();
            }
        });
        OKBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    year1 = Integer.parseInt(yearField.getText());
                    numOfDays = Integer.parseInt(addDaysField.getText());
                    Data nowaData = new Data(day1, month1, year1);
                    if (!nowaData.existsDate() || !(numOfDays >= 0)) Answer.setText("Invalid data.");
                    else {
                        switch (selectedForm){
                            case 1:{Answer.setText("The new date is: "+nowaData.przesunDate(nowaData,numOfDays).ddmmyyyyLong());break;}
                            case 2:{Answer.setText("The new date is: "+nowaData.przesunDate(nowaData,numOfDays).mmddyyyy());break;}
                            case 3:{Answer.setText("The new date is: "+nowaData.przesunDate(nowaData,numOfDays).mmddyyyyLong());break;}
                            default:{Answer.setText("The new date is: "+nowaData.przesunDate(nowaData,numOfDays).ddmmyyyy());break;}
                        }
                    }
                }
                catch (NumberFormatException o){
                    Answer.setText("Invalid data.");
                }
            }
        });
    }
}
