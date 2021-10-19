package com.yaohua.studies.criminalIntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Path;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yaohua.routemoudle.RoutePath;
import com.yaohua.studies.R;
import com.yaohua.studies.criminalIntent.uifragment.CrimeFragment;
import com.yaohua.studies.criminalIntent.uifragment.CrimeListFragment;

@Route(path = RoutePath.CRIMINAL_ACTIVITY)
public class CriminalIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminal_intent);

        Fragment fg = getSupportFragmentManager().findFragmentById(R.id.criminal_fragment_container);
        if(fg == null){
            fg = CrimeListFragment.getInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.criminal_fragment_container,fg,CrimeListFragment.class.getSimpleName())
                    .commit();
        }
    }
}