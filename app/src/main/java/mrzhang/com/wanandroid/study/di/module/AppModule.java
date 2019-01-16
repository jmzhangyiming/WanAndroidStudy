package mrzhang.com.wanandroid.study.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.core.DataManager;
import mrzhang.com.wanandroid.study.core.db.DbHelper;
import mrzhang.com.wanandroid.study.core.db.DbHelperImpl;
import mrzhang.com.wanandroid.study.core.http.HttpHelper;
import mrzhang.com.wanandroid.study.core.http.HttpHelperImpl;
import mrzhang.com.wanandroid.study.core.prefs.PreferenceHelper;
import mrzhang.com.wanandroid.study.core.prefs.PreferenceHelperImpl;

/**
 * @author mrzhang
 * @date 2019/1/6
 */
@Module
public class AppModule {

    private final WanAndroidApp application;

    public AppModule(WanAndroidApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    WanAndroidApp provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper providerDbHelper(DbHelperImpl dbHelperImpl) {
        return dbHelperImpl;
    }

    @Provides
    @Singleton
    PreferenceHelper providerPreferenceHelper(PreferenceHelperImpl preferenceHelperImpl) {
        return preferenceHelperImpl;
    }

    @Provides
    @Singleton
    DataManager providerDataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        return new DataManager(httpHelper, dbHelper, preferenceHelper);
    }

}
