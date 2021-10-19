package com.yaohua.audiobookmoudle;

public class QQPlayerService {

    private int mPlayErrorCount = 0;

    public void next() {
        clearPlayErrorCount();
        QQPlayerService.this.next(false);
    }

    protected void clearPlayErrorCount() {
        mPlayErrorCount = 0;
    }

    public void next(boolean pre) {
        nextLogic(pre);
    }

    private void nextLogic(boolean pre) {

    }

}
