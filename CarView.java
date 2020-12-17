import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarView extends JFrame {



    DrawPanel1 drawPanel = new DrawPanel1(X,Y-240);



    private static final int X = 1600;
    private static final int Y = 1100;


    public CarView(String framename){
        initComponents(framename);
    }


    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JSpinner brakeSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");


    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");


    JButton addsaab95Button = new JButton("Add Saab95");
    JButton addvolvo240Button = new JButton("Add Volvo240");
    JButton addscaniaButton = new JButton("Add Scania");
    JButton addvehicleButton = new JButton("Add Vehicle");
    JButton removeVehicleButton = new JButton("Remove Vehicle");
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step

        gasSpinner = new JSpinner(spinnerModel);


        brakeSpinner = new JSpinner(spinnerModel);

       // velocityPanel.setLayout(new FlowLayout());
       // carSpecifier.setText("This is a Saab95");
       // carVelocitySpecifier.setText("going at 200 mph");
       // velocityPanel.add(carSpecifier,FlowLayout.LEFT);
        //velocityPanel.add(carVelocitySpecifier,FlowLayout.CENTER);

        //this.add(velocityPanel);



        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);
        /*
        brakePanel.setLayout(new BorderLayout());//lagt till de fyra raderna
        brakePanel.add(brakeLabel,BorderLayout.PAGE_START);
        brakePanel.add(brakeSpinner,BorderLayout.PAGE_END);
        this.add(brakePanel);
        */
        controlPanel.setLayout(new GridLayout(2,8)); //här lägger vi

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addvolvo240Button,3);

        controlPanel.add(addsaab95Button,4);
        controlPanel.add(brakeButton, 5);
        controlPanel.add(turboOffButton, 6);
        controlPanel.add(lowerBedButton, 7);
        controlPanel.add(addscaniaButton,8);
        controlPanel.add(addvehicleButton,9);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/10-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/10-15,200));
        this.add(stopButton);

        removeVehicleButton.setPreferredSize(new Dimension(X/10-15,200));
        this.add(removeVehicleButton);

        // This actionListener is for the brake button only

        // TODO: Create more for each component as necessary


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




















}
