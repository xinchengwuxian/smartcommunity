package smartcommunity.hwpeng.com.smartcommunity.splash.presenter;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

import smartcommunity.hwpeng.com.smartcommunity.splash.view.SplashIView;

/**
 * Created by hwpeng on 2017/9/25.
 */

public class SpalshPresenterImpl implements SplashIPresenter {
    private SplashIView splashIView;

    public SpalshPresenterImpl(SplashIView splashIView) {
        this.splashIView = splashIView;
    }

    @Override
    public void startAnim(ImageView splash) {
        AnimationSet set = new AnimationSet(false);

        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(2500);
        alpha.setFillAfter(true);

        set.addAnimation(alpha);

//        动画监听
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {
                splashIView.jumpNextActivity();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        splash.startAnimation(set);
    }
}
