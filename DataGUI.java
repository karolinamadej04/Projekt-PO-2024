import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataGUI extends JFrame{
    private JPanel panel1;
    private JButton closeBtn;
    private JButton showDateBtn;
    private JButton addDaysBtn;
    private JButton addMonthsBtn;
    private JButton differenceBtn;
    private JPanel JPanel1;


    public DataGUI(){
        super("Date");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=500, height=320;
        this.setSize(width,height);
        setResizable(false);


        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { dispose();}
        });

        showDateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowDateGUI showDateGUI=new ShowDateGUI();
                showDateGUI.setVisible(true);
            }
        });
        addDaysBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDaysGUI addDaysGUI=new AddDaysGUI();
                addDaysGUI.setVisible(true);
            }
        });
        addMonthsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMonthsGUI addMonthsGUI=new AddMonthsGUI();
                addMonthsGUI.setVisible(true);
            }
        });
        differenceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DifferenceGUI differenceGUI=new DifferenceGUI();
                differenceGUI.setVisible(true);
            }
        });
    }
}
