package com.example.vko111.ui.settings;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.vko111.R;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settingsViewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        //final TextView textView = root.findViewById(R.id.settings_title);
        CheckBox editable = root.findViewById(R.id.checkBox);

        settingsViewModel.getEditableState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean s) {
                if (s==true) {
                    editable.setChecked(false);
                } else {
                    editable.setChecked(true);
                }
            }
        });

        editable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if (editable.isChecked()) {
                    // change edittext to not editable
                    settingsViewModel.selection(false);
                    System.out.println("Setting is now uneditable");
                } else {
                    settingsViewModel.selection(true);
                    System.out.println("Setting is now editable");
                }
            }
        });

        /*
        settingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */

        return root;
    }
}