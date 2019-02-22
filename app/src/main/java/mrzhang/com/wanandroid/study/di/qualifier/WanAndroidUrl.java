package mrzhang.com.wanandroid.study.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author mrzhang
 * @date 2019/1/29
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface WanAndroidUrl {
}
