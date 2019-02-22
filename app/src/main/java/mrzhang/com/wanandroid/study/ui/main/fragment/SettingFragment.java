package mrzhang.com.wanandroid.study.ui.main.fragment;

import android.support.v7.widget.AppCompatCheckBox;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.component.Rxbus;
import mrzhang.com.wanandroid.study.contract.main.SettingContract;
import mrzhang.com.wanandroid.study.core.event.NightModeEvent;
import mrzhang.com.wanandroid.study.presenter.main.SettingPresent;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class SettingFragment extends BaseRootFragment<SettingPresent> implements SettingContract.View
        ,CompoundButton.OnCheckedChangeListener{

    @BindView(R.id.cb_setting_cache)
    AppCompatCheckBox mCbSettingCache;
    @BindView(R.id.cb_setting_image)
    AppCompatCheckBox mCbSettingImage;
    @BindView(R.id.cb_setting_night)
    AppCompatCheckBox mCbSettingNight;
    @BindView(R.id.ll_setting_feedback)
    TextView mLlSettingFeedback;
    @BindView(R.id.ll_setting_clear)
    LinearLayout mLlSettingClear;
    @BindView(R.id.tv_setting_clear)
    TextView mTvSettingClear;

    private File cacheFile;

    public static SettingFragment getInstance( ) {
        SettingFragment settingFragment = new SettingFragment();
        return settingFragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEventAndData() {
        cacheFile = new File(Constants.PATH_CACHE);
        mCbSettingNight.setChecked(mPresenter.getNightModeState());
        Log.i("test", mPresenter.getNightModeState() + "");
        mCbSettingCache.setOnCheckedChangeListener(this);
        mCbSettingImage.setOnCheckedChangeListener(this);
        mCbSettingNight.setOnCheckedChangeListener(this);

    }

    @OnClick({R.id.ll_setting_feedback, R.id.ll_setting_clear})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_setting_feedback:
//                ShareUtil.sendEmail(_mActivity, getString(R.string.send_email));
                break;
            case R.id.ll_setting_clear:
//                clearCache();
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.cb_setting_cache:

                break;
            case R.id.cb_setting_image:

                break;
            case R.id.cb_setting_night:
                mPresenter.setNightModeState(b);
                Rxbus.getDefault().post(new NightModeEvent(b));
                Log.i("test", mPresenter.getNightModeState() + "");
                break;
        }
    }
}
