package smartcommunity.hwpeng.com.smartcommunity.register.presenter;

/**
 * Created by hwpeng on 2017/9/27.
 */

public interface RegisterIPresenter {
    void getIdentifyCode(String phoneNumber);
    void registerUser(String username, String password);
}
