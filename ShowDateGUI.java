import javax.swing.*;

public class ShowDateGUI extends JFrame {
    private JPanel panel1;
    private JPanel JPanel1;
    public ShowDateGUI(){
        super("Today's date");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width=500, height=320;
        this.setSize(width,height);
        setResizable(false);
    }
}
