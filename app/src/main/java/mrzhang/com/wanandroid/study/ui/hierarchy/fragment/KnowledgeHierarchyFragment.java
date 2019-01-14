package mrzhang.com.wanandroid.study.ui.hierarchy.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.contract.hierarchy.KnowledgeHierarchyContract;
import mrzhang.com.wanandroid.study.presenter.hierarchy.KnowledgeHierarchyPrensent;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class KnowledgeHierarchyFragment extends BaseRootFragment<KnowledgeHierarchyPrensent>
        implements KnowledgeHierarchyContract.View {

    public static KnowledgeHierarchyFragment getInstance() {
        KnowledgeHierarchyFragment knowledgeHierarchyFragment = new KnowledgeHierarchyFragment();
        return knowledgeHierarchyFragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_knowledge_hierarchy;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }
}
