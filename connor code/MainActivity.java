package com.example.buttonstest;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.buttonstest.fragment.ButtonFragment;
import com.example.buttonstest.fragment.SoundSectionFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //start buttonFragment
        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainerView, new ButtonFragment())
                    .commit();
        }*/
        //start SoundSectionFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new SoundSectionFragment())
                    .commit();
        }
    }
    public interface View {
    }
}
