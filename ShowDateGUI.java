import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ShowDateGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    private JButton goBackBtn;
    private JComboBox formatComboBox;
    private JButton todayBtn;
    private JLabel todayJLabel;
    private int selectedValue;

    public Data todaysDate(){
        Calendar calendar = Calendar.getInstance();
        int locDay=calendar.get(Calendar.DAY_OF_MONTH);
        int locMonth=calendar.get(Calendar.MONTH)+1;
        int locYear=calendar.get(Calendar.YEAR);
        Data dzisiaj=new Data(locDay,locMonth,locYear);
        return dzisiaj;
    }

    public ShowDateGUI(){
        super("Today's date");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=500, height=320;
        this.setSize(width,height);
        setResizable(false);
        goBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        todayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data dzisiaj=todaysDate();
                switch (selectedValue){
                    case 1: {todayJLabel.setText("Today's date is: "+dzisiaj.ddmmyyyyLong());break;}
                    case 2: {todayJLabel.setText("Today's date is: "+dzisiaj.mmddyyyy());break;}
                    case 3: {todayJLabel.setText("Today's date is: "+dzisiaj.mmddyyyyLong());break;}
                    default: {todayJLabel.setText("Today's date is: "+dzisiaj.ddmmyyyy());break;}
                }
            }
        });
        formatComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedValue= formatComboBox.getSelectedIndex();
            }
        });
    }
}
