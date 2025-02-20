package org.example;

import java.util.ArrayList;

public class ScoreCollection {
    private ArrayList<Integer> scores;
    public ScoreCollection(){
        this.scores = new ArrayList<Integer>();
    }
    public void addScore(int score){
        scores.add(score);
    }
    public double averageScore(){
        double total = 0;
        for (int i = 0; i < scores.size() ; i++) {
            total += scores.get(i);
        }

        return total/scores.size();
    }
}
