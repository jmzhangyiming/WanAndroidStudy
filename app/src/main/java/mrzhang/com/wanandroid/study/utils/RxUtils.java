package mrzhang.com.wanandroid.study.utils;

import android.widget.Toast;

import org.reactivestreams.Publisher;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.core.bean.BaseResponse;
import mrzhang.com.wanandroid.study.core.bean.main.login.LoginData;
import mrzhang.com.wanandroid.study.core.http.exception.OtherException;
import mrzhang.com.wanandroid.study.utils.logger.CommonUtils;

/**
 * @author mrzhang
 * @date 2019/1/26
 */
public class RxUtils {

    /**
     * 统一线程处理(有背压)
     * @param <T> 指定的泛型类型
     * @return FlowableTransformer
     */
    public static <T> FlowableTransformer<T, T> rxFlSchedulerHelper() {
        return flowable -> flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        // lambda写法
//        return new FlowableTransformer<T, T>() {
//            @Override
//            public Publisher<T> apply(Flowable<T> upstream) {
//                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//            }
//        };
    }

    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一返回结果处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {

        return new ObservableTransformer<BaseResponse<T>, T>() {

            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
                        if (tBaseResponse.getErrorCode() == BaseResponse.SUCCESS
                                && tBaseResponse.getData() != null
                                && CommonUtils.isNetworkConnected()) {
                            return createData(tBaseResponse.getData());
                        }
                        else {
                            return Observable.error(new OtherException());
                        }
                    }
                });
            }
        };
    }

    /**
     * 退出登录返回结果处理(退出登录的data为null,单独处理)
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleLogoutResult() {
        return upstream -> upstream.flatMap((Function<BaseResponse<T>, ObservableSource<T>>) tBaseResponse -> {
            if (tBaseResponse.getErrorCode() == BaseResponse.SUCCESS
                    && CommonUtils.isNetworkConnected()) {
                //创建一个非空数据源，避免onNext()传入null
                return createData(CommonUtils.cast(new LoginData()));
            } else {
                return Observable.error(new OtherException());
            }
        });
    }

    /**
     * 得到 Observable
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }






}
