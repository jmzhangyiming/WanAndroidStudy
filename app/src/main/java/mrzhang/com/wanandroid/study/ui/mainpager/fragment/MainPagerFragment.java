package mrzhang.com.wanandroid.study.ui.mainpager.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.contract.mainpager.MainPagerContract;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;
import mrzhang.com.wanandroid.study.presenter.mainpager.MainPagerPresent;
import mrzhang.com.wanandroid.study.ui.mainpager.adapter.ArticleListAdapter;
import mrzhang.com.wanandroid.study.utils.GlideImageLoader;
import mrzhang.com.wanandroid.study.utils.logger.LogHelper;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class MainPagerFragment extends BaseRootFragment<MainPagerPresent> implements MainPagerContract.View{

    @BindView(R.id.normal_view)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.main_pager_recycler_view)
    RecyclerView mRecyclerView;

    private List<FeedArticleData> mFeedArticleDataList;
    private ArticleListAdapter mAdapter;

    private int articlePosition;
    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;
    private Banner mBanner;
    private boolean isRecreate;


    public static MainPagerFragment getInstance(boolean param1, String param2) {
        MainPagerFragment mainPagerFragment = new MainPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(Constants.ARG_PARAM1, param1);
        bundle.putString(Constants.ARG_PARAM2, param2);
        mainPagerFragment.setArguments(bundle);
        return  mainPagerFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }

    @Override
    protected void initView() {
        super.initView();
        initRecyclerView();
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        setRefresh();
        mPresenter.autoRefresh(true);
    }

    private void initRecyclerView() {
        // 初始化首页RecyclerView
        mFeedArticleDataList = new ArrayList<>();
        mAdapter = new ArticleListAdapter(R.layout.item_search_pager, mFeedArticleDataList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        mRecyclerView.setHasFixedSize(true);

        // 添加首页banner
        LinearLayout mHeaderGroup = (LinearLayout) LayoutInflater.from(_mActivity).inflate(R.layout.head_banner, null);
        mBanner = mHeaderGroup.findViewById(R.id.head_banner);
        // 移除mHeaderGroup中的mBanner，避免mBanner不释放，mHeaderGroup不能回收，内存泄漏
        mHeaderGroup.removeView(mBanner);
        mAdapter.addHeaderView(mBanner);

        mRecyclerView.setAdapter(mAdapter);

    }

    private void setRefresh() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            mPresenter.autoRefresh(false);
            refreshLayout.finishRefresh(1000);
        });
    }


    @Override
    public void showBannerData(List<BannerData> bannerDataList) {
        mBannerTitleList = new ArrayList<>();
        List<String> bannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for (BannerData bannerData : bannerDataList) {
            mBannerTitleList.add(bannerData.getTitle());
            bannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(bannerImageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(bannerDataList.size() * 400);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);

        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void showArticleList(FeedArticleListData feedArticleListData, boolean isRefresh) {
        if (mPresenter.getCurrentPage() == Constants.TYPE_MAIN_PAGER) {
            mRecyclerView.setVisibility(View.VISIBLE);
        } else {
            mRecyclerView.setVisibility(View.INVISIBLE);
        }
        if (mAdapter == null) {
            return;
        }

    }
}
