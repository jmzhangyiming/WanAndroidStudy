package mrzhang.com.wanandroid.study.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mrzhang.com.wanandroid.study.di.component.BaseActivityComponent;
import mrzhang.com.wanandroid.study.ui.main.activity.LoginActivity;
import mrzhang.com.wanandroid.study.ui.main.activity.MainActivity;
import mrzhang.com.wanandroid.study.ui.main.activity.RegisterActivity;
import mrzhang.com.wanandroid.study.ui.main.activity.SplashActivity;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity contributeSplashActivitytInjector();

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributeLoginActivitytInjector();

    @ContributesAndroidInjector(modules = RegisterActivityModule.class)
    abstract RegisterActivity contributeRegisterActivitytInjector();
}
