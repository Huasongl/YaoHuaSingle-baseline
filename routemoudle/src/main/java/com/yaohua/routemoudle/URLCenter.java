package com.yaohua.routemoudle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.yaohua.commonmodule.FlavorConfig;
import com.yaohua.commonmodule.ServerUrl;

import java.util.HashMap;

public class URLCenter {

    /********************** scheme start ************************/
    //以下将外部跳转逻辑全部合入到SplashActivity里面，保证应用入口的单一。避免多次逻辑修改
    public static final String WXSCHEME0 = FlavorConfig.mDomain.WXSCHEME0;
    public static final String WXSCHEME1 = FlavorConfig.mDomain.WXSCHEME1;
    /**
     * WXSCHEME50 为5.0版本功能调起
     */
    public static final String WXSCHEME50 = "androidqqreader50";
    public static final String QULSCHEME = FlavorConfig.mDomain.QULSCHEME;
    public static final String OtherQULSCHEME = FlavorConfig.mDomain.OtherQULSCHEME;
    public static final String ROUTER_SCHEME = "routerqqreader";

    //sheme集合
    public static final String[] SUPPORT_SCHEME_LIST = {
            WXSCHEME0, WXSCHEME1, WXSCHEME50, QULSCHEME, OtherQULSCHEME, ROUTER_SCHEME
    };


    /********************** scheme end ************************/
    public static final String QULSUB = QULSCHEME + "://";
    public static final String HTTPSCHEME = "http://";
    public static final String HTTPSCHEMES = "https://";
    public static final String HOST_WEB_ALL = QULSUB + "webpage/";
    public static final String UCVIPCHEMES = "ucvip://";
    // 华为支持两种qurl 其他分支 OtherQULSCHEME与QULSCHEME一致

    public static final String OtherQULSUB = OtherQULSCHEME + "://";
    private static final String SERVER_URL_DOMAIN = ServerUrl.PROTOCOL_SERVER_URL;
    private static final String HOST_NATIVE = "nativepage";
    private static final String HOST_WEB = "webpage";
    private static final String TAG = "URLCenter";

    public static void executeURL(final Activity fromActivity, final String qUrl, final JumpActivityParameter jp) {
        executeURL(fromActivity, qUrl, null, jp);
    }

    public static void executeURL(Activity fromActivity, String qUrl) {
        executeURL(fromActivity, qUrl, null, null);
    }

    /**
     * 同步方法，提供了URLCallBack用以业务需求的细分，默认传null
     *
     * @param qUrl
     * @param callBack
     */
    public static void executeURL(final Activity fromActivity, final String qUrl
            , final URLCallBack callBack, final JumpActivityParameter jp) {
        executeURL(fromActivity, qUrl, null, callBack, jp);
    }

    /**
     * 同步方法，提供了URLCallBack用以业务需求的细分，默认传null
     *
     * @param qUrl
     * @param callBack
     * @param fromTitle 来源页面名称，返回按钮添加文字
     *
     */
    public static void executeURL(final Activity fromActivity, final String qUrl
            , String fromTitle, final URLCallBack callBack, final JumpActivityParameter jp) {

        if (qUrl == null || qUrl.length() == 0 || fromActivity == null) {
            return;
        }

        if (isFastClick()) {
            return;
        }

//        try {
//            String serverName = null;
//            String serverAction = null;
//            //h5 或者到详情页
//            if (qUrl.startsWith(QULSUB) || qUrl.startsWith(OtherQULSUB)) {
//                if ((!TextUtils.isEmpty(qUrl) && qUrl.contains(DataReportUtils.APPNOTIFY)) || DataReportUtils
//                        .isGapPush(qUrl)) {
//                    HashMap<String, String> map = parseParamsFromUrl(qurl);
//                    reportUrl(map, fromActivity);
//                }
//                String subURL = null;
//                if (qurl.startsWith(QULSUB)) {
//                    subURL = qurl.substring(QULSUB.length());
//                } else if (qurl.startsWith(OtherQULSUB)) {
//                    subURL = qurl.substring(OtherQULSUB.length());
//                }
//                String[] splitsubURL = subURL.split("\\?");
//                //逻辑url部分
//                String logicOfUrl = splitsubURL[0];
//                //参数部分
//                String parameterOfUrl = null;
//                if (splitsubURL.length > 1) {
//                    parameterOfUrl = subURL.substring(logicOfUrl.length() + 1);
//                }
//                String[] splitStr = logicOfUrl.split("/");
//                if (splitStr != null && splitStr.length > 0) {
//                    URLServer urlServer = null;
//                    String dataQurl = null;
//                    String fixHttpScheme = HTTPSCHEME;
//                    if (HOST_WEB.equals(splitStr[0])) {
//                        boolean isFullUrl = subURL.contains(HTTPSCHEMES);
//                        if (isFullUrl) {
//                            fixHttpScheme = HTTPSCHEMES;
//                        } else {
//                            isFullUrl = subURL.contains(HTTPSCHEME);
//                        }
//                        // web
//                        if (isFullUrl) {
//                            String[] httpSplit = subURL.split(fixHttpScheme);
//                            String[] urlSreverSplit = httpSplit[0].split("/");
//                            serverName = urlSreverSplit[0];
//                            if (urlSreverSplit.length > 1) {
//                                serverAction = urlSreverSplit[1];
//                            }
//                            urlServer = buildURLServer(fromActivity, serverName, serverAction, parameterOfUrl);
//                            dataQurl = fixHttpScheme + httpSplit[1];
//                        } else {
//                            urlServer = buildURLServer(fromActivity, HOST_WEB, null, null);
//                            dataQurl = subURL.substring(HOST_WEB.length() + 1);
//                        }
//                    } else if (HOST_NATIVE.equals(splitStr[0])) {
//                        //native
//                        if (splitStr.length > 1) {
//                            serverName = splitStr[1];
//                        }
//                        if (splitStr.length > 2) {
//                            serverAction = splitStr[2];
//                        }
//                        urlServer = buildURLServer(fromActivity, serverName, serverAction, parameterOfUrl);
//                        if (subURL.contains("&statInfo")) {
//                            dataQurl = ServerUrl.PROTOCOL_SERVER_URL + subURL.substring(0, subURL.indexOf("&statInfo"));
//                        } else {
//                            dataQurl = ServerUrl.PROTOCOL_SERVER_URL + subURL;
//                        }
//                    }
//                    if (urlServer != null) {
//                        try {
//                            urlServer.setDataQURL(dataQurl);
//                            urlServer.bindJumpActivityParameter(jp);
//                            urlServer.setURLCallBack(callBack);
//
//                            /**
//                             * 检测ServerAction是否支持业务
//                             */
//                            if (!urlServer.isMatch()) {
//                                urlServer.doExcuteNotMatchURL();
//                                return;
//                            }
//
//                            if (!urlServer.parserURL()) {
//                                urlServer.doExcuteNotMatchURL();
//                            }
//                        } catch (Exception e) {
//                            Log.printErrStackTrace("URLCenter", e, null, null);
//                            Log.e("URLCenter", e.getMessage());
//                            String logStr = "[URL :" + subURL + "] : " + e.toString();
//                        }
//                    } else {
//                        /**
//                         * urlServer 没有匹配上
//                         */
//                        doExcuteNotMatchURL(fromActivity, jp);
//                    }
//                }
//            } else if (qurl.startsWith(HTTPSCHEME) || qurl.startsWith(HTTPSCHEMES)) {
//                if (!TextUtils.isEmpty(qurl)) {
//                    if (qurl.contains(DataReportUtils.APPNOTIFY)) {
//                        HashMap<String, String> map = parseParamsFromUrl(qurl);
//                        reportUrl(map, fromActivity);
//                    } else if (qurl.contains("noah") || qurl.contains("nativepage")) { //noah活动url
//                        doSaveActivityInfoId(qurl);
//                    }
//                }
//                ARouter.getInstance().build(RoutePath.WEB_BROWER)
//                        .withString(RouteConstant.WEBCONTENT, qurl)
//                        .withFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                        .withString(RouteConstant.FROM_TITLE, fromTitle)
//                        .navigation(fromActivity, ActivityCodeConstant.FORRESULT_DEFAULT_CODE);
//            } else if (qurl.startsWith(UCVIPCHEMES)) {
//                JumpActivityUtil.goUCVIPLink(fromActivity, qurl);
//            } else if (qurl.startsWith(ROUTER_SCHEME)) {
//                RouterCompat.pathHandler(fromActivity, qurl, jp);
//            } else {
//                try {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(qurl));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    fromActivity.startActivity(intent);
//                } catch (Exception e) {
//                    Log.printErrStackTrace("URLCenter", e, null, null);
//                    Log.e("URLCenter", "Scheme 跳转异常, url: " + qurl);
//                }
//            }
//        } catch (Exception e) {
//            Log.printErrStackTrace("URLCenter", e, null, null);
//            Log.e("URLCenter", "excuteURL :  qurl = " + qUrl + " \n" + e.toString());
//        }
    }

    private static long lastClickTime = 0;
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        long delta = time - lastClickTime;
        if (delta > 0 && delta < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
