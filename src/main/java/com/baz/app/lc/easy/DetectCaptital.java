package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

public class DetectCaptital implements Google {

    public boolean detactCapitalUse(String word){
        for (int i = 1; i < word.length(); i++) {
            if(word.charAt(i) < 91 && word.charAt(i-1) > 91) return false;
            if(word.charAt(i) > 91 && word.charAt(i-1) < 91) return false;
        }
        return true;
    }

    public boolean smarterSolution(String word){
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]");
    }

}
