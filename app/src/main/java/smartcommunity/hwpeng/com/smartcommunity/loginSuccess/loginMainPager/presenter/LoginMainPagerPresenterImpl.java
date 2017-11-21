package smartcommunity.hwpeng.com.smartcommunity.loginSuccess.loginMainPager.presenter;


import com.avos.avoscloud.AVUser;

/**
 * Created by hwpeng on 2017/11/20.
 */

public class LoginMainPagerPresenterImpl implements LoginMainPagerIPresenter {
    @Override
    public void logout() {
        AVUser.getCurrentUser().logOut();
    }
}
