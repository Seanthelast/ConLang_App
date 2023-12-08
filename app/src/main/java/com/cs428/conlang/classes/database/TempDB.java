package com.cs428.conlang.classes.database;

import com.example.buttonstest.Word;

import java.util.HashMap;
import java.util.Map;

public class TempDB {

    private static TempDB instance = null;
    Map<String, Word> words;

    private TempDB() {
        words = new HashMap<String, Word>();
    }

    public static synchronized TempDB getInstance() {
        if (instance == null) {
            instance = new TempDB();

            /*
            * remove this part if this is still here when we get a functioning app, as it's
            * just for testing
            */
            List<Integer> phonetics = new ArrayList<Integer>();
            phonetics.add(1);
            Word word1 = new Word(phonetics, "test", "A test of the database",
                    "this is just a database test", "N");
            Word word2 = new Word(phonetics, "test", "A test of the database",
                    "this is just a database test", "N");
            instance.insert(word1);
            instance.insert(word2);
        }
        return instance;
    }

    // Adds a word to the DB
    public void insert(Word word) {
        words.put(word.getLatinizedSpelling(), word);
    }

    // Gets a word from the DB
    public Word find(String latinizedSpelling) {
        return words.get(latinizedSpelling);
    }

    // Removes a word from the DB
    public void remove(String latinizedSpelling) {
        words.remove(latinizedSpelling);
    }
}
