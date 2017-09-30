package smartcommunity.hwpeng.com.smartcommunity.register.utils;

import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by hwpeng on 2017/9/28.
 */

public class MyCountDownTimer extends CountDownTimer {

    private Button getIdentifyCode;

    public MyCountDownTimer(long millisInFuture, long countDownInterval, Button getIdentifyCode ) {
        super(millisInFuture, countDownInterval);
        this.getIdentifyCode = getIdentifyCode;
    }

    //计时过程
    @Override
    public void onTick(long l) {
        //防止计时过程中重复点击
        getIdentifyCode.setClickable(false);
        getIdentifyCode.setText(l/1000+"s");

    }

    //计时完毕的方法
    @Override
    public void onFinish() {
        //重新给Button设置文字
        getIdentifyCode.setText("重新获取");
        //设置可点击
        getIdentifyCode.setClickable(true);
    }
}
