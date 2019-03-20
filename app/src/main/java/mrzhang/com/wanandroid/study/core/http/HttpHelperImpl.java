package mrzhang.com.wanandroid.study.core.http;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import mrzhang.com.wanandroid.study.core.bean.BaseResponse;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;
import mrzhang.com.wanandroid.study.core.bean.main.login.LoginData;
import mrzhang.com.wanandroid.study.core.http.api.GeeksApis;

/**
 * 网络请求实现细节
 * @author mrzhang
 * @date 2019/1/16
 */
public class HttpHelperImpl implements HttpHelper {

    private GeeksApis mGeeksApis;

    @Inject
    HttpHelperImpl(GeeksApis geeksApis) {
        mGeeksApis = geeksApis;
    }

    @Override
    public Observable<BaseResponse<List<BannerData>>> getBannerData() {
        return mGeeksApis.getBannerData();
    }

    @Override
    public Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum) {
        return mGeeksApis.getFeedArticleList(pageNum);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return mGeeksApis.getLoginData(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword) {
        return mGeeksApis.getRegisterData(username, password, rePassword);
    }

    @Override
    public Observable<BaseResponse<LoginData>> logout() {
        return mGeeksApis.logout();
    }


}
