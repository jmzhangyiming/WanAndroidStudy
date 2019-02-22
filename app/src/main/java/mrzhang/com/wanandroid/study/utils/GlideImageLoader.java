package mrzhang.com.wanandroid.study.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * @author mrzhang
 * @date 2019/2/16
 */
public class GlideImageLoader extends ImageLoader{


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }
}
