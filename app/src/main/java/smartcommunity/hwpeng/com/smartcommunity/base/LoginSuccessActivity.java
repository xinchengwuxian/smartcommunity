package smartcommunity.hwpeng.com.smartcommunity.base;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.avos.avoscloud.AVUser;

import smartcommunity.hwpeng.com.smartcommunity.R;
import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginActivity;

/**
 * Created by hwpeng on 2017/9/29.
 */

public class LoginSuccessActivity extends BaseActivity {

    private Button logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);
        logout = (Button) findViewById(R.id.login_out);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVUser.getCurrentUser().logOut();
                startActivity(new Intent(LoginSuccessActivity.this, LoginActivity.class));
                LoginSuccessActivity.this.finish();
            }
        });
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//            // 按下BACK，同时没有重复
//            this.finish();
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }
}
