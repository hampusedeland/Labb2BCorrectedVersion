import java.awt.*;

public class VehicleApplication {

    public static void main(String[] args) {
        CarView carvi = new CarView("frame");
        CarModel carmod = new CarModel(carvi.getWidth(),carvi.getHeight());

        SpeedViewer spedvi = new SpeedViewer("speedframe");

        CarController cc = new CarController(carvi, carmod,spedvi);

        cc.startTimer();

    }
}
