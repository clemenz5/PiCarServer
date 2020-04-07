package API;

public interface RequestCallback {
    void onPowerRequest(int leftAxis, int rightAxis);
    void onLeftPower(int leftAxis);
    void onRightPower(int rightAxis);
    void onMaxPwm(int maxPwm);
    String onSoundMeasureRequest();
}
