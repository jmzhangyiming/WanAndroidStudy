package mrzhang.com.wanandroid.study.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;

/**
 * @author mrzhang
 * @date 2019/1/5
 */
@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {

    /**
     * 每一个继承BaseActivity的Activity，都共享同一个SubComponent
     */
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {

    }
}
