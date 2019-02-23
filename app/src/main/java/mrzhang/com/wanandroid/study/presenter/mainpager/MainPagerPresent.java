package mrzhang.com.wanandroid.study.presenter.mainpager;

import java.util.List;

import javax.inject.Inject;

import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.present.BasePresent;
import mrzhang.com.wanandroid.study.contract.mainpager.MainPagerContract;
import mrzhang.com.wanandroid.study.core.DataManager;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;
import mrzhang.com.wanandroid.study.utils.RxUtils;
import mrzhang.com.wanandroid.study.widget.BaseObserver;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class MainPagerPresent extends BasePresent<MainPagerContract.View> implements MainPagerContract.Present {

    private DataManager mDataManager;
    private boolean isRefresh = true;
    private int mCurrentPage;

    @Inject
    MainPagerPresent(DataManager dataManager) {
        super(dataManager);
        this.mDataManager = dataManager;
    }


    @Override
    public void autoRefresh(boolean isShowError) {
        isRefresh = true;
        mCurrentPage = 0;
        getBannerData(isShowError);
        getFeedArticleList(isShowError);
    }

    @Override
    public void getBannerData(boolean isShowError) {
        addSubscribe(mDataManager.getBannerData()
                    .compose(RxUtils.rxSchedulerHelper())
                    .compose(RxUtils.handleResult())
                    .subscribeWith(new BaseObserver<List<BannerData>>(mView,
                            WanAndroidApp.getInstance().getString(R.string.failed_to_obtain_banner_data),
                            isShowError) {
                                       @Override
                                       public void onNext(List<BannerData> bannerData) {
                                            mView.showBannerData(bannerData);
                                       }
                                   }
                    ));
    }

    @Override
    public void getFeedArticleList(boolean isShowError) {
        addSubscribe(mDataManager.getFeedArticleList(mCurrentPage)
                    .compose(RxUtils.rxSchedulerHelper())
                    .compose(RxUtils.handleResult())
                    .subscribeWith(new BaseObserver<FeedArticleListData>(mView,
                            WanAndroidApp.getInstance().getString(R.string.failed_to_obtain_article_list),
                            isShowError) {
                        @Override
                        public void onNext(FeedArticleListData feedArticleListData) {
                            mView.showArticleList(feedArticleListData, isRefresh);
                        }
                    }));
    }

    @Override
    public void loadMore() {
        mCurrentPage ++;
        isRefresh = false;
        loadMoreData();
    }

    @Override
    public void loadMoreData() {
        addSubscribe(mDataManager.getFeedArticleList(mCurrentPage)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<FeedArticleListData>(mView,
                        WanAndroidApp.getInstance().getString(R.string.failed_to_obtain_article_list),
                        false) {
                    @Override
                    public void onNext(FeedArticleListData feedArticleListData) {
                        mView.showArticleList(feedArticleListData, isRefresh);
                    }
                }));
    }

}
