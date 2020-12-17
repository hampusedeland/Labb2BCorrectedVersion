import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {



    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private CarView carviewer;
    private CarModel carmodel;
    private SpeedViewer speedViewer;
    int gasAmount = 0;
    int brakeAmount=0;

    public CarController(CarView carviewer, CarModel carmodel, SpeedViewer speedViewer){
        this.carmodel=carmodel;
        this.carviewer=carviewer;

        this.speedViewer=speedViewer;
        this.carviewer.liftBedButton.addActionListener(new BedUpListener());
        this.carviewer.lowerBedButton.addActionListener(new BedDownListener());
        this.carviewer.turboOnButton.addActionListener(new TurboOnListener());
        this.carviewer.turboOffButton.addActionListener(new TurboOffListener());
        this.carviewer.stopButton.addActionListener(new StopListener());
        this.carviewer.startButton.addActionListener(new StartListener());
        this.carviewer.gasSpinner.addChangeListener(new GasListener());
        this.carviewer.brakeSpinner.addChangeListener(new BrakeListener());
        this.carviewer.gasButton.addActionListener(new GasButtonListener());
        this.carviewer.brakeButton.addActionListener(new BrakeButtonListener());
        this.carviewer.addvehicleButton.addActionListener(new VehicleCreatorListener());
        this.carviewer.addvolvo240Button.addActionListener(new Volvo240CreatorListener());
        this.carviewer.addscaniaButton.addActionListener(new ScaniaCreatorListener());
        this.carviewer.addsaab95Button.addActionListener(new Saab95CreatorListener());
        this.carviewer.removeVehicleButton.addActionListener(new RemoveCarListener());
        //this.carviewer.removeVehicleButton.addActionListener(e->carmodel.removeCar());

    }



    public void startTimer(){
        timer.start();
    }

    class RemoveCarListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.removeCar();
       }
    }

    class StartListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.startCars();
        }
    }
    class StopListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.stopCars();
        }
    }

    class BrakeListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            brakeAmount= (int) ((JSpinner)e.getSource()).getValue();
        }

    }

    class GasListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            gasAmount = (int) ((JSpinner)e.getSource()).getValue();
        }
    }

    class GasButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.gas(gasAmount);
        }
    }

    class BrakeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.brake(brakeAmount);
        }
    }
    class BedDownListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.setBedDown();
        }

    }
    class BedUpListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.liftBed();
        }
    }

    class TurboOnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.setTurboOn();
        }
    }

    class TurboOffListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.setTurboOff();
        }
    }

    class Saab95CreatorListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.createSaabs();
        }
    }
    class Volvo240CreatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.createVolvos();
        }
    }

    class ScaniaCreatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.createScanias();
        }
    }
    class VehicleCreatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            carmodel.createVechicle();
        }
    }

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carviewer.drawPanel.receiveCars(carmodel.getCars());
            carviewer.drawPanel.repaint();
            speedViewer.updateSpedometer(carmodel.speedometer());
            carmodel.move();
        }
    }















}
