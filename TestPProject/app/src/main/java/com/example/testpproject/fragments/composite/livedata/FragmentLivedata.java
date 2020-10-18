package com.example.testpproject.fragments.composite.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class FragmentLivedata extends ViewModel {

    private MutableLiveData<String> mutableLiveData;

    private MutableLiveData<Integer> integerMutableLiveData;

    private MutableLiveData<User> userMutableLiveData;

    public MutableLiveData<String> getMutableLiveData() {

        if (mutableLiveData == null) {

            synchronized (FragmentLivedata.this) {

                if (mutableLiveData == null) {

                    mutableLiveData = new MutableLiveData<>();
                }
            }
        }

        return mutableLiveData;
    }

    public MutableLiveData<Integer> getIntegerMutableLiveData() {

        if (integerMutableLiveData == null) {

            synchronized (FragmentLivedata.this) {

                if (integerMutableLiveData == null) {

                    integerMutableLiveData = new MutableLiveData<>();
                }
            }
        }

        return integerMutableLiveData;
    }


    public MutableLiveData<User> getUserMutableLiveData() {

        if (userMutableLiveData == null) {

            synchronized (FragmentLivedata.this) {

                if (userMutableLiveData == null) {

                    userMutableLiveData = new MutableLiveData<>();
                }
            }
        }

        return userMutableLiveData;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
