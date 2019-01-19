package mrzhang.com.wanandroid.study.core.prefs;

/**
 * @author mrzhang
 * @date 2019/1/16
 */
public interface PreferenceHelper {

    /**
     * Get night mode state
     *
     * @return if is night mode
     */
    boolean getNightModeState();

    /**
     * Set night mode state
     *
     * @param b current night mode state
     */
    void setNightModeState(boolean b);


}
