package mrzhang.com.wanandroid.study.presenter.hierarchy;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.hierarchy.KnowledgeHierarchyContract;
import mrzhang.com.wanandroid.study.core.DataManager;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class KnowledgeHierarchyPrensent extends BasePresent<KnowledgeHierarchyContract.View>
        implements KnowledgeHierarchyContract.Prensent {

    private DataManager mDataManager;

    @Inject
    KnowledgeHierarchyPrensent(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }
}
