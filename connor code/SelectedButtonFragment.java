package com.example.buttonstest.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buttonstest.Datacache;
import com.example.buttonstest.GridSpacingItemDecoration;
import com.example.buttonstest.MainActivity;
import com.example.buttonstest.R;


public class SelectedButtonFragment extends Fragment implements MainActivity.View {
    //temporarily store data here, will eventually grab from a database
    private RecyclerView recyclerView;
    private SelectedButtonAdapter selectedButtonAdapter;
    private Datacache instance;

    public EditText bottomTextbox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sound_selector_fragment, container, false);
        TextView textView = view.findViewById(R.id.ss_button_title);
        textView.setText("Keyboard");

        instance = Datacache.getInstance();

        recyclerView = view.findViewById(R.id.ss_button_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4)); // Set span count to 4 for 4 columns
        selectedButtonAdapter = new SelectedButtonAdapter();
        recyclerView.setAdapter(selectedButtonAdapter);

        //edittext on the bottom
        EditText text = view.findViewById(R.id.ss_word_textbox);
        text.setText(instance.getCurrentIPASequence());

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_spacing); // Customize the spacing dimension
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spacingInPixels));

        //need button on bottom
        Button bottomButton = view.findViewById(R.id.ss_bottom_button);
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cute game over noise can go, vestige from testing
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.gameover);
                mediaPlayer.start();

                ButtonFragment frag = ButtonFragment.newInstance(0,20);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });

        return view;
    }
}
