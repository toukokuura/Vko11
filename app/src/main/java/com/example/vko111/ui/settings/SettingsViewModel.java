package com.example.vko111.ui.settings;

import android.widget.CheckBox;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Boolean> mEditable;

    public SettingsViewModel() {
        mEditable = new MutableLiveData<>();
        mEditable.setValue(Boolean.TRUE);

        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() { return mText; }

    public void setText(String txt) {
        mText.setValue(txt);
    }

    public LiveData<Boolean> getEditableState() { return mEditable; }

    public void selection(Boolean editable) {
        mEditable.setValue(editable);
    }
}