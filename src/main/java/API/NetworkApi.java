package API;

import engine.EngineController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.GPIOPinPair;


@RestController
public class NetworkApi {


    private PowerRequestCallback powerRequestCallback;
    EngineController engineController;
    public NetworkApi() {
        engineController = new EngineController(new GPIOPinPair(0,2), new GPIOPinPair(16,15), new GPIOPinPair(13,12), new GPIOPinPair(5,4));
    }

    @RequestMapping("/powerLeft")
    public String powerLeft(@RequestParam(value = "value", defaultValue = "50") String powerLeft) {
        engineController.leftAxisPower(Integer.parseInt(powerLeft)/100);
        return "Received" + System.currentTimeMillis();
    }

    @RequestMapping("/powerRight")
    public String powerRight(@RequestParam(value = "value", defaultValue = "50") String powerRight) {
        engineController.rightAxisPower(Integer.parseInt(powerRight)/100);
        return "Received" + System.currentTimeMillis();
    }

    @RequestMapping("/check")
    public String check() {
        return "yeet";
    }

    @RequestMapping("/maxpwm")
    public String power(@RequestParam(value = "pwm", defaultValue = "50") String pwm) {
        engineController.setMaxPWM(Integer.parseInt(pwm));
        return "MaxPwm = " + pwm;
    }
}
