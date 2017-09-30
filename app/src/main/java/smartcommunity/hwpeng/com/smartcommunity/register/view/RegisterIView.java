package smartcommunity.hwpeng.com.smartcommunity.register.view;

/**
 * Created by hwpeng on 2017/9/27.
 */

public interface RegisterIView {
    void onRegisterSuccess();
    void onRegisterFailed();
    void getIdentifyCodeSuccess();
    void getIdentifyCodeFailed();
    void toastShow(String message);
}
