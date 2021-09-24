package com.yaohua.studies.activity;

import android.app.Activity;
import android.os.Bundle;

public interface IEventListener {
    void doFunction(Bundle b);

    Activity getFromActivity();
}
