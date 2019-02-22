package mrzhang.com.wanandroid.study.app;

import java.io.File;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class Constants {

    /**
     * Tag fragment classify
     */
    public static final int TYPE_MAIN_PAGER = 0;

    public static final int TYPE_KNOWLEDGE = 1;

    public static final int TYPE_WX_ARTICLE = 2;

    public static final int TYPE_NAVIGATION = 3;

    public static final int TYPE_PROJECT = 4;

    public static final int TYPE_COLLECT = 5;

    public static final int TYPE_SETTING = 6;

    /**
     * Path
     */
    public static final String PATH_DATA = WanAndroidApp.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String MY_SHARED_PREFERENCE = "my_shared_preference";

    /**
     * Shared Preference key
     */
    public static final String NIGHT_MODE_STATE = "night_mode_state";

    /**
     * Intent params
     */
    public static final String ARG_PARAM1 = "param1";

    public static final String ARG_PARAM2 = "param2";

    public static final String CURRENT_PAGE = "current_page";

}
