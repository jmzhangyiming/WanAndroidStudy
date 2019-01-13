package mrzhang.com.wanandroid.study.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import mrzhang.com.wanandroid.study.di.component.BaseFragmentComponent;
import mrzhang.com.wanandroid.study.ui.main.mainpager.fragment.MainPagerFragment;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {

    @ContributesAndroidInjector(modules = MainPagerFragmentModule.class)
    abstract MainPagerFragment contributesMainPagerFragmentInject();

}
