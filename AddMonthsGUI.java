import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMonthsGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    private JButton goBackBtn;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JTextField addMonthsField;
    private JTextField yearField;
    private JLabel Answer;
    private JButton OKBtn;
    private JComboBox formComboBox;
    private int day1;
    private int month1;
    private int year1;
    private int numOfMonths;
    private int selectedForm;

    public AddMonthsGUI(){
        super("Add months");
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
                    numOfMonths = Integer.parseInt(addMonthsField.getText());
                    Data nowaData = new Data(day1, month1, year1);
                    if (!nowaData.existsDate() || !(numOfMonths > 0)) Answer.setText("Invalid data.");
                    else {
                        switch (selectedForm){
                            case 1:{Answer.setText("The new date is: "+nowaData.dodajMiesiace(nowaData,numOfMonths).ddmmyyyyLong());break;}
                            case 2:{Answer.setText("The new date is: "+nowaData.dodajMiesiace(nowaData,numOfMonths).mmddyyyy());break;}
                            case 3:{Answer.setText("The new date is: "+nowaData.dodajMiesiace(nowaData,numOfMonths).mmddyyyyLong());break;}
                            default:{Answer.setText("The new date is: "+nowaData.dodajMiesiace(nowaData,numOfMonths).ddmmyyyy());break;}
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
