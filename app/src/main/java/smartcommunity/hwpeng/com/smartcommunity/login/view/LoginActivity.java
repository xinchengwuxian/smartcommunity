package smartcommunity.hwpeng.com.smartcommunity.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVUser;

import de.hdodenhof.circleimageview.CircleImageView;
import smartcommunity.hwpeng.com.smartcommunity.R;
import smartcommunity.hwpeng.com.smartcommunity.base.BaseActivity;
import smartcommunity.hwpeng.com.smartcommunity.base.LoginSuccessActivity;
import smartcommunity.hwpeng.com.smartcommunity.login.presenter.LoginIPresenter;
import smartcommunity.hwpeng.com.smartcommunity.login.presenter.LoginPresenterImpl;
import smartcommunity.hwpeng.com.smartcommunity.register.view.RegisterActivity;
import smartcommunity.hwpeng.com.smartcommunity.utils.EditTextCheckNull;

/**
 * Created by hwpeng on 2017/9/25.
 */

public class LoginActivity extends BaseActivity implements LoginIView, View.OnClickListener {
    private LoginIPresenter loginIPresenter;
    private CircleImageView loginIcon;
    private EditText username;
    private EditText password;
    private TextView forgetPassword;

    private TextView newUser;
    private Button login;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        if (AVUser.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, LoginSuccessActivity.class));
            LoginActivity.this.finish();
        }
        loginIcon = (CircleImageView) findViewById(R.id.login_icon);
        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        forgetPassword = (TextView) findViewById(R.id.forget_password);
        newUser = (TextView) findViewById(R.id.new_user);
        login = (Button) findViewById(R.id.login_button);
        loginIPresenter = new LoginPresenterImpl(this);

        Intent registerIntent = getIntent();
        if(registerIntent != null) {
            String registerUsername = registerIntent.getStringExtra("username");
            String registerPassword = registerIntent.getStringExtra("password");
            username.setText(registerUsername);
            password.setText(registerPassword);
        }
        forgetPassword.setOnClickListener(this);
        newUser.setOnClickListener(this);
        login.setOnClickListener(this);
        loginIPresenter.init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_password:
                break;
            case R.id.new_user:
                startActivity(new Intent(LoginActivity.this,
                        RegisterActivity.class));
                finish();
                break;
            case R.id.login_button:
                if(!EditTextCheckNull.isNull(username) && !EditTextCheckNull.isNull(password)){
                    loginIPresenter.login(username.getText().toString(),password.getText().toString());
                }else{
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }

    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this,
                LoginSuccessActivity.class));
        finish();
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
    }
}
