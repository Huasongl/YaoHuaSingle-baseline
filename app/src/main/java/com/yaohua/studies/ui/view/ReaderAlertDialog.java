package com.yaohua.studies.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.yaohua.studies.R;

public class ReaderAlertDialog implements IAlertDialog {

    private AlertDialog mDialog;
    private int mBottomStyle = IAlertDialog.BOTTOM_STYLE_0;

    private ReaderAlertDialog(AlertDialog alertDialog, int style){
        mBottomStyle = style;
        mDialog = alertDialog;
    }

    @Override
    public boolean isShowing() {
        if (mDialog != null) {
            return mDialog.isShowing();
        } else {
            throw new RuntimeException("Dialog no create !!! ");
        }
    }

    @Override
    public void show() {
        if(mDialog != null){
            mDialog.show();
            if(mBottomStyle == IAlertDialog.BOTTOM_STYLE_1){
                mDialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            }
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void dismiss() {
        if(null != mDialog){
            mDialog.dismiss();
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void cancel() {
        if(null != mDialog){
            mDialog.cancel();
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setCancelable(boolean cancelable) {
        if(null != mDialog){
            mDialog.setCancelable(cancelable);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {
        if(null != mDialog){
            mDialog.setCanceledOnTouchOutside(cancel);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setOnCancelListener(OnCancelListener onCancelListener) {
        if(mDialog != null){
            mDialog.setOnCancelListener(onCancelListener);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setOnKeyListener(OnKeyListener listener) {
        if(mDialog != null){
            mDialog.setOnKeyListener(listener);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setOnDismissListener(OnDismissListener listener) {
        if(mDialog != null){
            mDialog.setOnDismissListener(listener);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setView(View view) {
        if(mDialog != null){
            mDialog.setView(view);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
        if(mDialog != null){
            mDialog.setView(view);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        if(null != mDialog){
            mDialog.setTitle(getCenterString(title));
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setTitle(int titleId) {
        if(null != mDialog){
            mDialog.setTitle(getCenterString(mDialog.getContext().getString(titleId)));
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public Window getWindow() {
        if(mDialog != null){
            return mDialog.getWindow();
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public Dialog getBaseDialog() {
        if(mDialog != null){
            return mDialog;
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setMessage(CharSequence title) {
        if(mDialog != null){
            mDialog.setMessage(title);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setButton(int whichButton, CharSequence text, Message msg) {
        if(mDialog != null){
            mDialog.setButton(whichButton,text,msg);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        if(mDialog != null){
            mDialog.setButton(whichButton,text,listener);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public TextView getButton(int whichButton) {
        if(mDialog != null){
            return mDialog.getButton(whichButton);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    @Override
    public View findViewById(int id) {
        if(mDialog != null){
            return mDialog.findViewById(id);
        }else{
            throw new RuntimeException("Dialog is not create!");
        }
    }

    public static class Builder implements IBuilder{

        private int mWindowGravity;
        private Context mContext;
        private AlertDialog.Builder mBuilder;
        private int mBottomStyle;

        public Builder(Context context){
            mBuilder = new AlertDialog.Builder(context,R.style.VivoTheme_Dialog);
            mContext = context;
        }

        @Override
        public IBuilder setTitle(int titleId) {
            String title = mContext.getString(titleId);
            mBuilder.setTitle(getCenterString(title));
            return this;
        }

        @Override
        public IBuilder setTitle(CharSequence title) {
            mBuilder.setTitle(getCenterString(title));
            return this;
        }

        @Override
        public IBuilder setCustomTitle(View customTitleView) {
            mBuilder.setCustomTitle(customTitleView);
            return this;
        }

        @Override
        public IBuilder setMessage(int messageId) {
            mBuilder.setMessage(mContext.getString(messageId));
            return this;
        }

        @Override
        public IBuilder setMessage(CharSequence message) {
            mBuilder.setMessage(message);
            return this;
        }

        @Override
        public IBuilder setMessage(int messageId, boolean center) {
            return setMessage(mContext.getString(messageId),center);
        }

        @Override
        public IBuilder setMessage(CharSequence message, boolean center) {
            mBuilder.setMessage(center ? getCenterString(message):message);
            return this;
        }

        @Override
        public IBuilder setIcon(int iconId) {
            mBuilder.setIcon(iconId);
            return this;
        }

        @Override
        public IBuilder setIcon(Drawable icon) {
            mBuilder.setIcon(icon);
            return this;
        }

        @Override
        public IBuilder setView(int layoutResId) {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                mBuilder.setView(layoutResId);
            }
            return this;
        }

        @Override
        public IBuilder setView(View view) {
            mBuilder.setView(view);
            return this;
        }

        @Override
        public IBuilder setDeleteDialogOption(int option) {
            return this;
        }

        @Override
        public IBuilder setBottomStyle(int bottomStyle) {
            mBottomStyle = bottomStyle;
            return this;
        }

        @Override
        public IBuilder setPositiveButton(int textId, OnClickListener listener) {
            mBuilder.setPositiveButton(textId, listener);
            return this;
        }

        @Override
        public IBuilder setPositiveButton(CharSequence text, OnClickListener listener) {
            mBuilder.setPositiveButton(text, listener);
            return this;
        }

        @Override
        public IBuilder setNegativeButton(int textId, OnClickListener listener) {
            mBuilder.setNegativeButton(textId, listener);
            return this;
        }

        @Override
        public IBuilder setNegativeButton(CharSequence text, OnClickListener listener) {
            mBuilder.setNegativeButton(text, listener);
            return this;
        }

        @Override
        public IBuilder setNeutralButton(int textId, OnClickListener listener) {
            mBuilder.setNeutralButton(textId, listener);
            return this;
        }

        @Override
        public IBuilder setNeutralButton(CharSequence text, OnClickListener listener) {
            mBuilder.setNeutralButton(text, listener);
            return this;
        }

        @Override
        public IBuilder setOnCancelListener(OnCancelListener listener) {
            mBuilder.setOnCancelListener(listener);
            return this;
        }

        @Override
        public IBuilder setAdapter(ListAdapter adapter, OnClickListener listener) {
            mBuilder.setAdapter(adapter, listener);
            return this;
        }

        @Override
        public IBuilder setSingleChoiceItems(CharSequence[] items, int checkedItem, OnClickListener listener) {
            mBuilder.setSingleChoiceItems(items, checkedItem, listener);
            return this;
        }

        @Override
        public IBuilder setItems(CharSequence[] items, OnClickListener listener) {
            return setItems(items,new DialogItemConfig(),listener);
        }

        @Override
        public IBuilder setItems(int itemsId, OnClickListener listener) {
            return setItems(itemsId,new DialogItemConfig(),listener);
        }

        @Override
        public IBuilder setItems(int itemsId, DialogItemConfig config, OnClickListener listener) {
            CharSequence[] items = mContext.getResources().getTextArray(itemsId);
            return setItems(items,config,listener);
        }

        private Builder setItems(CharSequence[] items, DialogItemConfig config, OnClickListener listener){
            int length = items.length;
            CharSequence[] newItems = new CharSequence[length];
            for(int i = 0; i < length; ++i){
                CharSequence item = items[i];
                SpannableString spannableString = new SpannableString(item);
                if(config.center){
                    spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, item.length(), 0);
                }
                if(config.highLight){
                    spannableString.setSpan(new ForegroundColorSpan(mContext.getResources().getColor(R.color.new_oppo_color_c301)),0,item.length(),0);
                }
                if(config.showLine){

                }
                newItems[i] = spannableString;
            }
            mBuilder.setItems(newItems, listener);
            return this;
        }

        @Override
        public IBuilder setCancelable(boolean cancelable) {
            mBuilder.setCancelable(cancelable);
            return this;
        }

        @Override
        public IBuilder setWindowGravity(int gravity) {
            mWindowGravity = gravity;
//            mBuilder.setWindowGravity(position);
            return this;
        }

        @Override
        public IAlertDialog create() {
            AlertDialog dialog = mBuilder.create();
            Window window = dialog.getWindow();
            window.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.dimAmount = 0.4f;
            layoutParams.y = mBottomStyle == IAlertDialog.BOTTOM_STYLE_1 ? 0: (int) TypedValue.applyDimension(1, 58, mContext.getResources().getDisplayMetrics());;
            layoutParams.width = mBottomStyle == IAlertDialog.BOTTOM_STYLE_1 ? WindowManager.LayoutParams.MATCH_PARENT: WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(layoutParams);
            window.setBackgroundDrawableResource(mBottomStyle == IAlertDialog.BOTTOM_STYLE_1 ? R.drawable.vivo_alert_half_dialog_bg
                    :R.drawable.vivo_alert_dialog_bg);
            return new ReaderAlertDialog(dialog, mBottomStyle);
        }
    }

    private static SpannableString getCenterString(CharSequence item){
        SpannableString spannableString = new SpannableString(item);
        spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),0,item.length(),0);
        return spannableString;
    }
}
