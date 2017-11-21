package smartcommunity.hwpeng.com.smartcommunity.base;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;

import org.litepal.LitePalApplication;

/**
 * Created by hwpeng on 2017/9/19.
 */

public class MyApplication extends LitePalApplication {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,"20UVXdbtfakwuldRqlN6EEk5-gzGzoHsz","iMSVHYQMrDDMhjj6fLCjP0zU");
        AVOSCloud.setDebugLogEnabled(true);
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
