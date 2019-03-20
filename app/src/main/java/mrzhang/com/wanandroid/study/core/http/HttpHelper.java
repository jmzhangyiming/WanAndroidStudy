package mrzhang.com.wanandroid.study.core.http;

import java.util.List;

import io.reactivex.Observable;
import mrzhang.com.wanandroid.study.core.bean.BaseResponse;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;
import mrzhang.com.wanandroid.study.core.bean.main.login.LoginData;
import retrofit2.http.GET;

/**
 * @author mrzhang
 * @date 2019/1/16
 */
public interface HttpHelper {

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 取消收藏页面站内文章数据
     */
    Observable<BaseResponse<List<BannerData>>> getBannerData();

    /**
     * 获取feed文章列表
     *
     * @param pageNum 页数
     * @return feed文章列表数据
     */
    Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(int pageNum);

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 项目类别数据
     */
    Observable<BaseResponse<LoginData>> getLoginData(String username, String password);

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     *
     * @param username user name
     * @param password password
     * @param rePassword re password
     * @return 登陆数据
     */
    Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword);

    /**
     * 退出登录
     * http://www.wanandroid.com/user/logout/json
     */
    Observable<BaseResponse<LoginData>> logout();
}
