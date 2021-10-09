package com.yaohua.studies;

import android.content.res.AssetManager;

import com.yaohua.commonmodule.AppConfig;
import com.yaohua.commonmodule.DomainInitializer;
import com.yaohua.commonmodule.ServerUrl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DomainInitializerImpl extends DomainInitializer {

    private static JSONObject mDomainJson = null;

    public static JSONObject getDomainJson() {
        if (mDomainJson == null) {
            mDomainJson = getJson();
        }
        return mDomainJson;
    }

    public void init() {
        QULSCHEME = "uniteqqreader";
        OtherQULSCHEME = "uniteoppobook";
        WXSCHEME0 = "AndroidQQReader";
        WXSCHEME1 = "androidqqreader";
        DOMAINNAME_ANDROID_READER = "https://coopmain.reader.qq.com/";

        ServerUrl.PROTOCOL_SERVER_URL = DOMAINNAME_ANDROID_READER + "v" + AppConfig.URL_VERSION2 + "/";
    }

    private static JSONObject getJson() {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        JSONObject jsonObject = null;
        try {
            //获取assets资源管理器
            AssetManager assetManager = AbsApplication.getInstance().getBaseContext().getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open("domain.json")));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            jsonObject = new JSONObject(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            jsonObject = new JSONObject();
        } catch (JSONException e) {
            e.printStackTrace();
            jsonObject = new JSONObject();
        } catch (Throwable e) {
            jsonObject = new JSONObject();
        } finally {
            return jsonObject;
        }
    }
}
