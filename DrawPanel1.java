import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;




// This panel represent the animated part of the view with the car images.

public class DrawPanel1<image> extends JPanel {

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    HashMap<String , BufferedImage > carimages = new HashMap();
    private ArrayList<Vehicle> bilisar = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel1(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.black);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            scaniaImage = ImageIO.read(DrawPanel1.class.getResourceAsStream("pics/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel1.class.getResourceAsStream("pics/Saab95.jpg"));
            volvoImage = ImageIO.read(DrawPanel1.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        //HashMap carimages = new HashMap();
        carimages.put("Volvo240", volvoImage);
        carimages.put("Saab95", saabImage);
        carimages.put("Scania340", scaniaImage);

    }
    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    public void receiveCars(ArrayList<Vehicle> bilar){
        this.bilisar=bilar;
    }
    public void paint(ArrayList<Vehicle> bilar){
        //paintComponent( getGraphics(),   bilar);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Vehicle car: bilisar) {

            g.drawImage(carimages.get(car.getModelName()), (int) car.getX(), (int) car.getY(), null);

            //super.paintComponent(g);
        }

       //     g.drawImage(carimages.get(car.modelName),(int)car.getX(),(int)car.getY(),null);

       /* if(carRepresentation.modelName.contains("Volvo240")) {
            g.drawImage(volvoImage, (int) carRepresentation.getX(), (int) carRepresentation.getY(), null);
        }
        if(carRepresentation.modelName.contains("Saab95")) {
            g.drawImage(saabImage,  (int)carRepresentation.getX(), (int) carRepresentation.getY() + 100, null);
        }
        if(carRepresentation.modelName.contains("Scania340")) {
            g.drawImage(scaniaImage,  (int) carRepresentation.getX(), (int) carRepresentation.getY() + 200, null);// see javadoc for more info on the parameters
        }
        */
    }
}


