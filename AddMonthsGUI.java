import javax.swing.*;

public class AddMonthsGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    public AddMonthsGUI(){
        super("Add months");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=500, height=320;
        this.setSize(width,height);
        setResizable(false);
    }
}
