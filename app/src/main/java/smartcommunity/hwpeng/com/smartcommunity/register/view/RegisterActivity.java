package smartcommunity.hwpeng.com.smartcommunity.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import smartcommunity.hwpeng.com.smartcommunity.R;
import smartcommunity.hwpeng.com.smartcommunity.base.BaseActivity;
import smartcommunity.hwpeng.com.smartcommunity.base.LoginSuccessActivity;
import smartcommunity.hwpeng.com.smartcommunity.login.presenter.LoginIPresenter;
import smartcommunity.hwpeng.com.smartcommunity.login.presenter.LoginPresenterImpl;
import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginActivity;
import smartcommunity.hwpeng.com.smartcommunity.register.presenter.RegisterIPresenter;
import smartcommunity.hwpeng.com.smartcommunity.register.presenter.RegisterPresenterImpl;
import smartcommunity.hwpeng.com.smartcommunity.register.utils.MyCountDownTimer;
import smartcommunity.hwpeng.com.smartcommunity.utils.EditTextCheckNull;

/**
 * Created by hwpeng on 2017/9/25.
 */

public class RegisterActivity extends BaseActivity implements RegisterIView, View.OnClickListener {


//    private EditText phoneNumber;
    private EditText password;
    private EditText passwordConfirm;
//    private EditText identifyCode;
//    private Button getCodeButton;
    private EditText registerUsename;
    private Button registerButton;
    private RegisterIPresenter registerIPresenter;
    private MyCountDownTimer myCountDownTimer;
    private long millisInFuture = 60000;
    private long countDownInterval = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        registerUsename = (EditText) findViewById(R.id.register_username);
//        phoneNumber = (EditText) findViewById(R.id.phone_number);
        password = (EditText) findViewById(R.id.password);
        passwordConfirm = (EditText) findViewById(R.id.password_confirm);
//        identifyCode = (EditText) findViewById(R.id.identify_code);
//        getCodeButton = (Button) findViewById(R.id.get_code_btn);
        registerButton = (Button) findViewById(R.id.register_button);
        registerIPresenter = new RegisterPresenterImpl(this);
//        myCountDownTimer = new MyCountDownTimer(millisInFuture, countDownInterval, getCodeButton);
//        getCodeButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.get_code_btn:
//                if(!EditTextCheckNull.isNull(phoneNumber)) {
//                    registerIPresenter.getIdentifyCode(phoneNumber.getText().toString());
//                } else {
//                    toastShow("请输入手机号码");
//                }
//                break;
            case R.id.register_button:
                if(!EditTextCheckNull.isNull(registerUsename) && !EditTextCheckNull.isNull(password)){
                    if(password.getText().toString().equals(passwordConfirm.getText().toString())){
                        registerIPresenter.registerUser(registerUsename.getText().toString(),
                                password.getText().toString());
                    }else {
                        toastShow("密码不一致");
                    }
                }else {
                    toastShow("用户名 密码不能为空");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onRegisterSuccess() {
        toastShow("注册成功");
        Intent goToLogin = new Intent(RegisterActivity.this,
                LoginSuccessActivity.class);
//        goToLogin.putExtra("username",registerUsename.getText().toString());
//        goToLogin.putExtra("password", password.getText().toString());
        startActivity(goToLogin);
        finish();
    }

    @Override
    public void onRegisterFailed() {
        toastShow("注册失败");
    }

    @Override
    public void getIdentifyCodeSuccess() {
        myCountDownTimer.start();
    }

    @Override
    public void getIdentifyCodeFailed() {
        toastShow("验证码发送失败");
    }

    @Override
    public void toastShow(String message){
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // 按下BACK，同时没有重复
            startActivity(new Intent(RegisterActivity.this,
                    LoginActivity.class));
            this.finish();
        }

        return super.onKeyDown(keyCode, event);
    }
}
