import javax.swing.*;
import java.awt.*;

public class DrawPanel2 extends JPanel {



    public DrawPanel2(int x, int y){
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
    }


}
