package API;

import API.PowerRequestCallback;
import com.diozero.util.SleepUtil;
import engine.EngineController;
import engine.StepperMotor;
import org.springframework.stereotype.Component;
import sensors.SoundSensor;
import sensors.SoundSensorCallback;
import utils.GPIOPinPair;

@Component
public class BoardController implements PowerRequestCallback {
    private EngineController engineController;
    private StepperMotor stepperMotor;
    private SoundSensor soundSensor;

    public BoardController() {


        //    engineController = new EngineController(new GPIOPinPair(27, 17), new GPIOPinPair(14, 15), new GPIOPinPair(10, 9), new GPIOPinPair(23, 24));
        /*
        SoundSensorCallback sensorCallback = distance -> System.out.println("Distance to next Object: " + distance);
        soundSensor = new SoundSensor(sensorCallback, 21, 20);

        engineController.leftAxisPower(0f);
        engineController.rightAxisPower(0f);

        stepperMotor = new StepperMotor(26, 19, 13, 6);

        engineController.leftAxisPower(0);
        engineController.rightAxisPower(0);

        while (true) {
            while (stepperMotor.getDegree() > -45) {
                stepperMotor.turnStepsCounterclockwise(1, 50);
                soundSensor.measure();
            }
            while (stepperMotor.getDegree() < 45) {
                stepperMotor.turnStepsClockwise(1, 50);
                soundSensor.measure();
            }
        }

         */
    }

    @Override
    public void onPowerRequest(float leftAxis, float rightAxis) {
        engineController.leftAxisPower(leftAxis / 100);
        engineController.rightAxisPower(rightAxis / 100);
        String s = "leftAxis: " + leftAxis + " rightAxis: " + rightAxis;
        System.out.println(s);
    }


}
