package mrzhang.com.wanandroid.study.core;

import mrzhang.com.wanandroid.study.core.db.DbHelper;
import mrzhang.com.wanandroid.study.core.http.HttpHelper;
import mrzhang.com.wanandroid.study.core.prefs.PreferenceHelper;

/**
 * @author mrzhang
 * @date 2019/1/16
 */
public class DataManager implements HttpHelper, DbHelper, PreferenceHelper{

    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        this.mHttpHelper = httpHelper;
        this.mDbHelper = dbHelper;
        this.mPreferenceHelper = preferenceHelper;
    }

    @Override
    public boolean getNightModeState() {
        return mPreferenceHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean b) {
        mPreferenceHelper.setNightModeState(b);
    }
}
