package mrzhang.com.wanandroid.study.contract.mainpager;

import java.util.List;

import mrzhang.com.wanandroid.study.base.fragment.BaseFragment;
import mrzhang.com.wanandroid.study.base.present.AbstractPresent;
import mrzhang.com.wanandroid.study.base.view.AbstractView;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public interface MainPagerContract {

    interface View extends AbstractView {
        /**
         * Show banner data
         *
         * @param bannerDataList List<BannerData>
         */
        void showBannerData(List<BannerData> bannerDataList);

        /**
         * Show content
         *
         * @param feedArticleListData FeedArticleListData
         * @param isRefresh If refresh
         */
        void showArticleList(FeedArticleListData feedArticleListData, boolean isRefresh);
    }

    interface Present extends AbstractPresent<View> {
        /**
         * Auto refresh
         *
         * @param isShowError If show error
         */
        void autoRefresh(boolean isShowError);

        /**
         * Get banner data
         *
         * @param isShowError If show error
         */
        void getBannerData(boolean isShowError);

        /**
         * Get feed article list
         *
         * @param isShowError If show error
         */
        void getFeedArticleList(boolean isShowError);

        /**
         * Load more
         */
        void loadMore();

        /**
         * Load more data
         */
        void loadMoreData();

    }
}
