package mrzhang.com.wanandroid.study.core.http.api;

import java.util.List;

import io.reactivex.Observable;
import mrzhang.com.wanandroid.study.core.bean.BaseResponse;
import mrzhang.com.wanandroid.study.core.bean.main.banner.BannerData;
import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleListData;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author mrzhang
 * @date 2019/1/28
 */
public interface GeeksApis {

    String HOST = "http://www.wanandroid.com/";

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    @GET("banner/json")
    Observable<BaseResponse<List<BannerData>>> getBannerData();

    /**
     * 获取feed文章列表
     *
     * @param num 页数
     * @return feed文章列表数据
     */
    @GET("article/list/{num}/json")
    Observable<BaseResponse<FeedArticleListData>> getFeedArticleList(@Path("num") int num);
}
