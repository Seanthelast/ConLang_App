package com.cs428.conlang;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.buttonstest.fragment.DictionaryFragment;
import com.example.buttonstest.fragment.GrammarFragment;
import com.example.buttonstest.fragment.SelectedButtonFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //set up nav menu
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        //start buttonFragment
        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerView, new ButtonFragment())
                    .commit();
        }*/
        //start SoundSectionFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new DictionaryFragment())
                    .commit();
        }
    }
    public interface View {
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;
                int itemID = item.getItemId();
                if (itemID == R.id.navigation_dictionary) {
                    selectedFragment = new DictionaryFragment();
                } else if (itemID == R.id.navigation_buttons) {
                    selectedFragment = new SelectedButtonFragment();
                } else if (itemID == R.id.navigation_grammar) {
                    selectedFragment = new GrammarFragment();
                } else {
                    // Handle default case
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView, selectedFragment)
                            .addToBackStack(null) // Add to back stack if needed
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();
                }

                return true;
            };
}
