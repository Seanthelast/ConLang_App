package com.cs428.conlang.classes;

import com.cs428.conlang.R;

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
    private List<Integer> currentIPAPhonetics;

    //dummy storage for data
    private List<Word> tempWordList;

    //Store a list of ints.  Each int corresponds with a sound and string in numToString and numToSound
    public Datacache(){
        buttonData = new HashMap<>();
        buttonKeys = new ArrayList<>();
        currentIPAPhonetics = new ArrayList<>();
        tempWordList = new ArrayList<>();

        tempWordList.add(new Word(null,"bla","bla","bla","verb"));

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
    //probably doesn't get used anymore since I modified how i
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
                ////LABIAL
            //lab_voiceless_bilabial_nasal.ogg
            case 1: return "m̥";
            //lab_bilabial_nasal.ogg
            case 2: return "m";
            //lab_babiodental_nasal.ogg
            case 3: return "ɱ";
            //lab_linguolabial_nasal.ogg
            case 4: return "n̼";
            //lab_voiceless_bilabial_plosive.ogg
            case 5: return "p";
            //lab_voiced_bilabial_plosive.ogg
            case 6: return "b";
            //lab_voiceless_linguolabial_stop.ogg
            case 7: return "t̼";
            //lab_voiced_linguolabial_stop.ogg
            case 8: return "d̼";
            //lab_voiceless_bilabial_affricate.ogg
            case 9: return "pɸ";
            //lab_voiceless_labiodental_affricate.ogg
            case 10: return "p̪f";
            //lab_voiced_labiodental_affricate.ogg
            case 11: return "b̪v";
            //lab_voiceless_bilabial_fricative.ogg
            case 12: return "ɸ";
            //lab_voiced_bilabial_fricative.ogg
            case 13: return "β";
            //lab_voiceless_labio_dental_fricative.ogg
            case 14: return "f";
            //lab_voiced_labio_dental_fricative.ogg
            case 15: return "v";
            //lab_voiceless_linguolabial_fricative.ogg
            case 16: return "θ̼";
            //lab_bilabial_approximant
            case 17: return "β̞";
            //lab_labiodental_approximant.ogg
            case 18: return "ʋ";
            //lab_labiodental_flap.ogg
            case 19: return "ⱱ";
            //lab_voiceless_bilabial_trill_with_aspiration.ogg
            case 20: return "ʙ̥";
            //lab_bilabial_trill.ogg
            case 21: return "ʙ";
                ////CORONAL
            //cor_voiceless_alveolar_nasal.ogg
            case 22: return "n̥";
            //cor_alveolar_nasal.ogg
            case 23: return "n";
            //cor_retroflex_nasal.ogg
            case 24: return "ɳ";
            //cor_voiceless_dental_stop.ogg
            case 25: return "t̪";
            //cor_voiced_dental_stop.ogg
            case 26: return "d̪";
            //cor_voiceless_alveolar_plosive.ogg
            case 27: return "t";
            //cor_voiced_alveolar_plosive.ogg
            case 28: return "d";
            //cor_voiceless_retroflex_stop.oga
            case 29: return "ʈ";
            //cor_voiced_retroflex_stop.oga
            case 30: return "ɖ";
            //cor_voiceless_dental_sibilant_affricate.oga
            case 31: return "t̪s̪";
            //cor_voiced_dental_sibilant_affricate.oga
            case 32: return "d̪z̪";
            //cor_voiceless_alveolar_sibilant_affricate.oga
            case 33: return "ts";
            //cor_voiced_alveolar_sibilant_affricate.oga
            case 34: return "dz";
            //cor_voiceless_palato_alveolar_affricate.ogg
            case 35: return "t̠ʃ";
            //cor_voiced_palato_alveolar_affricate.ogg
            case 36: return "d̠ʒ";
            // cor_voiceless_retroflex_affricate.ogg
            case 37: return "tʂ";
            //cor_voiced_retroflex_affricate.ogg
            case 38: return "dʐ";
            //cor_voiceless_dental_non_sibilant_affricate.oga
            case 39: return "t̪θ";
            //cor_voiced_dental_non_sibilant_affricate.oga
            case 40: return "d̪ð";
            //cor_voiceless_postalveolar_non_sibilant_affricate.ogg
            case 41: return "t̠ɹ̠̊˔";
            //cor_voiced_postalveolar_non_sibilant_affricate.ogg
            case 42: return "d̠ɹ̠˔";
            //cor_voiceless_alveolar_sibilant.ogg
            case 43: return "s";
            //voiced_alveolar_sibilant.ogg
            case 44: return "z";
            //cor_voiceless_palato_alveolar_sibilant.ogg
            case 45: return "ʃ";
            //cor_voiced_palato_alveolar_sibilant.ogg
            case 46: return "ʒ";
            //cor_voiceless_retroflex_sibilant.ogg
            case 47: return "ʂ";
            //cor_voiced_retroflex_sibilant.ogg
            case 48: return "ʐ";
            //cor_voiceless_dental_fricative.ogg
            case 49: return "θ";
            //cor_voiced_dental_fricative.ogg
            case 50: return "ð";
            //cor_voiceless_alveolar_non_sibilant_fricative.ogg
            case 51: return "θ̠";
            //cor_voiced_alveolar_non_sibilant_fricative.ogg
            case 52: return "ð̠";
            //cor_voiceless_postalveolar_non_sibilant_fricative.ogg
            case 53: return "ɹ̠̊˔";
            //cor_voiced_postalveolar_non_sibilant_fricative.ogg
            case 54: return "ɹ̠˔";
            //cor_voiced_dental_approximant.ogg
            case 55: return "ð̞";
            //cor_alveolar_approximant.ogg
            case 56: return "ɹ";
            //cor_postalveolar_approximant.ogg
            case 57: return "ɹ̠";
            //cor_retroflex_approximant2.oga
            case 58: return "ɻ";
            //cor_alveolar_tap.ogg
            case 59: return "ɾ";
            //cor_retroflex_flap.ogg
            case 60: return "ɽ";
            //cor_voiceless_alveolar_trill.ogg
            case 61: return "r̥";
            //cor_alveolar_trill.ogg
            case 62: return "r";
            //cor_voiced_postalveolar_trill.ogg
            case 63: return "r̠";
            //cor_voiceless_retroflex_trill.ogg
            case 64: return "ɽ̊r̥";
            //cor_voiced_retroflex_trill.ogg
            case 65: return "ɽr";
            //cor_voiceless_alveolar_lateral_affricate.ogg
            case 66: return "tɬ";
            //cor_voiced_alveolar_lateral_affricate.ogg
            case 67: return "dɮ";
            //cor_voiceless_alveolar_lateral_fricative.ogg
            case 68: return "ɬ";
            //cor_voiced_alveolar_lateral_fricative.ogg
            case 69: return "ɮ";
            //cor_voiceless_retroflex_lateral_fricative.ogg
            case 70: return "ꞎ";
            //cor_voiced_dental_lateral_approximant.ogg
            case 71: return "l̪";
            //cor_alveolar_lateral_approximant
            case 72: return "l";
            //cor_voiced_postalveolar_lateral_approximant.ogg
            case 73: return "l̠";
            //cor_vetroflex_lateral_approximant.ogg
            case 74: return "ɭ";
                ////DORSAL
            //dor_palatal_nasal.ogg
            case 75: return "ɲ";
            //dor_velar_nasal.ogg
            case 76: return "ŋ";
            //dor_uvular_nasal.ogg
            case 77: return "ɴ";
            //dor_voiceless_palatal_plosive.ogg
            case 78: return "c";
            //dor_voiced_palatal_plosive.ogg
            case 79: return "ɟ";
            //dor_voiceless_velar_plosive.ogg
            case 80: return "k";
            //dor_voiced_velar_plosive_02.ogg
            case 81: return "ɡ";
            //dor_voiceless_uvular_plosive.ogg
            case 82: return "q";
            //dor_voiced_uvular_stop.oga
            case 83: return "ɢ";
            //dor_voiceless_alveolo_palatal_affricate.ogg
            case 84: return "tɕ";
            //dor_voiced_alveolo_palatal_affricate.ogg
            case 85: return "dʑ";
            //dor_voiceless_palatal_affricate.ogg
            case 86: return "cç";
            //dor_voiced_palatal_affricate.ogg
            case 87: return "ɟʝ";
            //dor_voiceless_velar_affricate.ogg
            case 88: return "kx";
            //dor_voiced_velar_affricate.ogg
            case 89: return "ɡɣ";
            //dor_voiceless_uvular_affricate.ogg
            case 90: return "qχ";
            //dor_voiced_uvular_affricate.ogg
            case 91: return "ɢʁ";
            //dor_voiceless_alveolo_palatal_sibilant.ogg
            case 92: return "ɕ";
            //dor_voiced_alveolo_palatal_sibilant.ogg
            case 93: return "ʑ";
            //dor_voiceless_palatal_fricative.ogg
            case 94: return "ç";
            //dor_voiced_palatal_fricative.ogg
            case 95: return "ʝ";
            //dor_voiceless_velar_fricative.ogg
            case 96: return "x";
            //dor_voiced_velar_fricative.ogg
            case 97: return "ɣ";
            //dor_voiceless_uvular_fricative.ogg
            case 98: return "χ";
            //dor_voiced_uvular_fricative.ogg
            case 99: return "ʁ";
            //dor_palatal_approximant.ogg
            case 100: return "j";
            //dor_voiced_velar_approximant.ogg
            case 101: return "ɰ";
            //dor_voiced_uvular_approximant.ogg
            case 102: return "ʁ̞";
            //dor_voiceless_uvular_trill.ogg
            case 103: return "ʀ̥";
            //dor_uvular_trill.ogg
            case 104: return "ʀ";
            //dor_voiceless_palatal_lateral_affricate.ogg
            case 105: return "ɟʎ̝";
            //dor_voiced_velar_lateral_affricate.ogg
            case 106: return "ɡʟ̝";
            //dor_voiceless_palatal_lateral_fricative.ogg
            case 107: return "ʎ̝";
            //dor_voiced_velar_lateral_fricative.ogg
            case 108: return "ʟ̝";
            //dor_palatal_lateral_approximant.ogg
            case 109: return "ʎ";
            //dor_velar_lateral_approximant.ogg
            case 110: return "ʟ";
            //dor_uvular_lateral_approximant.ogg
            case 111: return "ʟ̠";
                ////Laryngeal
            //lar_epiglottal_stop.ogg
            case 112: return "ʡ";
            //lar_glottal_stop.ogg
            case 113: return "ʔ";
            //lar_voiceless_epiglottal_affricate.ogg
            case 114: return "ʡʜ";
            //lar_voiced_epiglottal_affricate.ogg
            case 115: return "ʡʢ";
            //lar_voiceless_glottal_affricate.ogg
            case 116: return "ʔh";
            //lar_voiceless_pharyngeal_fricative.ogg
            case 117: return "ħ";
            //lar_voiced_pharyngeal_fricative.ogg
            case 118: return "ʕ";
            //lar_voiceless_glottal_fricative.ogg
            case 119: return "h";
            //lar_voiced_glottal_fricative.ogg
            case 120: return "ɦ";
            //lar_epiglottal_flap.oga
            case 121: return "ʡ̆";
            //lar_voiceless_epiglottal_trill.ogg
            case 122: return "ʜ";
            //lar_voiced_epiglottal_trill_2.ogg
            case 123: return "ʢ";
            //lar_uvular_lateral_approximant.ogg
            case 124: return "ʟ̠";
                //// Co-Articulated Consonants
            //coa_voiceless_labial_velar_plosive.ogg
            case 125: return "k͡p";
            //coa_voiced_labial_velar_plosive.ogg
            case 126: return "ɡ͡b";
            //coa_labial_velar_nasal_stop.ogg
            case 127: return "ŋ͡m";
            //coa_voiceless_labio_velar_fricative.ogg
            case 128: return "ʍ";
            //coa_voiced_labio_velar_approximant.ogg
            case 129: return "w";
            //coa_weird_name.wav
            case 130: return "ɥ";
            //coa_voiceless_dorso_palatal_velar_fricative.ogg
            case 131: return "ɧ";
            //coa_velarized_alveolar_lateral_approximant.ogg
            case 132: return "ɫ";
                ////non-pulmonic consonants
            //non_bilabial_ejective_plosive.ogg
            case 133: return "pʼ";
            //non_alveolar_ejective_plosive.ogg
            case 134: return "tʼ";
            //non_retroflex_ejective.ogg
            case 135: return "ʈʼ";
            //non_palatal_ejective.ogg
            case 136: return "cʼ";
            //non_velar_ejective_plosive.ogg
            case 137: return "kʼ";
            //non_uvular_ejective_plosive.ogg
            case 138: return "qʼ";
            //non_epiglottal_ejective.ogg
            case 139: return "ʡʼ";
            //non_labiodental_ejective_fricative.ogg
            case 140: return "fʼ";
            //non_dental_ejective_fricative.ogg
            case 141: return "θʼ";
            //non_alveolar_ejective_fricative.ogg
            case 142: return "sʼ";
            //non_palato_alveolar_ejective_fricative.ogg
            case 143: return "ʃʼ";
            //non_retroflex_ejective_fricative.ogg
            case 144: return "ʂʼ";
            //non_alveolo_palatal_ejective_fricative.ogg
            case 145: return "ɕʼ";
            //non_velar_ejective_fricative.ogg
            case 146: return "xʼ";
            //non_uvular_ejective_fricative.ogg
            case 147: return "χʼ";
            //non_alveolar_ejective_affricate.ogg
            case 148: return "tsʼ";
            //non_palato_alveolar_ejective_affricate.ogg
            case 149: return "t̠ʃʼ";
            //non_retroflex_ejective_affricate.ogg
            case 150: return "ʈʂʼ";
            //non_velar_ejective_affricate.ogg
            case 151: return "kxʼ";
            //non_uvular_ejective_affricate.ogg
            case 152: return "qχʼ";
            //non_alveolar_lateral_ejective_fricative.ogg
            case 153: return "ɬʼ";
            //non_alveolar_lateral_ejective_affricate.ogg
            case 154: return "tɬʼ";
            //non_palatal_lateral_ejective_affricate.ogg
            case 155: return "cʎ̝̊ʼ";
            //non_velar_lateral_ejective_affricate.ogg
            case 156: return "kʟ̝̊ʼ";
            //non_clic_bilabial_sourd.ogg
            case 157: return "kʘ";
            //non_dental_click.ogg
            case 158: return "kǀ";
            //non_postalveolar_click.ogg
            case 159: return "kǃ";
            //non_palatoalveolar_click.ogg
            case 160: return "kǂ";
            //non_alveolar_lateral_click.ogg
            case 161: return "kǁ";
            //non_voiced_bilabial_implosive.ogg
            case 162: return "ɓ";
            //non_voiced_alveolar_implosive.ogg
            case 163: return "ɗ";
            //non_voiced_palatal_implosive.ogg
            case 164: return "ʄ";
            //non_voiced_velar_implosive.ogg
            case 165: return "ɠ";
            //non_voiced_uvular_implosive.ogg
            case 166: return "ʛ";
                ////vowels
            //vow_close_front_unrounded_vowel.ogg
            case 167: return "i";
            //vow_close_front_rounded_vowel.ogg
            case 168: return "y";
            //vow_close_central_unrounded_vowel.ogg
            case 169: return "ɨ";
            //vow_close_central_rounded_vowel.ogg
            case 170: return "ʉ";
            //vow_close_back_unrounded_vowel.ogg
            case 171: return "ɯ";
            //vow_close_back_rounded_vowel.ogg
            case 172: return "u";
            //vow_near_close_near_front_unrounded_vowel.ogg
            case 173: return "ɪ";
            //vow_near_close_near_front_rounded_vowel.ogg
            case 174: return "ʏ";
            //vow_near_close_near_back_rounded_vowel.ogg
            case 175: return "ʊ";
            default: return "0";
        }
    }

    public int numToSound(int num){
        switch (num){
                ////LABIAL
            //lab_voiceless_bilabial_nasal.ogg
            case 1: return R.raw.lab_voiceless_bilabial_nasal;
            case 2: return R.raw.lab_bilabial_nasal;
            case 3: return R.raw.lab_babiodental_nasal;
            case 4: return R.raw.lab_linguolabial_nasal;
            case 5: return R.raw.lab_voiceless_bilabial_plosive;
            case 6: return R.raw.lab_voiced_bilabial_plosive;
            case 7: return R.raw.lab_voiceless_linguolabial_stop;
            case 8: return R.raw.lab_voiced_linguolabial_stop;
            case 9: return R.raw.lab_voiceless_bilabial_affricate;
            case 10: return R.raw.lab_voiceless_labiodental_affricate;
            case 11: return R.raw.lab_voiced_labiodental_affricate;
            case 12: return R.raw.lab_voiceless_bilabial_fricative;
            case 13: return R.raw.lab_voiced_bilabial_fricative;
            case 14: return R.raw.lab_voiceless_labio_dental_fricative;
            case 15: return R.raw.lab_voiced_labio_dental_fricative;
            case 16: return R.raw.lab_voiceless_linguolabial_fricative;
            case 17: return R.raw.lab_bilabial_approximant;
            case 18: return R.raw.lab_labiodental_approximant;
            case 19: return R.raw.lab_labiodental_flap;
            case 20: return R.raw.lab_voiceless_bilabial_trill_with_aspiration;
            case 21: return R.raw.lab_bilabial_trill;
                ////CORONAL
            case 22: return R.raw.cor_voiceless_alveolar_nasal;
            case 23: return R.raw.cor_alveolar_nasal;
            case 24: return R.raw.cor_retroflex_nasal;
            case 25: return R.raw.cor_voiceless_dental_stop;
            case 26: return R.raw.cor_voiced_dental_stop;
            case 27: return R.raw.cor_voiceless_alveolar_plosive;
            case 28: return R.raw.cor_voiced_alveolar_plosive;
            case 29: return R.raw.cor_voiceless_retroflex_stop;
            case 30: return R.raw.cor_voiced_retroflex_stop;
            case 31: return R.raw.cor_voiceless_dental_sibilant_affricate;
            case 32: return R.raw.cor_voiced_dental_sibilant_affricate;
            case 33: return R.raw.cor_voiceless_alveolar_sibilant_affricate;
            case 34: return R.raw.cor_voiced_alveolar_sibilant_affricate;
            case 35: return R.raw.cor_voiceless_palato_alveolar_affricate;
            case 36: return R.raw.cor_voiced_palato_alveolar_affricate;
            case 37: return R.raw.cor_voiceless_retroflex_affricate;
            case 38: return R.raw.cor_voiced_retroflex_affricate;
            case 39: return R.raw.cor_voiceless_dental_non_sibilant_affricate;
            case 40: return R.raw.cor_voiced_dental_non_sibilant_affricate;
            case 41: return R.raw.cor_voiceless_postalveolar_non_sibilant_affricate;
            case 42: return R.raw.cor_voiced_postalveolar_non_sibilant_affricate;
            case 43: return R.raw.cor_voiceless_alveolar_sibilant;
            case 44: return R.raw.voiced_alveolar_sibilant;
            case 45: return R.raw.cor_voiceless_palato_alveolar_sibilant;
            case 46: return R.raw.cor_voiced_palato_alveolar_sibilant;
            case 47: return R.raw.cor_voiceless_retroflex_sibilant;
            case 48: return R.raw.cor_voiced_retroflex_sibilant;
            case 49: return R.raw.cor_voiceless_dental_fricative;
            case 50: return R.raw.cor_voiced_dental_fricative;
            case 51: return R.raw.cor_voiceless_alveolar_non_sibilant_fricative;
            case 52: return R.raw.cor_voiced_alveolar_non_sibilant_fricative;
            case 53: return R.raw.cor_voiceless_postalveolar_non_sibilant_fricative;
            case 54: return R.raw.cor_voiced_postalveolar_non_sibilant_fricative;
            case 55: return R.raw.cor_voiced_dental_approximant;
            case 56: return R.raw.cor_alveolar_approximant;
            case 57: return R.raw.cor_postalveolar_approximant;
            case 58: return R.raw.cor_retroflex_approximant2;
            case 59: return R.raw.cor_alveolar_tap;
            case 60: return R.raw.cor_retroflex_flap;
            case 61: return R.raw.cor_voiceless_alveolar_trill;
            case 62: return R.raw.cor_alveolar_trill;
            case 63: return R.raw.cor_voiced_postalveolar_trill;
            case 64: return R.raw.cor_voiceless_retroflex_trill;
            case 65: return R.raw.cor_voiced_retroflex_trill;
            case 66: return R.raw.cor_voiceless_alveolar_lateral_affricate;
            case 67: return R.raw.cor_voiced_alveolar_lateral_affricate;
            case 68: return R.raw.cor_voiceless_alveolar_lateral_fricative;
            case 69: return R.raw.cor_voiced_alveolar_lateral_fricative;
            case 70: return R.raw.cor_voiceless_retroflex_lateral_fricative;
            case 71: return R.raw.cor_voiced_dental_lateral_approximant;
            case 72: return R.raw.cor_alveolar_lateral_approximant;
            case 73: return R.raw.cor_voiced_postalveolar_lateral_approximant;
            case 74: return R.raw.cor_vetroflex_lateral_approximant;
                ////DORSAL
            case 75: return R.raw.dor_palatal_nasal;
            case 76: return R.raw.dor_velar_nasal;
            case 77: return R.raw.dor_uvular_nasal;
            case 78: return R.raw.dor_voiceless_palatal_plosive;
            case 79: return R.raw.dor_voiced_palatal_plosive;
            case 80: return R.raw.dor_voiceless_velar_plosive;
            case 81: return R.raw.dor_voiced_velar_plosive_02;
            case 82: return R.raw.dor_voiceless_uvular_plosive;
            case 83: return R.raw.dor_voiced_uvular_stop;
            case 84: return R.raw.dor_voiceless_alveolo_palatal_affricate;
            case 85: return R.raw.dor_voiced_alveolo_palatal_affricate;
            case 86: return R.raw.dor_voiceless_palatal_affricate;
            case 87: return R.raw.dor_voiced_palatal_affricate;
            case 88: return R.raw.dor_voiceless_velar_affricate;
            case 89: return R.raw.dor_voiced_velar_affricate;
            case 90: return R.raw.dor_voiceless_uvular_affricate;
            case 91: return R.raw.dor_voiced_uvular_affricate;
            case 92: return R.raw.dor_voiceless_alveolo_palatal_sibilant;
            case 93: return R.raw.dor_voiced_alveolo_palatal_sibilant;
            case 94: return R.raw.dor_voiceless_palatal_fricative;
            case 95: return R.raw.dor_voiced_palatal_fricative;
            case 96: return R.raw.dor_voiceless_velar_fricative;
            case 97: return R.raw.dor_voiced_velar_fricative;
            case 98: return R.raw.dor_voiceless_uvular_fricative;
            case 99: return R.raw.dor_voiced_uvular_fricative;
            case 100: return R.raw.dor_palatal_approximant;
            case 101: return R.raw.dor_voiced_velar_approximant;
            case 102: return R.raw.dor_voiced_uvular_approximant;
            case 103: return R.raw.dor_voiceless_uvular_trill;
            case 104: return R.raw.dor_uvular_trill;
            case 105: return R.raw.dor_voiceless_palatal_lateral_affricate;
            case 106: return R.raw.dor_voiced_velar_lateral_affricate;
            case 107: return R.raw.dor_voiceless_palatal_lateral_fricative;
            case 108: return R.raw.dor_voiced_velar_lateral_fricative;
            case 109: return R.raw.dor_palatal_lateral_approximant;
            case 110: return R.raw.dor_velar_lateral_approximant;
            case 111: return R.raw.dor_uvular_lateral_approximant;
                ////Laryngeal 112, 12
            case 112: return R.raw.lar_epiglottal_stop;
            case 113: return R.raw.lar_glottal_stop;
            case 114: return R.raw.lar_voiceless_epiglottal_affricate;
            case 115: return R.raw.lar_voiced_epiglottal_affricate;
            case 116: return R.raw.lar_voiceless_glottal_affricate;
            case 117: return R.raw.lar_voiceless_pharyngeal_fricative;
            case 118: return R.raw.lar_voiced_pharyngeal_fricative;
            case 119: return R.raw.lar_voiceless_glottal_fricative;
            case 120: return R.raw.lar_voiced_glottal_fricative;
            case 121: return R.raw.lar_epiglottal_flap;
            case 122: return R.raw.lar_voiceless_epiglottal_trill;
            case 123: return R.raw.lar_voiced_epiglottal_trill_2;
            case 124: return R.raw.lar_uvular_lateral_approximant;
                ////Co-Articulated Consonants
            case 125: return R.raw.coa_voiceless_labial_velar_plosive;
            case 126: return R.raw.coa_voiced_labial_velar_plosive;
            case 127: return R.raw.coa_labial_velar_nasal_stop;
            case 128: return R.raw.coa_voiceless_labio_velar_fricative;
            case 129: return R.raw.coa_voiced_labio_velar_approximant;
            case 130: return R.raw.coa_weird_name;
            case 131: return R.raw.coa_voiceless_dorso_palatal_velar_fricative;
            case 132: return R.raw.coa_velarized_alveolar_lateral_approximant;
                ////non-pulmonic consonants
            case 133: return R.raw.non_bilabial_ejective_plosive;
            case 134: return R.raw.non_alveolar_ejective_plosive;
            case 135: return R.raw.non_retroflex_ejective;
            case 136: return R.raw.non_palatal_ejective;
            case 137: return R.raw.non_velar_ejective_plosive;
            case 138: return R.raw.non_uvular_ejective_plosive;
            case 139: return R.raw.non_epiglottal_ejective;
            case 140: return R.raw.non_labiodental_ejective_fricative;
            case 141: return R.raw.non_dental_ejective_fricative;
            case 142: return R.raw.non_alveolar_ejective_fricative;
            case 143: return R.raw.non_palato_alveolar_ejective_fricative;
            case 144: return R.raw.non_retroflex_ejective_fricative;
            case 145: return R.raw.non_alveolo_palatal_ejective_fricative;
            case 146: return R.raw.non_velar_ejective_fricative;
            case 147: return R.raw.non_uvular_ejective_fricative;
            case 148: return R.raw.non_alveolar_ejective_affricate;
            case 149: return R.raw.non_palato_alveolar_ejective_affricate;
            case 150: return R.raw.non_retroflex_ejective_affricate;
            case 151: return R.raw.non_velar_ejective_affricate;
            case 152: return R.raw.non_uvular_ejective_affricate;
            case 153: return R.raw.non_alveolar_lateral_ejective_fricative;
            case 154: return R.raw.non_alveolar_lateral_ejective_affricate;
            case 155: return R.raw.non_palatal_lateral_ejective_affricate;
            case 156: return R.raw.non_velar_lateral_ejective_affricate;
            case 157: return R.raw.non_clic_bilabial_sourd;
            case 158: return R.raw.non_dental_click;
            case 159: return R.raw.non_postalveolar_click;
            case 160: return R.raw.non_palatoalveolar_click;
            case 161: return R.raw.non_alveolar_lateral_click;
            case 162: return R.raw.non_voiced_bilabial_implosive;
            case 163: return R.raw.non_voiced_alveolar_implosive;
            case 164: return R.raw.non_voiced_palatal_implosive;
            case 165: return R.raw.non_voiced_velar_implosive;
            case 166: return R.raw.non_voiced_uvular_implosive;
                ////vowels
            case 167: return R.raw.vow_close_front_unrounded_vowel;
            case 168: return R.raw.vow_close_front_rounded_vowel;
            case 169: return R.raw.vow_close_central_unrounded_vowel;
            case 170: return R.raw.vow_close_central_rounded_vowel;
            case 171: return R.raw.vow_close_back_unrounded_vowel;
            case 172: return R.raw.vow_close_back_rounded_vowel;
            case 173: return R.raw.vow_near_close_near_front_unrounded_vowel;
            case 174: return R.raw.vow_near_close_near_front_rounded_vowel;
            //case 175: return R.raw.vow_near_close_near_back_rounded_vowel;
            default: return 0;

        }
    }
    //TODO: Trim the sounds and also have them appear here
    public int numToSoundTrimmed(int num){
        switch (num){
            case 1: return 1;


            default: return 0;
        }
    }

    public String getCurrentIPASequence() {
        return currentIPASequence;
    }
    public List<Integer> getCurrentIPAPhonetics(){return currentIPAPhonetics;}

    public void setCurrentIPASequence(String currentIPASequence) {
        this.currentIPASequence = currentIPASequence;
    }
    public void appendCurrIPAPhonetic(int buttonNum) {
        currentIPAPhonetics.add(buttonNum);
    }
    public void appendCurrIPASequence(String str){
        currentIPASequence = currentIPASequence + str;
    }
    public void deleteLastIPASequence(){
        //delete string
        currentIPASequence = currentIPASequence.trim();
        int endIndex = currentIPASequence.length() - 1;
        while (endIndex >= 0 && currentIPASequence.charAt(endIndex) != ' ') {
            endIndex--;
        }
        currentIPASequence = currentIPASequence.substring(0, endIndex + 1);
        //delete phonetic
        if (!currentIPAPhonetics.isEmpty()) {
            int lastIndex = currentIPAPhonetics.size() - 1;
            currentIPAPhonetics.remove(lastIndex); // Remove the last element
        }
    }
    public String getIPASequenceNoSpaces(){
        StringBuilder result = new StringBuilder();
        for (char c : currentIPASequence.toCharArray()) {
            if (c != ' ') {result.append(c);}
        }
        return result.toString();
    }
    public String getIPAPhoneticsToString(){
        return currentIPAPhonetics.toString();
    }
    public void addWord(Word wordToAdd){
        tempWordList.add(wordToAdd);
    }
    public List<Word> getTempWordList(){
        return tempWordList;
    }
}
