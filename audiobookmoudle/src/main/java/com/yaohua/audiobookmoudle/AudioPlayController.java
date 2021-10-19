package com.yaohua.audiobookmoudle;

import android.os.RemoteException;
import android.util.Log;

public class AudioPlayController {

    private static volatile AudioPlayController sInstance;

    public static AudioPlayController getInstance() {
        if (sInstance == null) {
            synchronized (AudioPlayController.class) {
                if (sInstance == null) {
                    sInstance = new AudioPlayController();
                }
            }
        }
        return sInstance;
    }

    public void nextChapter() {
        if (hasInitialized()) {
            AudioServiceHelper.getService().next();
        }
    }

    public boolean hasInitialized() {
        if (AudioServiceHelper.getService() == null) {
            return false;
        }
        return true;
    }

}
