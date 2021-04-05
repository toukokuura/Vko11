package com.example.vko111.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.vko111.R;
import com.example.vko111.ui.settings.SettingsViewModel;

public class HomeFragment extends Fragment{

    private SettingsViewModel viewModel;
    EditText edittext;
    Boolean editableState = true;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(SettingsViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        textView = root.findViewById(R.id.text_home);
        edittext = root.findViewById(R.id.editText);

        //set the current saved text in textview
        textView.setText(viewModel.getText().getValue());

        viewModel.getEditableState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean s) {
                editableState = s;

                if (editableState==true) {
                    System.out.println("Setting editable");
                    edittext.setEnabled(true);
                    edittext.setFocusable(true);
                    edittext.setClickable(true);
                    edittext.setHint(R.string.kirjoita);
                } else {
                    System.out.println("Setting uneditable");
                    edittext.setEnabled(false);
                    edittext.setFocusable(false);
                    edittext.setClickable(false);
                    edittext.setHint(R.string.eikirjoita);
                }
            }
        });

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //save written text
                viewModel.setText(s.toString());
                System.out.println(s.toString());
            }
        });

        return root;
    }
}