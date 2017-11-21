package smartcommunity.hwpeng.com.smartcommunity.loginSuccess.loginMainPager.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import smartcommunity.hwpeng.com.smartcommunity.R;
import smartcommunity.hwpeng.com.smartcommunity.base.BaseActivity;
import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginActivity;
import smartcommunity.hwpeng.com.smartcommunity.loginSuccess.loginMainPager.presenter.LoginMainPagerIPresenter;
import smartcommunity.hwpeng.com.smartcommunity.loginSuccess.loginMainPager.presenter.LoginMainPagerPresenterImpl;
import smartcommunity.hwpeng.com.smartcommunity.loginSuccess.weather.view.WeatherActivity;
import smartcommunity.hwpeng.com.smartcommunity.loginSuccess.weather.view.WeatherMainActivity;

/**
 * Created by hwpeng on 2017/11/20.
 */

public class LoginMainPagerActivity extends BaseActivity implements View.OnClickListener, LoginMainPagerIView {

    private Button logout;
    private Toolbar toolBar;
    private DrawerLayout drawerLayout;
    private LoginMainPagerIPresenter loginMainPagerIPresenter;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);

        loginMainPagerIPresenter = new LoginMainPagerPresenterImpl();

        drawerLayout = (DrawerLayout)findViewById(R.id.login_success_drawer);
        frameLayout = (FrameLayout) findViewById(R.id.login_success_main_frame);
        initView();
        NavigationView navigationView = (NavigationView) findViewById(R.id.login_success_nav_view);
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_white_36dp);
        }
        logout.setOnClickListener(this);

//        navigationView.setCheckedItem(R.id.picture);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
//                    case R.id.news:
//                        break;
                    case R.id.picture:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.video:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.chat:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.weather:
                        startActivity(new Intent(LoginMainPagerActivity.this, WeatherMainActivity.class));

                        break;
                    case R.id.setting:
                        drawerLayout.closeDrawers();
                        break;


                }

                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }


    private void initView(){
        View loginSuccessMainPager = View.inflate(this,R.layout.login_main_pager,null);
        logout = (Button) loginSuccessMainPager.findViewById(R.id.login_out);
        toolBar = (Toolbar)loginSuccessMainPager.findViewById(R.id.login_success_toolbar);
        frameLayout.addView(loginSuccessMainPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_out:
                loginMainPagerIPresenter.logout();
                startActivity(new Intent(this, LoginActivity.class));
                this.finish();
                break;
            default:
                break;
        }
    }
}
