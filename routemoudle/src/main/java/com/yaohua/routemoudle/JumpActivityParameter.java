package com.yaohua.routemoudle;

import android.os.Parcel;
import android.os.Parcelable;

public class JumpActivityParameter implements Parcelable {

    public static final int FORFESULT_CODE_NONE = -1;

    private int flag = 0x00000000;

    private int requestCode = FORFESULT_CODE_NONE;
    private String qUrl = "";
    private Object objParameter;

    public JumpActivityParameter(){

    }

    protected JumpActivityParameter(Parcel in) {
        readerFromParcel(in);
    }

    private void readerFromParcel(Parcel in) {
        flag = in.readInt();
        requestCode = in.readInt();
        qUrl = in.readString();
    }

    public static final Creator<JumpActivityParameter> CREATOR = new Creator<JumpActivityParameter>() {
        @Override
        public JumpActivityParameter createFromParcel(Parcel in) {
            return new JumpActivityParameter(in);
        }

        @Override
        public JumpActivityParameter[] newArray(int size) {
            return new JumpActivityParameter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(flag);
        dest.writeInt(requestCode);
        dest.writeString(qUrl);
    }

    public JumpActivityParameter setJsonParameter(Object p) {
        objParameter = p;
        return this;
    }

    public JumpActivityParameter setQurl(String url) {
        if (url != null) {
            qUrl = url;
        }
        return this;
    }

    public JumpActivityParameter setRequestCode(int request) {
        requestCode = request;
        return this;
    }

    public JumpActivityParameter setFlag(int f) {
        flag = f;
        return this;
    }

    public Object getJsonParameter() {
        return objParameter;
    }

    public int getFlag() {
        return flag;
    }

    public int getRequestCode() {
        return requestCode;
    }


    public String getQurl() {
        return qUrl;
    }
}
