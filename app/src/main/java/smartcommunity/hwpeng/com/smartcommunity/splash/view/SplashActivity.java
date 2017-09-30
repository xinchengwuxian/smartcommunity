package smartcommunity.hwpeng.com.smartcommunity.splash.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import smartcommunity.hwpeng.com.smartcommunity.R;
import smartcommunity.hwpeng.com.smartcommunity.base.BaseActivity;
import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginActivity;
import smartcommunity.hwpeng.com.smartcommunity.splash.presenter.SpalshPresenterImpl;
import smartcommunity.hwpeng.com.smartcommunity.splash.presenter.SplashIPresenter;

/**
 * Created by hwpeng on 2017/9/25.
 */

public class SplashActivity extends BaseActivity implements SplashIView {
    private SplashIPresenter splashIPresenter;
    private ImageView splash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        splashIPresenter = new SpalshPresenterImpl(this);
        splash = (ImageView) findViewById(R.id.splash);
        splashIPresenter.startAnim(splash);
    }


    @Override
    public void jumpNextActivity() {
        startActivity(new Intent(SplashActivity.this,
                LoginActivity.class));
        finish();
    }
}
