package sensors;


import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.util.CommandArgumentParser;
public class SoundSensor {

    private Pin pin1;
    private Pin pin2;
    private GpioPinDigitalInput echo;
    private GpioPinDigitalOutput trigger;
    private SoundSensorCallback callback;
    private long startTime = 0;
    private long endTime = 0;
    private GpioPinListenerDigital pinListenerDigital;

    public SoundSensor(SoundSensorCallback sensorCallback, int triggerPin, int echoPin) {
        GpioController gpio = GpioFactory.getInstance();
        callback = sensorCallback;

        pin1 = CommandArgumentParser.getPin(
                RaspiPin.class,
                RaspiPin.getPinByAddress(triggerPin),
                new String[0]);

        trigger = gpio.provisionDigitalOutputPin(pin1);
        echo = gpio.provisionDigitalInputPin(RaspiPin.getPinByAddress(echoPin), PinPullResistance.PULL_DOWN);
        echo.setShutdownOptions(true);
        pinListenerDigital = new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                if (event.getState().isHigh() && startTime == 0) {
                    startTime = System.nanoTime();
                    endTime = 0;
                } else if (!event.getState().isHigh() && endTime == 0) {
                    endTime = System.nanoTime();
                    callback.onMeasureResult(calcDistance(endTime - startTime));
                    startTime = 0;
                }
            }
        };
        echo.addListener(pinListenerDigital);
    }

    private double calcDistance(long time) {
        System.out.println(time);
        return (346 / (2 * Math.pow(10.0, 7.0)) * (time));
    }

    public void measure()  {
        //echo.removeAllListeners();
        trigger.high();
        trigger.low();
        //echo.addListener(pinListenerDigital);
    }
}
