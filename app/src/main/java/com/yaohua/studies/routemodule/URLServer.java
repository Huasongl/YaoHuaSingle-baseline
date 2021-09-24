package com.yaohua.studies.routemodule;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class URLServer {
    protected String mParameter = "";
    private String mServerAction = "";
    private Map<String, String> parameterMap;
    private String mDataQURL = null;
    private WeakReference<Activity> mBindActivity;
//    private WeakReference<URLCallBack> mURLCallBack = null;
    private JumpActivityParameter jp;
    private int requestCode = -1;
    private List<String> mMatchServerActionPool;

    public URLServer(final Activity activity, final String serviceAction, final String parameter){
        this.mParameter = parameter;
        this.mServerAction = serviceAction;
        this.mBindActivity =new WeakReference<Activity>(activity);
//        parameterMap = URlCenter.getQueryStringMap(mParameter);
        mMatchServerActionPool = new ArrayList<>();
        initMatchServerActionPool(mMatchServerActionPool);
    }

    public abstract void initMatchServerActionPool(List<String> mMatchServerActionPool);

    public boolean isMatch(){
        return mMatchServerActionPool.contains(getServerAction());
    }

    public String getServerAction(){
        return mServerAction;
    }

//    public void doExecuteNotMatchURL(){
//        UpgradeTouterService.checkUpgradeManual(mBindActivity.get());
//    }

    public void setRequestCode(int code){
        requestCode = code;
        this.jp.setRequestCode(code);
    }

    public void bindJumpActivityParameter(JumpActivityParameter jumpActivityParameter){
        if(jumpActivityParameter != null){
            this.jp = jumpActivityParameter;
        }
    }

    public JumpActivityParameter getJumpActivityParameter(){
        return this.jp;
    }

    protected Activity getBindActivity(){
        return mBindActivity.get();
    }

    public void setURLCallBack(URLCallBack urlCallBack){

    }
}
