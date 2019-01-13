package mrzhang.com.wanandroid.study.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import mrzhang.com.wanandroid.study.base.fragment.BaseFragment;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
@Subcomponent(modules = {AndroidInjectionModule.class})
public interface BaseFragmentComponent extends AndroidInjector<BaseFragment> {

    /**
     * 每一个继承BaseActivity的Activity，都共享同一个SubComponent
     */
    @Subcomponent.Builder
    abstract class BaseBuilder extends AndroidInjector.Builder<BaseFragment> {

    }
}
