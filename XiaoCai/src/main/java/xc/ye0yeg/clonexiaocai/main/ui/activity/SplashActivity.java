package xc.ye0yeg.clonexiaocai.main.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;
import xc.ye0yeg.clonexiaocai.R;
import xc.ye0yeg.clonexiaocai.base.config.BmobConfig;
import xc.ye0yeg.clonexiaocai.base.ui.BaseActivity;
import xc.ye0yeg.clonexiaocai.base.util.Utils;
import xc.ye0yeg.clonexiaocai.base.widget.Titanic;
import xc.ye0yeg.clonexiaocai.base.widget.TitanicTextView;

/**
 * Created by Administrator on 4/13/2017.
 */

public class SplashActivity extends BaseActivity{
    private static final int GO_HOME = 100;
    private static final int GO_LOGIN = 200;

    private Titanic titanic;
    private TitanicTextView tvTitanic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkNetwork();
        initBmob();
        setContentView(R.layout.activity_slpash);

        intiView();
    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case GO_HOME:
                    cancelTextAnimation();
                    goHome();
//                    finish();
                    break;
                case GO_LOGIN:
                    cancelTextAnimation();
                    goLogin();
                    finish();
                    break;
                default:
                    cancelTextAnimation();
                    break;
            }
        }
    };

    private void goLogin() {
        Intent login = new Intent(this,LoginActivity.class);
        startActivity(login);
    }

    private void goHome() {
    }

    private void cancelTextAnimation() {
        if(null!=titanic){
            titanic.cancel();
        }
    }

    /*
    * 初始化界面
    * */
    private void intiView() {

        titanic = new Titanic();
        tvTitanic = (TitanicTextView) findViewById(R.id.tv_titanic);
        titanic.start(tvTitanic);

        mHandler.sendEmptyMessageDelayed(GO_LOGIN,2000);
    }

    /*
    * 初始化比目鱼
    * */
    private void initBmob() {
//        Bmob.initialize(this, BmobConfig.BMOB_APP_ID_NEW);

        //BmobPay
        //闭目推送
//        BmobInstallation.getCurrentInstallation().save();

        //
//        BmobPush.startWork(this);

    }

    /*
    * 监测网络异常
    * */
    private void checkNetwork() {
        if(!Utils.isNetworkAvailable(this))
            Toast.makeText(this, "NetWork Fail ",Toast.LENGTH_SHORT).show();
    }
}
