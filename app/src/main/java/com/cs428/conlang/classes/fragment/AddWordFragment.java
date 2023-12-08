package com.cs428.conlang.classes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.buttonstest.Datacache;
import com.example.buttonstest.R;
import com.example.buttonstest.Word;

public class AddWordFragment extends Fragment{

    private EditText editText1, editText2, editText3, editText4, editText5;
    private Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_word_fragment, container, false);


        // Initialize EditTexts
        editText1 = view.findViewById(R.id.editText1);

        String[] partsOfSpeech = {"verb", "noun", "adjective", "etc", "5"};

        AutoCompleteTextView autoComplete2 = view.findViewById(R.id.editText2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_dropdown_item_1line, partsOfSpeech);
        autoComplete2.setAdapter(adapter);


        //editText2 = view.findViewById(R.id.editText2);


        editText3 = view.findViewById(R.id.editText3);
        editText4 = view.findViewById(R.id.editText4);
        editText5 = view.findViewById(R.id.editText5);

        // Initialize Submit Button
        submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle submit button click event
                // Perform actions when the submit button is clicked

                //testing for ipa phonetics
                Datacache instance = Datacache.getInstance();
                submitButton.setText(instance.getIPAPhoneticsToString());

                Word wordToAdd = new Word(instance.getCurrentIPAPhonetics(),
                        editText1.getText().toString(),
                        editText3.getText().toString(),
                        editText4.getText().toString(),
                        autoComplete2.getText().toString());

                //add word somewheres
                instance.addWord(wordToAdd);
            }
        });

        return view;
    }

    public static AddWordFragment newInstance() {
        AddWordFragment fragment = new AddWordFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}
