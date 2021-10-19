package com.yaohua.studies.criminalIntent.viewmodel;

import androidx.lifecycle.ViewModel;

import com.yaohua.studies.criminalIntent.moudle.Crime;

import java.util.ArrayList;
import java.util.List;

public class CrimeListViewModel extends ViewModel {
    private final List<Crime> crimes = new ArrayList<>();
    public CrimeListViewModel(){
        for(int i = 0; i<100; ++i){
            Crime crime = new Crime();
            crime.setTitle("Crime"+i);
            crime.setSolved(i%2 == 0);
            crimes.add(crime);
        }
    }
}
