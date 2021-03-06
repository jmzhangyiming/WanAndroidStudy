package mrzhang.com.wanandroid.study.contract.hierarchy;

import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public interface KnowledgeHierarchyContract {

    interface View extends AbstractView {

    }

    interface Prensent extends AbstractPresent<View> {

    }

}
