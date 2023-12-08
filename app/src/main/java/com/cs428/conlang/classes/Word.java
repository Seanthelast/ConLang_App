package com.cs428.conlang.classes;

import java.util.ArrayList;
import java.util.List;

public class Word{

    ///change Phonetics to Integer.
    // Each integer corresponds with a phonetic character, decoded in the Datacache
    private List<Integer> phonetics;
    private String latinizedSpelling;
    private String meaning;
    private String notes;
    private String partOfSpeech;
    //private List<Rule> variantRules; // The modified versions of the word based on some rule

    public Word(List<Integer> phonetics, String latinizedSpelling, String meaning, String notes, String partOfSpeech) {
        this.phonetics = phonetics;
        this.latinizedSpelling = latinizedSpelling;
        this.meaning = meaning;
        this.notes = notes;
        this.partOfSpeech = partOfSpeech;
        //this.variantRules = variantRules;
    }

    // Getters and setters for Word properties
    public String getMeaning() {
        return meaning;
    }
    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getPartOfSpeech() {
        return partOfSpeech;
    }
    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
    public List<Integer> getPhonetics() {
        return phonetics;
    }
    public void setPhonetics(List<Integer> phonetics) {
        this.phonetics = phonetics;
    }
    public String getLatinizedSpelling() {
        return latinizedSpelling;
    }
    public void setLatinizedSpelling(String latinizedSpelling) {
        this.latinizedSpelling = latinizedSpelling;
    }
}