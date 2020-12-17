import java.awt.Color;
public class Main {
    public static void main(String [] args){
        Scania hampus = new Scania(2, Color.black, 200, 3500);
        Volvo240 hampguzz = new Volvo240(4,Color.blue, 150, 1500);
        CarTransport ylva = new CarTransport(2, Color.red, 220, 4000, 3,0,0);
        Saab95 sanna = new Saab95(2, Color.gray, 130, 1350);
        Saab95 zannah = new Saab95(2, Color.blue, 130, 1350);
        Volvo240 papi = new Volvo240(4, Color.red, 150, 1500);
        OrdinaryWorkshop hampustwerkshop = new OrdinaryWorkshop(3);
        /* System.out.println(hampus.getEnginePower());
        System.out.println(hampguzz.getWeight());
        //ylva.addLoadedCars(hampus);
        ylva.addLoadedCars(hampguzz);
        System.out.println(ylva.getNrLoadedCars());
        ylva.addLoadedCars(sanna);
        ylva.addLoadedCars(zannah);
       // ylva.addLoadedCars(papi);
        System.out.println(ylva.getNrLoadedCars());*/

        hampustwerkshop.addToloadedCars(hampguzz);
        hampustwerkshop.addToloadedCars(sanna);
        hampustwerkshop.addToloadedCars(ylva);
        hampustwerkshop.addToloadedCars(hampus);


        System.out.println(hampustwerkshop.getNumberOfLoadedCars());











    }
}
