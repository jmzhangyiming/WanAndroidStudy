package mrzhang.com.wanandroid.study.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.core.http.api.GeeksApis;
import mrzhang.com.wanandroid.study.di.qualifier.WanAndroidUrl;
import mrzhang.com.wanandroid.study.utils.logger.CommonUtils;
import mrzhang.com.wanandroid.wanandroidstudy.BuildConfig;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author mrzhang
 * @date 2019/1/29
 */
@Module
public class HttpModule {

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            // 添加消息拦截器，方便查看打印
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
            // 添加stetho工具的StethoInterceptor
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 10244 * 50);
        Interceptor cacheInterceptor = chain -> {

            // 处理没有网络的时候，拦截Request
            Request request = chain.request();
            if (!CommonUtils.isNetworkConnected()) {
                request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);

            if (CommonUtils.isNetworkConnected()) {
                int maxAge = 0;
                // 有网络时，不缓存， 最大保存时长为0，向server 发送http 请求确认 ,该资源是否有修改
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .removeHeader("Pragma")
                        .build();
            } else {
                // 无网络时，设置超时为4周
                int maxStale = 60 * 60 * 24 * 28;
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
            return response;
        };

        // 设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);

        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);

        // 错误重连
        builder.retryOnConnectionFailure(true);

        //cookie认证
        builder.cookieJar(new PersistentCookieJar(new SetCookieCache(),
                new SharedPrefsCookiePersistor(WanAndroidApp.getInstance())));
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    @WanAndroidUrl
    Retrofit provideGeeksRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, GeeksApis.HOST);
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder.baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    GeeksApis provideGeeksApi(@WanAndroidUrl Retrofit retrofit) {
        return retrofit.create(GeeksApis.class);
    }

}
