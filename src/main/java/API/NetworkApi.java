package API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetworkApi {


    BoardController boardController;
    public NetworkApi() {
        boardController = BoardController.getInstance();
    }

    @RequestMapping("/powerLeft")
    public String powerLeft(@RequestParam(value = "value", defaultValue = "50") String powerLeft) {
        boardController.onLeftPower(Integer.parseInt(powerLeft));
        return "Received" + System.currentTimeMillis();
    }

    @RequestMapping("/powerRight")
    public String powerRight(@RequestParam(value = "value", defaultValue = "50") String powerRight) {
        boardController.onRightPower(Integer.parseInt(powerRight));
        return "Received" + System.currentTimeMillis();
    }

    @RequestMapping("/check")
    public String check() {
        return "yeet";
    }

    @RequestMapping("/maxpwm")
    public String power(@RequestParam(value = "pwm", defaultValue = "50") String pwm) {
        boardController.onMaxPwm(Integer.parseInt(pwm));
        return "MaxPwm = " + pwm;
    }

    @RequestMapping("/soundSensorValue")
    public String soundSensorValue() {
        return boardController.onSoundMeasureRequest();
    }
}
