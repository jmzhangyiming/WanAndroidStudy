package mrzhang.com.wanandroid.study.app;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import mrzhang.com.wanandroid.study.di.component.DaggerAppComponent;
import mrzhang.com.wanandroid.study.di.module.AppModule;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
public class WanAndroidApp extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;
    private static WanAndroidApp instance;
    // 是否是第一次启动
    public static boolean isFirstRun = true;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }

    public static WanAndroidApp getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build().inject(this);

        instance = this;

    }
}
