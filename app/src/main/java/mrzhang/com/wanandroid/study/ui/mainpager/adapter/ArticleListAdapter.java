package mrzhang.com.wanandroid.study.ui.mainpager.adapter;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import mrzhang.com.wanandroid.study.core.bean.main.collect.FeedArticleData;
import mrzhang.com.wanandroid.study.ui.mainpager.viewholder.KnowledgeHierarchyListViewHolder;
import mrzhang.com.wanandroid.wanandroidstudy.R;

/**
 * @author mrzhang
 * @date 2019/1/27
 */
public class ArticleListAdapter extends BaseQuickAdapter<FeedArticleData, KnowledgeHierarchyListViewHolder>{

    public ArticleListAdapter(int layoutResId, @Nullable List<FeedArticleData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(KnowledgeHierarchyListViewHolder helper, FeedArticleData article) {
        if (!TextUtils.isEmpty(article.getTitle())) {
            helper.setText(R.id.item_search_pager_title, Html.fromHtml(article.getTitle()));
        }
        if (!TextUtils.isEmpty(article.getAuthor())) {
            helper.setText(R.id.item_search_pager_author, article.getAuthor());
        }


    }

    private void setTag(KnowledgeHierarchyListViewHolder helper, FeedArticleData article) {
        helper.getView(R.id.item_search_pager_tag_green_tv).setVisibility(View.GONE);
        helper.getView(R.id.item_search_pager_tag_red_tv).setVisibility(View.GONE);

    }
}
