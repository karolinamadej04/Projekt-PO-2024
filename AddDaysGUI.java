import javax.swing.*;

public class AddDaysGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    public AddDaysGUI(){
        super("Add days");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=500, height=320;
        this.setSize(width,height);
        setResizable(false);
    }
}
