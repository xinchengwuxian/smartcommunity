package smartcommunity.hwpeng.com.smartcommunity.login.presenter;


import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

import smartcommunity.hwpeng.com.smartcommunity.login.view.LoginIView;

/**
 * Created by hwpeng on 2017/9/27.
 */

public class LoginPresenterImpl implements LoginIPresenter {

    private LoginIView loginIView;

    public LoginPresenterImpl (LoginIView loginIView) {
        this.loginIView = loginIView;
    }


    @Override
    public void init() {

    }

    @Override
    public void login(String username, String password) {
        AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (e == null) {
                    loginIView.onLoginSuccess();
                } else {
                    loginIView.onLoginFailed();
                }
            }
        });
    }
}
