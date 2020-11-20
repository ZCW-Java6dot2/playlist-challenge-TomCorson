package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        Integer forwardNum = forwards(startIndex,selection);
        Integer backwardNum = backwards(startIndex,selection);
        if(forwardNum < backwardNum){
            return forwardNum;
        }
        else {return backwardNum;}
    }

    public Integer forwards(Integer startIndex, String selection){
        ArrayList<String> forward = new ArrayList<String>(Arrays.asList(playList));
        Integer endIndex = forward.indexOf(selection);
        return endIndex - startIndex;
    }
    
    public Integer backwards(Integer startIndex,String selection){
        ArrayList<String> regular = new ArrayList<String>(Arrays.asList(playList));
        ArrayList<String> back = new ArrayList<String>();
        back.add(regular.get(startIndex));
        for(int i = startIndex; i > 0; i--){
            back.add(regular.get(i));
        }
        for(int i = regular.size()-1; i > startIndex; i--){
            back.add(regular.get(i));
        }
        return back.indexOf(selection);
    }
}
