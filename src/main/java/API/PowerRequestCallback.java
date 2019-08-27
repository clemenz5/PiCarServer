package API;

import org.springframework.stereotype.Component;

@Component
public interface PowerRequestCallback {
    void onPowerRequest(float leftAxis, float rightAxis);
}
