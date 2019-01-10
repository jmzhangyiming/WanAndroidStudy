package mrzhang.com.wanandroid.study.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import mrzhang.com.wanandroid.study.di.module.AbstractAllActivityModule;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractAllActivityModule.class})
public interface AppComponent {
    /**
     * 注入Application实例
     * @param wanAndroidApp
     */
    void inject(WanAndroidApp wanAndroidApp);

}
