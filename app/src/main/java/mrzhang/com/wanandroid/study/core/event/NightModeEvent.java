package mrzhang.com.wanandroid.study.core.event;

/**
 * @author mrzhang
 * @date 2019/1/26
 */
public class NightModeEvent {

    private boolean isNightMode;

    public NightModeEvent(boolean isNightMode) {
        this.isNightMode = isNightMode;
    }

    public boolean isNightMode() {
        return isNightMode;
    }

    public void setNightMode(boolean nightMode) {
        isNightMode = nightMode;
    }

}
