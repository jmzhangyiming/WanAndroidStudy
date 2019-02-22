package mrzhang.com.wanandroid.study.core;

import java.util.List;

import io.reactivex.Observable;
import mrzhang.com.wanandroid.study.core.bean.BaseResponse;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;
import mrzhang.com.wanandroid.study.core.db.DbHelper;
import mrzhang.com.wanandroid.study.core.http.HttpHelper;
import mrzhang.com.wanandroid.study.core.prefs.PreferenceHelper;

/**
 * @author mrzhang
 * @date 2019/1/16
 */
public class DataManager implements HttpHelper, DbHelper, PreferenceHelper{

    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PreferenceHelper mPreferenceHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferenceHelper preferenceHelper) {
        this.mHttpHelper = httpHelper;
        this.mDbHelper = dbHelper;
        this.mPreferenceHelper = preferenceHelper;
    }

    @Override
    public boolean getNightModeState() {
        return mPreferenceHelper.getNightModeState();
    }

    @Override
    public void setNightModeState(boolean b) {
        mPreferenceHelper.setNightModeState(b);
    }

    @Override
    public void setCurrentPage(int position) {

    }

    @Override
    public int getCurrentPage() {
        return mPreferenceHelper.getCurrentPage();
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mHttpHelper.getBannerData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum) {
        return mHttpHelper.getFeedArticleList(pageNum);
    }




}
