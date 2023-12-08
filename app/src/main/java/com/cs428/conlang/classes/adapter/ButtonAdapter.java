package com.cs428.conlang.classes.adapter;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.cs428.conlang.R;
import com.cs428.conlang.classes.Datacache;


public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {
    Datacache instance;

    private int offset;
    private int size;
    public ButtonAdapter(int offset, int size) {
        instance = Datacache.getInstance();
        this.offset = offset;
        this.size = size;
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
        int buttonNum = instance.getKey(position + offset);
        String buttonText = instance.numToString(buttonNum);
        //set the button color and name
        holder.button.setText(buttonText);
        if (instance.getData(buttonNum)) {
            holder.button.setBackgroundColor(Color.BLUE); // Change to your desired color
        } else {
            holder.button.setBackgroundColor(Color.LTGRAY); // Change to your default color
        }

        //onclick listener
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //play sound if unchecked
                if(!instance.getData(buttonNum)){
                    MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(), instance.numToSound(buttonNum));
                    mediaPlayer.start();
                }
                //find out the number amd change button:
                instance.switchData(buttonNum);
                if(instance.getData(buttonNum)){
                    holder.button.setBackgroundColor(Color.BLUE); // Change to your desired color
                } else {
                    holder.button.setBackgroundColor(Color.LTGRAY); // Change to your default color
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }
}