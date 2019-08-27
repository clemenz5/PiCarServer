package engine;

import org.springframework.stereotype.Component;
import utils.GPIOPinPair;
import utils.Strings;

/**
 * This class is designed to be an Interface to the engines
 */
public class EngineController {
    private Engine frontLeftEngine;
    private Engine frontRightEngine;
    private Engine backLeftEngine;
    private Engine backRightEngine;

    /**
     * Pass the pins for the Engines. If the Engines are not working correctly e.g. spinning in the wrong direction,
     * swap the pins in the Tupel
     *
     * @param frontLeft  the pins controlling the front Left engine
     * @param frontRight the pins controlling the front Right engine
     * @param backLeft   the pins controlling the back Left engine
     * @param backRight  the pins controlling the back Right engine
     */
    public EngineController(GPIOPinPair frontLeft, GPIOPinPair frontRight, GPIOPinPair backLeft, GPIOPinPair backRight) {
        frontLeftEngine = new Engine(frontLeft.getPin1(), frontLeft.getPin2(), 0);
        frontRightEngine = new Engine(frontRight.getPin1(), frontRight.getPin2(), 0);
        backLeftEngine = new Engine(backLeft.getPin1(), backLeft.getPin2(), 0);
        backRightEngine = new Engine(backRight.getPin1(), backRight.getPin2(), 0);
    }

    public void leftAxisPower(float velocity){
        if (velocity < -1 || velocity > 1) {
            throw new IllegalArgumentException(Strings.VELOCITY_RANGE);
        }
        frontLeftEngine.power(velocity);
        backLeftEngine.power(velocity);
    }

    public void rightAxisPower(float velocity){
        if (velocity < -1 || velocity > 1) {
            throw new IllegalArgumentException(Strings.VELOCITY_RANGE);
        }
        frontRightEngine.power(velocity);
        backRightEngine.power(velocity);
    }
}
