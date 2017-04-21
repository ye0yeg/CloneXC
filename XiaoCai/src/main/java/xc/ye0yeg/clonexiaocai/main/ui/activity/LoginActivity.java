package xc.ye0yeg.clonexiaocai.main.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;

import java.util.HashMap;

import xc.ye0yeg.clonexiaocai.R;
import xc.ye0yeg.clonexiaocai.base.ui.BaseActivity;
import xc.ye0yeg.clonexiaocai.base.util.Utils;

/**
 * Created by Administrator on 4/14/2017.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private AQuery aq;
    private Button btnLogin;
    private Button btnReg;
    private Button btnResetPad;
    private TextView tvUsername;
    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbLoginByXiaoCai;
    private CheckBox cbLoginBySchool;
    private String username;
    private String password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Check 网络连接

        //自动更新组件

        initView();

        autoCompleteLoginInfo();
    }

    private void autoCompleteLoginInfo() {

    }

    private void initView() {
        aq = new AQuery(this);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReg = (Button) findViewById(R.id.btn_register);
        btnResetPad = (Button) findViewById(R.id.btn_reset_psd);

        tvUsername = (TextView) findViewById(R.id.tv_username);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        cbLoginByXiaoCai = (CheckBox) findViewById(R.id.cb_login_by_xiaocai);
        cbLoginBySchool = (CheckBox) findViewById(R.id.cb_login_by_school);

        cbLoginByXiaoCai.setChecked(true);
        cbLoginBySchool.setChecked(false);

        btnLogin.setOnClickListener(this);

        //两个Listener
//        etUsername.addTextChangedListener();
//        etPassword.addTextChangedListener();

        cbLoginByXiaoCai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbLoginByXiaoCai.setChecked(true);
                    cbLoginBySchool.setChecked(false);
                    tvUsername.setText("UserName");
                    etUsername.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    cbLoginByXiaoCai.setChecked(false);
                    cbLoginBySchool.setChecked(true);
                    tvUsername.setText("SchoolNumber");
                    etUsername.setInputType(InputType.TYPE_CLASS_TEXT);
                }

                if (cbLoginByXiaoCai.isChecked() && !cbLoginBySchool.isChecked()) {
                    //登陆方法
                    completeLoginInfo(1);
                }
            }
        });


    }

    private void completeLoginInfo(int loginMethod) {
        HashMap<String, String> map = new HashMap<String, String>();
        if (map == null)
            return;
        //给XiaoCai或者SchoolNumber设置自动的数值

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_reset_psd:
                //到重置界面
                break;

            case R.id.btn_register:
                //注册界面
                break;
            default:
                break;
        }
    }

    private void login() {
        updateLoginBtnText("Loading");
        //判定是否网络访问
//        if(!Utils.isNetworkAvailable(this)){
//            Toast.makeText(this,"网络异常-LOGIN",Toast.LENGTH_SHORT).show();
//            updateLoginBtnText("reload");
//        }else{
            if (cbLoginByXiaoCai.isChecked() && !cbLoginBySchool.isChecked()) {
                loginByXiaoCai();
            } else{
                Toast.makeText(this,"SCHOOL NUMBER LOGIN.",Toast.LENGTH_SHORT).show();
            }
//        }
    }

    private void loginByXiaoCai() {
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        if(!loginCheck(username,password))
            return;

        showProgressDialog();
        SystemClock.sleep(2000);
        goHome();
    }

    //监测登陆
    private boolean loginCheck(String username, String password) {
        boolean isValue = true;
        if(username.equals("")||password.equals("")){
            Toast.makeText(this,"Not Null",Toast.LENGTH_SHORT).show();
            updateLoginBtnText("reload");
        }else{
            isValue = true;
        }
        return isValue;
    }

    private void goHome() {
        Toast.makeText(this, "LOGIN", Toast.LENGTH_SHORT).show();
        //预读购物车

        //到主页l
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

        //关闭自己

    }

    public void updateLoginBtnText(String text) {
        if (null != btnLogin) {
            btnLogin.setText(text);
            if (text.equals("reLoad")) {
                btnLogin.setPressed(false);
            } else {
                btnLogin.setSelected(true);
            }
        } else {
            return;
        }
    }




}
