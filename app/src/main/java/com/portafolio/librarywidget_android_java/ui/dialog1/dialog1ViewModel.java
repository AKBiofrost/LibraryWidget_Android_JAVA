package com.portafolio.librarywidget_android_java.ui.dialog1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class dialog1ViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public dialog1ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dialog1ViewModel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}