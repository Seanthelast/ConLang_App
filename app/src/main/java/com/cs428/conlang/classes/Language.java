package com.cs428.conlang.classes;

public class Language {
    private String name;
    private Dictionary dictionary;
    private Grammar grammar;

    public Language(String name) {
        this.name = name;
        // Initialize empty dictionary and grammars
    }

    // Methods for language level operations

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Grammar getGrammar() {
        return grammar;
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }
}