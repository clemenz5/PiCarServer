package API;

import engine.EngineController;
import engine.StepperMotor;
import sensors.SoundSensor;
import sensors.SoundSensorCallback;
import utils.GPIOPinPair;

public class BoardController implements RequestCallback, SoundSensorCallback {
    private EngineController engineController;
    private StepperMotor stepperMotor;
    private SoundSensor soundSensor;
    private double lastSoundSensorValue = 0;
    private static BoardController boardController;

    private BoardController() {

        engineController = new EngineController(new GPIOPinPair(0,2), new GPIOPinPair(16,15), new GPIOPinPair(13,12), new GPIOPinPair(5,4));

        soundSensor = new SoundSensor(this, 29, 28);
/*
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
    public void onPowerRequest(int leftAxis, int rightAxis) {
        engineController.leftAxisPower(leftAxis / 100);
        engineController.rightAxisPower(rightAxis / 100);
        String s = "leftAxis: " + leftAxis + " rightAxis: " + rightAxis;
        System.out.println(s);
    }

    @Override
    public void onLeftPower(int leftAxis) {
        engineController.leftAxisPower(leftAxis);
        String s = "leftAxis: " + leftAxis;
        System.out.println(s);
    }

    @Override
    public void onRightPower(int rightAxis) {
        engineController.rightAxisPower(rightAxis);
        String s = "rightAxis: " + rightAxis;
        System.out.println(s);
    }

    @Override
    public void onMaxPwm(int maxPwm) {
        engineController.setMaxPWM(maxPwm);
    }

    @Override
    public String onSoundMeasureRequest() {
        soundSensor.measure();
        return lastSoundSensorValue+"";
    }


    @Override
    public void onMeasureResult(double distance) {
        lastSoundSensorValue = distance;
    }

    public static BoardController getInstance(){
        if(boardController == null){
            boardController = new BoardController();
        }
        return boardController;
    }
}