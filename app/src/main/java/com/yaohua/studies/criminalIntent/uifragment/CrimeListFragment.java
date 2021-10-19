package com.yaohua.studies.criminalIntent.uifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yaohua.studies.R;
import com.yaohua.studies.criminalIntent.Adapter;
import com.yaohua.studies.criminalIntent.moudle.BaseItemBean;
import com.yaohua.studies.criminalIntent.viewmodel.CrimeListViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CrimeListFragment extends Fragment {

    private CrimeListViewModel cv;
    private RecyclerView rv;
    private View rootView;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cv=ViewModelProviders.of(this)
                .get(CrimeListViewModel.class);
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_crimes_list,container,false);
        rv = rootView.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));

        List<BaseItemBean> beans = new ArrayList<>();
        for(int i = 0; i<10; ++i){
            long terminalTime = System.currentTimeMillis() + i*10000;
            beans.add(new BaseItemBean((long) i,terminalTime,(i%2)+1));
        }
        Adapter adapter = new Adapter(beans);
        rv.setAdapter(adapter);
        adapter.setOnItemDeleteClick(position -> {
            beans.remove(beans.get(position));
            adapter.notifyItemRemoved(position);
            return null;
        });
        return rootView;
    }

    public static CrimeListFragment getInstance(){
        return new CrimeListFragment();
    }


}
