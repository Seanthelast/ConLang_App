package com.cs428.conlang.classes.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buttonstest.GridSpacingItemDecoration;
import com.example.buttonstest.MainActivity;
import com.example.buttonstest.R;
import com.example.buttonstest.adapter.ButtonAdapter;

public class ButtonFragment extends Fragment implements MainActivity.View {
    private RecyclerView recyclerView;
    private ButtonAdapter buttonAdapter;
    private int size;
    private int offset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.button_fragment, container, false);
        TextView textView = view.findViewById(R.id.bottom_button);
        textView.setText("Back To Keyboard");
        TextView textView2 = view.findViewById(R.id.select_section_button);
        textView2.setText("Back to Sections");

        //get args
        Bundle args = getArguments();
        if (args != null) {
            size = args.getInt("size");
            offset = args.getInt("offset");
        }else{
            Log.d("Problem","args");
        }

        recyclerView = view.findViewById(R.id.button_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4)); // Set span count to 4 for 4 columns
        buttonAdapter = new ButtonAdapter(offset,size);
        recyclerView.setAdapter(buttonAdapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.grid_spacing); // Customize the spacing dimension
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spacingInPixels));

        //new button on bottom
        Button bottomButton = view.findViewById(R.id.bottom_button);
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectedButtonFragment frag = new SelectedButtonFragment();

                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                                R.id.fragmentContainerView,
                                frag).commit();
            }
        });
        //new button on bottom
        Button sectionButton = view.findViewById(R.id.select_section_button);
        sectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundSectionFragment frag = new SoundSectionFragment();

                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });

        return view;
    }

    //new instance
    public static ButtonFragment newInstance(int offset, int size) {
        ButtonFragment fragment = new ButtonFragment();
        Bundle args = new Bundle();
        args.putInt("offset", offset);
        args.putInt("size", size);
        fragment.setArguments(args);
        return fragment;
    }
}
