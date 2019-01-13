package mrzhang.com.wanandroid.study.contract.mainpager;

import mrzhang.com.wanandroid.study.base.fragment.BaseFragment;
import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public interface MainPagerContract {

    interface View extends AbstractView {

    }

    interface Present extends AbstractPresent<View> {

    }
}
