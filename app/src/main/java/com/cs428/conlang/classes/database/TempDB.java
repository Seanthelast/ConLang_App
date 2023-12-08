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
            List<Phonetics> phonetics = new ArrayList<Phonetics>();
            phonetics.add(new Phonetics());
            List<Rule> rules = new ArrayList<Rule>();
            GlobalRule gRule1 = new GlobalRule("Rule tested", true, new Parser());
            GlobalRule gRule2 = new GlobalRule("Rule testing", true, new Parser());
            rules.add(new Rule("Test Pattern 1"), gRule1);
            Word word1 = new Word(phonetics, "test", "A test of the database",
                    "this is just a database test", "N", rules);
            rules.add(new Rule("Test Pattern 2"), gRule2);
            Word word2 = new Word(phonetics, "test", "A test of the database",
                    "this is just a database test", "N", rules);
            instance.insert(word1);
            instance.insert(word2);
        }
        return instance;
    }

    public void insert(Word word) {
        words.put(word.getLatinizedSpelling(), word);
    }

    public Word find(String latinizedSpelling) {
        return words.get(latinizedSpelling);
    }

    public void remove(String latinizedSpelling) {
        words.remove(latinizedSpelling);
    }
}
