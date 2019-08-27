package API;

import engine.EngineController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.GPIOPinPair;


@RestController
public class NetworkApi {


    private PowerRequestCallback powerRequestCallback;
    EngineController engineController;
    public NetworkApi() {
        engineController = new EngineController(new GPIOPinPair(17,27), new GPIOPinPair(14,15), new GPIOPinPair(10,9), new GPIOPinPair(23,24));
    }

    @RequestMapping("/engine")
    public String power(@RequestParam(value = "powerLeft", defaultValue = "50") String powerLeft, @RequestParam(value = "powerRight", defaultValue = "50") String powerRight) {
        engineController.leftAxisPower(Float.parseFloat(powerLeft)/100);
        engineController.rightAxisPower(Float.parseFloat(powerRight)/100);
        return "Received" + System.currentTimeMillis();
    }

    @RequestMapping("/check")
    public String check() {
        return "yeet";
    }

}
