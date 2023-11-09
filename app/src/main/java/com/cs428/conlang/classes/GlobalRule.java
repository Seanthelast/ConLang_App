package com.cs428.conlang.classes;

public class GlobalRule {
    String definition;
    boolean isActive;
    Parser parser;

    public GlobalRule(String definition, boolean isActive, Parser parser) {
        this.definition = definition;
        this.isActive = isActive;
        this.parser = parser;
    }

    public String applyParser(Word word, String pattern) {
        // The parser decodes the pattern and applies it to the word and returns it
        // Should this include more than just the variant form? Like a little bit
        // of a description. "Quickly - adverb" or just return "Quickly"? We want to
        // have the "- adverb" information appended at some point.
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}