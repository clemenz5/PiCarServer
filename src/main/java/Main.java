import API.Server;
import com.pi4j.io.gpio.*;
import org.springframework.boot.SpringApplication;


public class Main {

    public static void main(String[] args) {

        GpioController gpio = GpioFactory.getInstance();
        gpio.shutdown();

        SpringApplication.run(Server.class, args);



        /*
        SoundSensorCallback sensorCallback = distance -> System.out.println("Distance to next Object: " + distance);
        SoundSensor soundSensor = new SoundSensor(sensorCallback, 21, 20);
        EngineController engineController = new EngineController(new GPIOPinPair(17,27), new GPIOPinPair(14,15), new GPIOPinPair(10,9), new GPIOPinPair(23,24));
        StepperMotor stepperMotor = new StepperMotor(26,19,13,6);

        engineController.forward(0);
        while(true){
            while (stepperMotor.getDegree()>-45){
                stepperMotor.turnStepsCounterclockwise(1, 50);
                soundSensor.measure();
            }
            while (stepperMotor.getDegree()<45){
                stepperMotor.turnStepsClockwise(1, 50);
                soundSensor.measure();
            }
        }
        */

    }


}