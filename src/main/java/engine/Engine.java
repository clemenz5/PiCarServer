package engine;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;

class Engine {
    private Pin pin1;
    private Pin pin2;
    private GpioPinPwmOutput engine1;
    private GpioPinPwmOutput engine2;

    private static final int MAX_PWM = 100;

    Engine(int pin1Address, int pin2Address, int velocity) {
        GpioController gpio = GpioFactory.getInstance();

        pin1 = CommandArgumentParser.getPin(
                RaspiPin.class,
                RaspiPin.getPinByAddress(pin1Address),
                new String[0]);

        pin2 = CommandArgumentParser.getPin(
                RaspiPin.class,
                RaspiPin.getPinByAddress(pin2Address),
                new String[0]);

        engine1 = gpio.provisionSoftPwmOutputPin(pin1);
        engine2 = gpio.provisionSoftPwmOutputPin(pin2);

        engine1.setPwmRange(MAX_PWM);
        engine2.setPwmRange(MAX_PWM);

        power(velocity);
    }

    void power(int velocity) {
        if (velocity < 0 && velocity >= -100) {
            engine1.setPwm(-velocity);
            engine2.setPwm(0);
        } else {
            engine1.setPwm(0);
            engine2.setPwm(velocity);
        }

    }

    void setMaxPwm(int maxPwm){
        engine1.setPwmRange(maxPwm);
        engine2.setPwmRange(maxPwm);
    }


    void stop() {
        engine1.setPwm(0);
        engine2.setPwm(0);
    }
}
