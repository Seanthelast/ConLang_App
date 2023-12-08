package com.cs428.conlang.classes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buttonstest.R;

public class WordInfoFragment extends Fragment {

    private TextView textViewTitle1, textViewData1,
            textViewTitle2, textViewData2,
            textViewTitle3, textViewData3,
            textViewTitle4, textViewData4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_info_fragment, container, false);

        // Initialize TextViews
        textViewTitle1 = rootView.findViewById(R.id.word_info_title_1);
        textViewData1 = rootView.findViewById(R.id.word_info_data_1);

        textViewTitle2 = rootView.findViewById(R.id.word_info_title_2);
        textViewData2 = rootView.findViewById(R.id.word_info_data_2);

        textViewTitle3 = rootView.findViewById(R.id.word_info_title_3);
        textViewData3 = rootView.findViewById(R.id.word_info_data_3);

        textViewTitle4 = rootView.findViewById(R.id.word_info_title_4);
        textViewData4 = rootView.findViewById(R.id.word_info_data_4);

        // Set text to TextViews (this is just an example, you'll set appropriate data)
        textViewTitle1.setText("Title 1");
        textViewData1.setText("Data 1");

        textViewTitle2.setText("Title 2");
        textViewData2.setText("Data 2");

        textViewTitle3.setText("Title 3");
        textViewData3.setText("Data 3");

        textViewTitle4.setText("Title 4");
        textViewData4.setText("Data 4");

        return rootView;
    }
}

