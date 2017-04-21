package xc.ye0yeg.clonexiaocai.main.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.View;

import xc.ye0yeg.clonexiaocai.R;
import xc.ye0yeg.clonexiaocai.base.ui.BaseActivity;

/**
 * Created by Administrator on 4/15/2017.
 */

public class MainActivity extends BaseActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private String mTitle = "titile";
    private String mDrawerTitle = "drawerTitle";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        findView();
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.drawable.ic_app_512,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void findView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_dl);
    }
}
