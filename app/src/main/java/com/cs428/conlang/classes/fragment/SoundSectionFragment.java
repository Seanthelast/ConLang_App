package com.cs428.conlang.classes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


//this class has the divisions of sounds for the sound selector.  All are added to the
public class SoundSectionFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sound_section_fragment, container, false);

        Button button1 = view.findViewById(R.id.section_1);
        Button button2 = view.findViewById(R.id.section_2);
        Button button3 = view.findViewById(R.id.section_3);
        Button button4 = view.findViewById(R.id.section_4);
        Button button5 = view.findViewById(R.id.section_5);
        Button button6 = view.findViewById(R.id.section_6);
        Button button7 = view.findViewById(R.id.section_7);

        // Setting OnClickListener for each button and name
        button1.setText("Labial");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(0,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });
        button2.setText("Coronal");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(8,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });
        button3.setText("Dorsal");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(16,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });
        button4.setText("Laryngeal");
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(24,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });
        button5.setText("Co-Arti");
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(32,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });
        button6.setText("non-pulm");
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(40,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });
        button7.setText("vowels");
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonFragment frag = ButtonFragment.newInstance(48,8);
                FragmentManager fm = requireActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(
                        R.id.fragmentContainerView,
                        frag).commit();
            }
        });

        return view;
    }
}
