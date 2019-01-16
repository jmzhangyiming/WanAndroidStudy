package mrzhang.com.wanandroid.study.ui.main.fragment;

import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import mrzhang.com.wanandroid.study.app.Constants;
import mrzhang.com.wanandroid.study.base.fragment.BaseRootFragment;
import mrzhang.com.wanandroid.study.contract.main.SettingContract;
import mrzhang.com.wanandroid.study.presenter.main.SettingPresent;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/13
 */
public class SettingFragment extends BaseRootFragment<SettingPresent> implements SettingContract.View{

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
}
