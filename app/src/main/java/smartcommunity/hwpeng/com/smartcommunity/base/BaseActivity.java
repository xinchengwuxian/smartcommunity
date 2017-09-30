package smartcommunity.hwpeng.com.smartcommunity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import smartcommunity.hwpeng.com.smartcommunity.utils.LogUtil;

/**
 * Created by hwpeng on 2017/9/19.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d("BaseActivity", getClass().getSimpleName());
    }
}
