package mrzhang.com.wanandroid.study.ui.mainpager.adapter;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
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
        if (article.isCollect()) {
            helper.setImageResource(R.id.item_search_pager_like_iv, R.drawable.icon_like);
        } else {
            helper.setImageResource(R.id.item_search_pager_like_iv, R.drawable.icon_like_article_not_selected);
        }
        if (!TextUtils.isEmpty(article.getAuthor())) {
            helper.setText(R.id.item_search_pager_author, article.getAuthor());
        }
        setTag(helper, article);
        if (!TextUtils.isEmpty(article.getChapterName())) {
            String classifyName = article.getSuperChapterName() + " / " + article.getChapterName();
            helper.setText(R.id.item_search_pager_chapterName, classifyName);
        }

    }

    private void setTag(KnowledgeHierarchyListViewHolder helper, FeedArticleData article) {
        helper.getView(R.id.item_search_pager_tag_green_tv).setVisibility(View.GONE);
        helper.getView(R.id.item_search_pager_tag_red_tv).setVisibility(View.GONE);
        if (article.getSuperChapterName().contains(mContext.getString(R.string.open_project))) {
            setRedTag(helper, R.string.project);
        }

        if (article.getSuperChapterName().contains(mContext.getString(R.string.navigation))) {
            setRedTag(helper, R.string.navigation);
        }
        if (article.getNiceDate().contains(mContext.getString(R.string.minute))
                || article.getNiceDate().contains(mContext.getString(R.string.hour))
                || article.getNiceDate().contains(mContext.getString(R.string.one_day))) {
            helper.getView(R.id.item_search_pager_tag_green_tv).setVisibility(View.VISIBLE);
            helper.setText(R.id.item_search_pager_tag_green_tv, R.string.text_new);
        }

    }

    private void setRedTag(KnowledgeHierarchyListViewHolder helper, @StringRes int tagName) {
        helper.getView(R.id.item_search_pager_tag_red_tv).setVisibility(View.VISIBLE);
        helper.setText(R.id.item_search_pager_tag_red_tv, tagName);
    }
}
