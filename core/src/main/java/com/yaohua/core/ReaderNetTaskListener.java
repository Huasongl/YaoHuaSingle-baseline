package com.yaohua.core;

import java.io.InputStream;

public interface ReaderNetTaskListener {
    void onConnectionRecieveData(ReaderProtocolTask var1, InputStream var2, long var3);

    void onConnectionError(ReaderProtocolTask var1, Exception var2);
}
