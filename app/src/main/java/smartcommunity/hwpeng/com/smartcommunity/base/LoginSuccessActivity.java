package smartcommunity.hwpeng.com.smartcommunity.base;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.avos.avoscloud.AVUser;

import smartcommunity.hwpeng.com.smartcommunity.R;
import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginActivity;

/**
 * Created by hwpeng on 2017/9/29.
 */

public class LoginSuccessActivity extends BaseActivity implements View.OnClickListener{

    private Button logout;
    private Toolbar toolBar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);
        logout = (Button) findViewById(R.id.login_out);
        toolBar = (Toolbar)findViewById(R.id.login_success_toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.login_success_drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.login_success_nav_view);
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_white_36dp);
        }
        logout.setOnClickListener(this);

//        navigationView.setCheckedItem(R.id.news);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_out:
                AVUser.getCurrentUser().logOut();
                startActivity(new Intent(LoginSuccessActivity.this, LoginActivity.class));
                LoginSuccessActivity.this.finish();
                break;
            default:
                break;
        }
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
