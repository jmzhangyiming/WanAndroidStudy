package mrzhang.com.wanandroid.study.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import mrzhang.com.wanandroid.study.di.module.AbstractAllActivityModule;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.di.module.AbstractAllFragmentModule;
import mrzhang.com.wanandroid.study.di.module.AppModule;
import mrzhang.com.wanandroid.study.di.module.HttpModule;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class,
        AbstractAllFragmentModule.class,
        AppModule.class,
        HttpModule.class})
public interface AppComponent {
    /**
     * 注入Application实例
     * @param wanAndroidApp
     */
    void inject(WanAndroidApp wanAndroidApp);



}
