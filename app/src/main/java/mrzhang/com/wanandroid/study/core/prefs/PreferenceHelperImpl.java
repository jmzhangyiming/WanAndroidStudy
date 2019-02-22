package mrzhang.com.wanandroid.study.core.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;

/**
 * @author mrzhang
 * @date 2019/1/16
 */
public class PreferenceHelperImpl implements PreferenceHelper {

    private final SharedPreferences mPreferences;

    @Inject
    PreferenceHelperImpl() {
        mPreferences = WanAndroidApp.getInstance().getSharedPreferences(Constants.MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

    @Override
    public boolean getNightModeState() {
        return mPreferences.getBoolean(Constants.NIGHT_MODE_STATE, false);
    }

    @Override
    public void setNightModeState(boolean b) {
        mPreferences.edit().putBoolean(Constants.NIGHT_MODE_STATE, b).apply();
    }

    @Override
    public void setCurrentPage(int position) {
        mPreferences.edit().putInt(Constants.CURRENT_PAGE, position).apply();
    }

    @Override
    public int getCurrentPage() {
        return mPreferences.getInt(Constants.CURRENT_PAGE, 0);
    }

}
