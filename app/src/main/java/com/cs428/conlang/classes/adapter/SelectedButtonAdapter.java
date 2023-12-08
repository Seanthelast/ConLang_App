package com.cs428.conlang.classes.adapter;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.cs428.conlang.R;
import com.cs428.conlang.classes.Datacache;


public class SelectedButtonAdapter extends RecyclerView.Adapter<SelectedButtonAdapter.ButtonViewHolder> {
    Datacache instance;
    private EditText text;
    public interface TextUpdateListener {
        void updateText();
    }

    public SelectedButtonAdapter(EditText text) {
        this.text = text;
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
    public ButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
                instance.appendCurrIPAPhonetic(buttonNum);
                instance.appendCurrIPASequence(buttonText);
                instance.appendCurrIPASequence(" ");
                text.setText(instance.getCurrentIPASequence());
            }
        });
    }

    @Override
    public int getItemCount() {
        //return buttonList.size();
        return instance.getSizeTrue();
    }
}