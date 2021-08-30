package com.yaohua.studies.ui.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.TextView;

public interface IAlertDialog extends DialogInterface {
    // oppo 特殊的UI属性
    public static final int DELETE_ALERT_DIALOG_ONE = 1;
    public static final int DELETE_ALERT_DIALOG_TWO = 2;
    public static final int DELETE_ALERT_DIALOG_THREE = 3;
    public static final int DELETE_ALERT_DIALOG_FIVE = 5;

    //背景四个都是圆角，离底部有距离
    public static final int BOTTOM_STYLE_0 = 0;
    //背景顶部两个是圆角，离底部没有距离, 宽是全屏
    public static final int BOTTOM_STYLE_1 = 1;

    boolean isShowing();
    void show();
    void dismiss();
    void cancel();

    void setCancelable(boolean cancelable);
    void setCanceledOnTouchOutside(boolean cancel);
    void setOnCancelListener(OnCancelListener onCancelListener);
    void setOnKeyListener(OnKeyListener listener);

    void setOnDismissListener(OnDismissListener listener);

    void setView(View view);
    void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom);
    void setTitle(CharSequence title);
    void setTitle(int titleId);

    Window getWindow();
    Dialog getBaseDialog();

    void setMessage(CharSequence title);
    void setButton(int whichButton, CharSequence text, Message msg);
    void setButton(int whichButton, CharSequence text, OnClickListener listener);


    TextView getButton(int whichButton);
    View findViewById(int id);

    public static class DialogItemConfig {

        public boolean center;
        public boolean highLight;
        public boolean showLine;

        public DialogItemConfig() {
            center = true;
            highLight = false;
            showLine = true;
        }

        public DialogItemConfig(boolean center, boolean highLight, boolean showLine) {
            this.center = center;
            this.highLight = highLight;
            this.showLine = showLine;
        }
    }

    interface IBuilder {
        IBuilder setTitle(int titleId);
        IBuilder setTitle(CharSequence title);
        IBuilder setCustomTitle(View customTitleView);
        IBuilder setMessage(int messageId);
        IBuilder setMessage(CharSequence message);
        IBuilder setMessage(int messageId, boolean center);
        IBuilder setMessage(CharSequence message, boolean center);
        IBuilder setIcon(int iconId);
        IBuilder setIcon(Drawable icon);
        IBuilder setView(int layoutResId);
        IBuilder setView(View view);
        IBuilder setDeleteDialogOption(int option);
        IBuilder setBottomStyle(int bottomStyle);

        IBuilder setPositiveButton(int textId, OnClickListener listener);
        IBuilder setPositiveButton(CharSequence text, OnClickListener listener);
        IBuilder setNegativeButton(int textId, OnClickListener listener);
        IBuilder setNegativeButton(CharSequence text, OnClickListener listener);
        IBuilder setNeutralButton(int textId, OnClickListener listener);
        IBuilder setNeutralButton(CharSequence text, OnClickListener listener);
        IBuilder setOnCancelListener(OnCancelListener listener);
        IBuilder setAdapter(ListAdapter adapter, OnClickListener listener);
        IBuilder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener);

        IBuilder setItems(CharSequence[] items, OnClickListener listener);

        IBuilder setItems(int itemsId, OnClickListener listener);

        IBuilder setItems(int itemsId, DialogItemConfig config, OnClickListener listener);

        IBuilder setCancelable(boolean cancelable);

        /**
         * oppo near sdk的方法，此方法为了适配华为，华为空实现即可
         * @param gravity
         * @return
         */
        IBuilder setWindowGravity(int gravity);

        IAlertDialog create();
    }
}
