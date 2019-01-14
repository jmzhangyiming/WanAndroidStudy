package mrzhang.com.wanandroid.study.ui.project.fragment;

import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;

/**
 * @author mrzhang
 * @date 2019/1/14
 */
public class ProjectFragment extends BaseRootFragment{

    public static ProjectFragment getInstance() {
        ProjectFragment projectFragment = new ProjectFragment();
        return projectFragment;
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {

    }
}
