package com.cs428.conlang.classes.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buttonstest.Datacache;
import com.example.buttonstest.R;
import com.example.buttonstest.Word;

import java.util.List;

public class DictionaryFragment extends Fragment {

    private RecyclerView recyclerView;
    private WordAdapter wordAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dictionary_fragment, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Datacache instance = Datacache.getInstance();

        // Set up the adapter for the RecyclerView
        wordAdapter = new WordAdapter(instance.getTempWordList(), new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click here, open a new fragment
                Toast.makeText(getActivity(), "Clicked: " + instance.getTempWordList().get(position).getLatinizedSpelling(), Toast.LENGTH_SHORT).show();
                WordInfoFragment wordInfoFragment = new WordInfoFragment();
                // You can pass data to the WordInfoFragment using Bundle if needed
                Bundle bundle = new Bundle();
                bundle.putString("word", instance.getTempWordList().get(position).getLatinizedSpelling());
                wordInfoFragment.setArguments(bundle);

                // Replace the current fragment with WordInfoFragment
                if (getView() != null) {
                    ViewGroup currentFragmentContainer = (ViewGroup) getView().getParent();
                    if (currentFragmentContainer != null) {
                        getFragmentManager().beginTransaction()
                                .replace(currentFragmentContainer.getId(), wordInfoFragment)
                                .addToBackStack(null)
                                .commit();
                    }
                }
            }
        });

        recyclerView.setAdapter(wordAdapter);

        return rootView;
    }

    // Adapter for the RecyclerView
    private static class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
        private Datacache instance;
        private final OnItemClickListener listener;

        WordAdapter(List<Word> wordList, OnItemClickListener listener) {;
            this.listener = listener;
            this.instance = Datacache.getInstance();
        }

        @NonNull
        @Override
        public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent, false);
            return new WordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
            holder.bind(instance.getTempWordList().get(position),listener);
        }

        @Override
        public int getItemCount() {
            return instance.getTempWordList().size();
        }

        static class WordViewHolder extends RecyclerView.ViewHolder {
            TextView textWord;
            WordViewHolder(@NonNull View itemView) {
                super(itemView);
                textWord = itemView.findViewById(R.id.textWord);
            }

            void bind(final Word word, final OnItemClickListener listener) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(getAdapterPosition());
                    }
                });
                // Set the word in the TextView or customize the view here
                // For example: (
                textWord.setText(word.getLatinizedSpelling());
            }
        }
    }

    // Interface for item click listener
    interface OnItemClickListener {
        void onItemClick(int position);
    }
}
