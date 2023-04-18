package org.codewars.emotionalSort;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmotionalSortTest {
    @Test
    public void descendingTest() {
        assertArrayEquals(new String[]{":D", ":D", ":(", "T_T"},
                (EmotionalSort.sortEmotions(true, new String[]{":D", "T_T", ":D", ":("})));
        assertArrayEquals(new String[]{":D", ":(", ":(", "T_T"},
                (EmotionalSort.sortEmotions(true, new String[]{"T_T", ":D", ":(", ":("})));
        assertArrayEquals(new String[]{":D", ":D", ":)", ":)", "T_T"},
                (EmotionalSort.sortEmotions(true, new String[]{":)", "T_T", ":)", ":D", ":D"})));

    }
    @Test
    public void ascendingTest(){
        assertArrayEquals(new String[]{"T_T", ":(", ":D", ":D"},
                (EmotionalSort.sortEmotions(false, new String[]{":D", "T_T", ":D", ":("})));
        assertArrayEquals(new String[]{"T_T", ":(", ":(", ":D"},
                (EmotionalSort.sortEmotions(false, new String[]{"T_T", ":D", ":(", ":("})));
        assertArrayEquals(new String[]{"T_T", ":)", ":)", ":D", ":D"},
                (EmotionalSort.sortEmotions(false, new String[]{":)", "T_T", ":)", ":D", ":D"})));

    }

    @Test
    public void emptyArray(){
        assertArrayEquals(new String[]{},
                (EmotionalSort.sortEmotions(false, new String[]{})));
        assertArrayEquals(new String[]{},
                (EmotionalSort.sortEmotions(true, new String[]{})));
    }
    @Test()
    public void randomTest(){
        String[]emotions = new String[]{":D",":)",":|",":(","T_T"};
        boolean order = Math.random()>0.5;
        //the length of the array is random
        int lengthArr = (int)(Math.random()*15);
        String[]arrRandom = new String[lengthArr];
        String[]result = new String[lengthArr];
        for(int i=0;i<lengthArr;i++){
            int index = (int)(Math.random()*emotions.length);
            arrRandom[i]=emotions[index];
        }
        int index=0;
        if (order){
            for (int i = 0; i < emotions.length; i++) {
                for (int j = 0; j < arrRandom.length; j++) {
                    if (emotions[i].equals(arrRandom[j])) {
                        result[index] = arrRandom[j];
                        index++;
                    }
                }
            }
        }
        else {
            for (int i = emotions.length-1; i >=0 ; i--) {
                for (int j = 0; j < arrRandom.length; j++) {
                    if (emotions[i].equals(arrRandom[j])) {
                        result[index] = arrRandom[j];
                        index++;
                    }
                }
            }
        }
        assertArrayEquals(result,
                (EmotionalSort.sortEmotions(order, arrRandom)));

    }

}