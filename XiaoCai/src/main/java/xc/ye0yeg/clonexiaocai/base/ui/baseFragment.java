package xc.ye0yeg.clonexiaocai.base.ui;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 4/21/2017.
 */

public abstract class BaseFragment extends Fragment {
    //rootView是否已经创建
    private boolean mIsRootViewCreated = false;

    private View mRootView;

    protected FragmentActivity fragmentActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(provideLayoutResId(), container, false);
        mIsRootViewCreated = true;
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentActivity = getActivity();

        initView(mRootView);
        initListener();
        initBroadcast();
        initData(mRootView, savedInstanceState);
    }

    protected View getRootView() {
        return mRootView;
    }
    protected abstract void initData(View mRootView, Bundle savedInstanceState);

    protected abstract void initListener();

    protected abstract void initView(View mRootView);

    protected abstract int provideLayoutResId();

    private BroadcastReceiver mPrReceiver;

    protected void initBroadcast() {
        String[] actions = provideBroadcastActions();
        if (null == actions || actions.length == 0) {
            return;
        }
        registerLocalBroadcastReceiver(mPrReceiver, actions);

    }

    protected String[] provideBroadcastActions() {
        return null;
    }

    //TODO
    protected void registerLocalBroadcastReceiver(BroadcastReceiver receiver, String... action) {
        //LocalBroadcasts.registerLocalReceiver(receiver, actions);
        //本地广播的封装      "LocalBroadcasts"
    }

    protected void unregisterLocalReceiver(BroadcastReceiver receiver) {
        //LocalBroadcasts.unregisterLocalReceiver(receiver);
        //本地广播的封装
    }


}
