package com.yaohua.studies.designmethod.srp;

import android.graphics.Bitmap;

public interface ImageCache {
    void put(String url,Bitmap bitmap);
    Bitmap get(String url);
}
