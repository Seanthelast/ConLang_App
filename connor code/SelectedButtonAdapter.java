package com.example.buttonstest.fragment;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.buttonstest.Datacache;
import com.example.buttonstest.R;

public class SelectedButtonAdapter extends RecyclerView.Adapter<SelectedButtonAdapter.ButtonViewHolder> {
    Datacache instance;

    public SelectedButtonAdapter() {
        instance = Datacache.getInstance();
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {
        public Button button;

        public ButtonViewHolder(View view) {
            super(view);
            button = view.findViewById(R.id.button_mod);
        }
    }

    @Override
    public SelectedButtonAdapter.ButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mod_button, parent, false);
        final ButtonViewHolder viewHolder = new ButtonViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ButtonViewHolder holder, int position) {
        int buttonNum = instance.getKeyByPos(position+1);
        String buttonText = instance.numToString(buttonNum);
        holder.button.setText(buttonText);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(),
                        instance.numToSound(buttonNum));
                mediaPlayer.start();
                //add the syllable
                instance.appendCurrIPASequence(buttonText);
            }
        });
    }

    @Override
    public int getItemCount() {
        //return buttonList.size();
        return instance.getSizeTrue();
    }
}