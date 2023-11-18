package com.example.buttonstest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datacache {
    private static Datacache instance;
    private Map<Integer, Boolean> buttonData;
    private static final int numberOfKeys = 100;
    private List<Integer> buttonKeys;
    private String currentIPASequence = "";

    //Store a list of ints.  Each int corresponds with a sound and string in numToString and numToSound
    public Datacache(){
        buttonData = new HashMap<>();
        buttonKeys = new ArrayList<>();
        for(int i = 1; i <= numberOfKeys; i++){
            buttonData.put(i,false);
            buttonKeys.add(i);
        }
    }
    public static Datacache getInstance(){
        if (instance == null){
          instance = new Datacache();
        }
        return instance;
    }
    public int getSize(){
        return numberOfKeys;
    }

    //return the number of trues
    public int getSizeTrue(){
        int count = 0;
        for(int i = 1; i <= numberOfKeys; i++){
            if(getData(i)){
                count++;
            }
        }
        return count;
    }
    public boolean getData(int key){
        return buttonData.get(key);
    }
    public void switchData(int key){
        if(buttonData.get(key)){
            buttonData.put(key,false);
        }
        else{
            buttonData.put(key,true);
        }
    }

    public Integer getKey(int position){
        return buttonKeys.get(position);
    }
    public List<Integer> getTrueKeys(){
        List<Integer> trueKeys = new ArrayList<>();
        for(int i = 1; i <= numberOfKeys; i++){
            if (getData(i)){
                trueKeys.add(i);
            }
        }
        return trueKeys;
    }
    public Integer getKeyByPos(int pos){
        int count = 0;
        int index = 0;
        while(count != pos){
            index++;
            if(getData(index)){
                count++;
            }
        }
        return index;
    }
    //associate number with sound
    public String numToString(int num){
        switch (num){
            //voiceless Bilabial Nasal
            case 1: return "m̥";
            // bilabial nasal
            case 2: return "m";
            // labiodental nasal
            case 3: return "ɱ";
            //linguo-labial nasal
            case 4: return "n̼";
            //Voiceless_Alveolar_Nasal.ogg
            case 5: return "n̥";
            //alveolar_nasal
            case 6: return "n";
            //retroflex nasal
            case 7: return "ɳ";
            //palatal nasal
            case 8: return "ɲ";
            //velar nasal
            case 9: return "ŋ";
            //uvular nasal
            case 10: return "ɴ";
            //voiceless_bilabial_plosive.ogg
            case 11: return "p";
            //voiced bilabial plosive
            case 12: return "b";
            //voiceless_linguolabial_stop.ogg
            case 13: return "t̼";
            //voiced linguolabial stop
            case 14: return "d̼";
            //voiceless dental stop
            case 15: return "t̪";
            //voiced dental stop
            case 16: return "d̪";
            //voiceless_alveolar_plosive.ogg
            case 17: return "t";
            //voiced_alveolar_plosive.ogg
            case 18: return "d";
            //voiceless retroflx stop
            case 19: return "ʈ";
            //voiced_retroflex_stop.oga
            case 20:return "ɖ";
            //voiceless_palatal_plosive.ogg
            case 21: return "c";
            //voiced_palatal_plosive.ogg
            case 22: return "ɟ";
            //voiceless_velar_plosive.ogg
            case 23: return "k";
            //voiced_velar_plosive_02.ogg
            case 24: return "g";
            //voiceless_uvular_plosive.ogg
            case 25: return "q";
            //voiced_uvular_stop.oga
            case 26: return "ɢ";
            //epiglottal_stop.ogg
            case 27: return "ʡ";

            //
            case 29: return "ʔ";
            //
            case 30: return "t̪s̪";
            //
            case 31: return "d̪z̪";
            //
            case 32: return "ts";
            //
            case 33: return "dz";
            //
            case 34: return "t̠ʃ";
            //
            case 35: return "d̠ʒ";
            //
            case 36: return "tʂ";
            //
            case 37: return "dʐ";
            //
            case 38: return "pɸ";
            //
            case 39: return "p̪f";
            //
            case 40: return "b̪v";
            //
            case 41: return "t̪θ";
            //
            case 42: return "d̪ð";
            //
            case 43: return "t̠ɹ̠̊˔";
            //
            case 44: return "d̠ɹ̠˔";
            //
            case 45: return "cç";
            //
            case 46: return "ɟʝ";
            //
            case 47: return "kx";
            //
            case 48: return "ɡɣ";
            //
            case 49: return "qχ";
            //
            case 50: return "ɢʁ";
            //
            case 51: return "ʡʜ";
            //
            case 52: return "ʡʢ";
            //
            case 53: return "ʔh";
            //
            case 54: return "s";
            //
            case 55: return "z";
            //
            case 56: return "ʃ";
            //
            case 57: return "ʒ";
            //
            case 58: return "ʂ";
            //
            case 59: return "ʐ";
            //
            case 60: return "ɕ";
            //
            case 61: return "ʑ";
            //
            case 62: return "ɸ";
            //
            case 63: return "β";
            //
            case 64: return "f";
            //
            case 65: return "v";
            //
            case 66: return "θ̼̼";
            //
            case 67: return "ð̼";
            //
            case 68: return "θ";
            //
            case 69: return "ð";
            //
            case 70: return "θ̠";
            //
            case 71: return "ð̠";
            //
            case 72: return "ɹ̠̊˔";
            //
            case 73: return "ɹ̠˔";
            //
            case 74: return "ç";
            //
            case 75: return "ʝ";
            //
            case 76: return "x";
            //
            case 77: return "ɣ";
            //
            case 78: return "χ";
            //
            case 79: return "ʁ";
            //
            case 80: return "ħ";
            //
            case 81: return "ʕ";
            //
            case 82: return "h";
            //
            case 83: return "ɦ";
            //
            case 84: return "β̞";
            //
            case 85: return "ʋ";
            //
            case 86: return "ð̞";
            //
            case 87: return "ɹ";
            //
            case 88: return "ɹ̠";
            //
            case 89: return "ɻ";
            //
            case 90: return "j";
            //
            case 91: return "ɰ";
            //
            case 92: return "ʁ̞";
            //
            case 93: return "ⱱ";
            //
            case 94: return "ɾ";
            //
            case 95: return "ɽ";
            //
            case 96: return "ʡ̆";
            //
            case 97: return "ʙ̥";
            //
            case 98: return "ʙ";
            //
            case 99: return "r̥";
            //
            case 101: return "r";
            //
            case 102: return "r̠";
            //
            case 103: return "ɽ̊r̥";
            //
            case 104: return "ɽr";
            //
            case 105: return "ʀ̥";
            //
            case 106: return "ʀ";
            //
            case 107: return "ʜ";
            //
            case 108: return "ʢ";
            //
            case 109: return "tɬ";
            //
            case 110: return "dɮ";
            //
            case 111: return "cʎ̥˔";
            //
            case 112: return "nope"; //unreadable "k\uD837\uDF04"
            //
            case 113: return "ɡʟ̝";
            //
            case 114: return "ɬ";
            //
            case 115: return "ɮ";
            //
            case 116: return "ꞎ";
            //
            case 117: return "ʎ̝";
            //
            case 118: return "nope"; //unreadable "\uD837\uDF04"
            //
            case 119: return "ʟ̝";
            //
            case 120: return "l̪";
            //
            case 121: return "l";
            //
            case 122: return "l̠";
            //
            case 123: return "ɭ";
            //
            case 124: return "ʎ";
            //
            case 125: return "ʟ";
            //
            case 126: return "ʟ̠";
            //
            case 127: return "k͡p";
            //
            case 128: return "ɡ͡b";
            //
            case 129: return "ʍ";
            //
            case 130: return "w";
            //
            case 131: return "ɥ";
            //
            case 132: return "ɧ";
            //
            case 133: return "ɫ";

            //clicks left

            //
            case 134: return "";
            //



            default: return "0";
        }
    }

    public int numToSound(int num){
        switch (num){
            //voiceless Bilabial Nasal
            case 1: return R.raw.voiceless_bilabial_nasal;
            // bilabial nasal
            case 2: return R.raw.bilabial_nasal;
            // labiodental nasal
            case 3: return R.raw.labiodental_nasal;
            //linguo-labial nasal
            case 4: return R.raw.linguolabial_nasal;
            //Voiceless_Alveolar_Nasal.ogg
            case 5: return R.raw.voiceless_alveolar_nasal;
            //alveolar nasal
            case 6: return R.raw.alveolar_nasal;
            //retroflex nasal
            case 7: return R.raw.retroflex_nasal;
            //palatal nasal
            case 8: return R.raw.palatal_nasal;
            //velar nasal
            case 9: return R.raw.velar_nasal;
            //uvular nasal
            case 10: return R.raw.uvular_nasal;
            //voiceless_bilabial_plosive.ogg
            case 11: return R.raw.voiceless_bilabial_plosive;
            //voiced bilabial plosive.ogg
            case 12: return R.raw.voiced_bilabial_plosive;
            //voiceless_linguolabial_stop.ogg
            case 13: return R.raw.voiceless_linguolabial_stop;
            //voiced liguolaabial stop
            case 14: return R.raw.voiced_linguolabial_stop;
            //voiceless dental stop
            case 15: return R.raw.voiceless_dental_stop;
            //voiced dental stop
            case 16: return R.raw.voiced_dental_stop;
            //voiceless_alveolar_plosive.ogg
            case 17: return R.raw.voiceless_alveolar_plosive;
            //voiced_alveolar_plosive.ogg
            case 18: return R.raw.voiced_alveolar_plosive;
            //voiceless retroflx stop
            case 19: return R.raw.voiceless_retroflex_stop;
            //voiced_retroflex_stop.oga
            case 20:return R.raw.voiced_retroflex_stop;
            //voiceless_palatal_plosive.ogg
            case 21: return R.raw.voiceless_palatal_plosive;
            //voiced_palatal_plosive.ogg
            case 22: return R.raw.voiceless_palatal_plosive;
            //voiceless_velar_plosive.ogg
            case 23: return R.raw.voiceless_velar_plosive;
            //voiced_velar_plosive_02.ogg
            case 24: return R.raw.voiced_velar_plosive_02;
            //voiceless_uvular_plosive.ogg
            case 25: return R.raw.voiceless_uvular_plosive;
            //voiced_uvular_stop.oga
            case 26: return R.raw.voiced_uvular_stop;
            //epiglottal_stop.ogg
            case 27: return R.raw.epiglottal_stop;

            default: return 0;
        }
    }

    public String getCurrentIPASequence() {
        return currentIPASequence;
    }

    public void setCurrentIPASequence(String currentIPASequence) {
        this.currentIPASequence = currentIPASequence;
    }
    public void appendCurrIPASequence(String str){
        currentIPASequence = currentIPASequence + str; //still need to get the text to refresh somehow
    }
}
