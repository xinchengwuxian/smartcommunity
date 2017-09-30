package smartcommunity.hwpeng.com.smartcommunity.register.presenter;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVMobilePhoneVerifyCallback;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.avos.avoscloud.SignUpCallback;

import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginIView;
import smartcommunity.hwpeng.com.smartcommunity.register.view.RegisterIView;
import smartcommunity.hwpeng.com.smartcommunity.utils.LogUtil;

/**
 * Created by hwpeng on 2017/9/27.
 */

public class RegisterPresenterImpl implements RegisterIPresenter {

    private RegisterIView registerIView;

    public RegisterPresenterImpl(RegisterIView registerIView) {
        this.registerIView = registerIView;
    }


    @Override
    public void getIdentifyCode(final String phoneNumber) {
        AVUser.requestMobilePhoneVerifyInBackground(phoneNumber, new RequestMobileCodeCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    registerIView.getIdentifyCodeSuccess();
                } else {
                    registerIView.getIdentifyCodeFailed();
                    LogUtil.d("phoneNumber", phoneNumber);
                    LogUtil.e("error", e.toString());
                    LogUtil.d("SMS", "Send failed!");
                }
            }
        });
    }

    @Override
    public void registerUser(final String registerUsername, final String password) {

        newUser(registerUsername,password);
//        AVUser.verifyMobilePhoneInBackground(identifyCode, new AVMobilePhoneVerifyCallback() {
//            @Override
//            public void done(AVException e) {
//                if (e == null) {
//                    newUser(phoneNumber,password);
//                } else {
//                    registerIView.toastShow("验证出错");
//                    LogUtil.d("SMS", "Verified failed!");
//                }
//            }
//        });
    }


    public void newUser(String registerUsename, String password){
        AVUser user = new AVUser();
        user.setUsername(registerUsename);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            public void done(AVException e) {
                if (e == null) {
                    registerIView.onRegisterSuccess();
                } else {
                    LogUtil.d("signUp", e.toString());
                    registerIView.onRegisterSuccess();
                }
            }
        });
    }
}
