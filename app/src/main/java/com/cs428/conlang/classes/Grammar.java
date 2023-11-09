package com.cs428.conlang.classes;

import java.util.ArrayList;
import java.util.List;

public class Grammar {
    private List<GlobalRule> globalRules;
    private List<Rule> instanceRules;

    public Grammar() {
        globalRules = new ArrayList<>();
        instanceRules = new ArrayList<>();
    }

    // Methods for managing the grammar
    public List<GlobalRule> getGlobalRules() {
        return globalRules;
    }
    public void activateGlobalRule(Rule newGeneralRule) {
        // Activate global rule
    }
    public void removeGeneralRule(Rule oldRule) {
        // Deactivate global rule
    }
    public List<Rule> getInstanceRules() {
        // Sort through the rules and get a list based on a criteria
        // Example. getSpecificRules(PartOfSpeech verbs) {
        // return all rules specific to verbs;}
        return instanceRules;
    }
    public void addInstanceRule(Rule newRule) {
        // There will need to be some check to ensure that you aren't adding a duplicate rule
        instanceRules.add(newRule);
    }
}