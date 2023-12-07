package com.cs428.conlang.classes;

public class Rule {
    GlobalRule parentRule;
    String encodedPattern;

    public Rule(GlobalRule parentRule, String encodedPattern) {
        this.parentRule = parentRule;
        this.encodedPattern = encodedPattern;
    }

    public GlobalRule getParentRule() {
        return parentRule;
    }

    public void setParentRule(GlobalRule parentRule) {
        this.parentRule = parentRule;
    }

    public String getEncodedPattern() {
        return encodedPattern;
    }

    public void setEncodedPattern(String encodedPattern) {
        this.encodedPattern = encodedPattern;
    }
}