package engine;



/**
 * This class serves as interface to control the Stepper Motor
 * The motor does a full rotation in 2048 Steps
 */
public class StepperMotor {
/*
    private DigitalOutputDevice in1;
    private DigitalOutputDevice in2;
    private DigitalOutputDevice in3;
    private DigitalOutputDevice in4;
    //this value represents the current degree of the motor
    private double degree = 0.0;
    private final double ANGLE_PER_STEP = 0.17578125;

    public StepperMotor(int pin1, int pin2, int pin3, int pin4) {
        in1 = new DigitalOutputDevice(pin1);
        in2 = new DigitalOutputDevice(pin2);
        in3 = new DigitalOutputDevice(pin3);
        in4 = new DigitalOutputDevice(pin4);
    }


    public void turnStepsClockwise(int steps, long gapTime) {
        for(int i = 0; i < steps; i++){
            clockwiseStep(gapTime);
        }
    }

    public void turnStepsCounterclockwise(int steps, long gapTime) {
        for(int i = 0; i < steps; i++){
            counterClockwiseStep(gapTime);
        }
    }

    /**
     *
     * @param gapTime sleepTime in millis
     */
/*
    private void clockwiseStep(long gapTime){
        for(int i = 0; i<4;i++){
            singleStep(i);
            SleepUtil.sleepMillis(gapTime);
        }
        degree += 0.703125;
        System.out.println("Stepper Motor Angle: " + degree);
    }

    private void counterClockwiseStep(long gapTime){
        for(int i = 3; i>=0;i--){
            singleStep(i);
            SleepUtil.sleepMillis(gapTime);
        }
        degree -= 0.703125;
        System.out.println("Stepper Motor Angle: " + degree);
    }

    public void setCurrentDegree(double currentDegree) {
        degree = currentDegree;
    }

    /**
     * get the current angle of the motor
     *
     * @return the angle
     */
/*
    public double getDegree() {
        return degree;
    }

    /**
     * Use this method to do one specific singleStep of the motor
     * you need to walk trough the steps 1-4 in correct order and loop them to make it move
     *
     * @param i must be between 1 and 4 to actually do something
     */
/*
    private void singleStep(int i) {
        switch (i) {
            case 0:
                in1.setValue(1);
                in2.setValue(0);
                in3.setValue(0);
                in4.setValue(0);
                break;
            case 1:
                in1.setValue(0);
                in2.setValue(1);
                in3.setValue(0);
                in4.setValue(0);
                break;
            case 2:
                in1.setValue(0);
                in2.setValue(0);
                in3.setValue(1);
                in4.setValue(0);
                break;
            case 3:
                in1.setValue(0);
                in2.setValue(0);
                in3.setValue(0);
                in4.setValue(1);
                break;
            default:
                in1.setValue(0);
                in2.setValue(0);
                in3.setValue(0);
                in4.setValue(0);
                break;
        }
    }
    */
}
