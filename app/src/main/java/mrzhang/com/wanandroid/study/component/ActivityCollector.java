package mrzhang.com.wanandroid.study.component;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mrzhang
 * @date 2019/1/4
 * <p>
 * activity管理
 */
public class ActivityCollector {
    private static ActivityCollector activityCollector;

    public static ActivityCollector getInstance() {
        if (activityCollector == null) {
            activityCollector = new ActivityCollector();
        }
        return activityCollector;
    }

    private Set<Activity> allActivities;

    public void addActivty(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.remove(activity);
    }



}
