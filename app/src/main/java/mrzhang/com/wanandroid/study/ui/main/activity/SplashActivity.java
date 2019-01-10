package mrzhang.com.wanandroid.study.ui.main.activity;

import android.content.Intent;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import mrzhang.com.wanandroid.study.MainActivity;
import mrzhang.com.wanandroid.wanandroidstudy.R;
import mrzhang.com.wanandroid.study.app.WanAndroidApp;
import mrzhang.com.wanandroid.study.base.activity.BaseActivity;
import mrzhang.com.wanandroid.study.contract.main.SplashContract;
import mrzhang.com.wanandroid.study.presenter.main.SplashPresenter;
import mrzhang.com.wanandroid.study.utils.StatusBarUtil;

/**
 * @author zhangyiming
 * @date 2019/1/4
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.one_animation)
    LottieAnimationView mOneAnimation;
    @BindView(R.id.two_animation)
    LottieAnimationView mTwoAnimation;
    @BindView(R.id.three_animation)
    LottieAnimationView mThreeAnimation;
    @BindView(R.id.four_animation)
    LottieAnimationView mFourAnimation;
    @BindView(R.id.five_animation)
    LottieAnimationView mFiveAnimation;
    @BindView(R.id.six_animation)
    LottieAnimationView mSixAnimation;
    @BindView(R.id.seven_animation)
    LottieAnimationView mSevenAnimation;
    @BindView(R.id.eight_animation)
    LottieAnimationView mEightAnimation;
    @BindView(R.id.nine_animation)
    LottieAnimationView mNineAnimation;
    @BindView(R.id.ten_animation)
    LottieAnimationView mTenAnimation;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initToolbar() {
        if (!WanAndroidApp.isFirstRun) {
            jumpToMain();
            return;
        }
        WanAndroidApp.isFirstRun = false;
        StatusBarUtil.immersive(this);
    }

    @Override
    protected void initEventAndData() {
        startAnimation(mOneAnimation, "W.json");
        startAnimation(mTwoAnimation, "A.json");
        startAnimation(mThreeAnimation, "N.json");
        startAnimation(mFourAnimation, "A.json");
        startAnimation(mFiveAnimation, "N.json");
        startAnimation(mSixAnimation, "D.json");
        startAnimation(mSevenAnimation, "R.json");
        startAnimation(mEightAnimation, "O.json");
        startAnimation(mNineAnimation, "I.json");
        startAnimation(mTenAnimation, "D.json");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelAnimation();
    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void startAnimation(LottieAnimationView mlottieAnimationView, String animationName) {
        mlottieAnimationView.setAnimation(animationName);
        mlottieAnimationView.playAnimation();
    }

    private void cancelAnimation(LottieAnimationView mlottieAnimationView) {
        if (mlottieAnimationView != null) {
            mlottieAnimationView.cancelAnimation();
        }
    }

    private void cancelAnimation() {
        cancelAnimation(mOneAnimation);
        cancelAnimation(mTwoAnimation);
        cancelAnimation(mThreeAnimation);
        cancelAnimation(mFourAnimation);
        cancelAnimation(mFiveAnimation);
        cancelAnimation(mSixAnimation);
        cancelAnimation(mSevenAnimation);
        cancelAnimation(mEightAnimation);
        cancelAnimation(mNineAnimation);
        cancelAnimation(mTenAnimation);
    }


}
