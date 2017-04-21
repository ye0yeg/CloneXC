package xc.ye0yeg.clonexiaocai.base.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import xc.ye0yeg.clonexiaocai.R;

/**
 * Created by Administrator on 4/13/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init() {
        if(null ==dialog){
            dialog = new ProgressDialog(this);
            //从外部点击即取消 false
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    public void showProgressDialog(){
        if(dialog != null && dialog.isShowing()){
            dialog.show();
        }
    }

    public void dismissProgressDialog(){
        if(dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    /**
     * 配置Dialog颜色
     * */
    protected void dialogTitleLineColor(Context context, Dialog dialog , int color){
        String dividers[]={
                "android:id/titleDividerTop", "android:id/titleDivider"
        };
        for(int i = 0;i<dividers.length;++i){
            int divierId = context.getResources().getIdentifier(dividers[i],null,null);
            View divider = dialog.findViewById(divierId);
            if(divider != null){
                divider.setBackgroundColor(color);
            }
        }
    }

    //获得绿色的dialog
    protected  void dialogTitleLineColor(Context context,Dialog dialog){
        if(dialog!= null){
            dialogTitleLineColor(context ,dialog ,context.getResources().getColor(R.color.green));
        }
    }

    //获得默认的颜色
    protected final void dialogTitleLineColor(Dialog dialog){dialogTitleLineColor(this,dialog);}
}
