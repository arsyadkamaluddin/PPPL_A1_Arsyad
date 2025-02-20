package org.example;

import java.util.ArrayList;

public class Wallet {
    private String owner;
    private ArrayList<String> cards;

    public Wallet(){
        this.cards = new ArrayList<String>();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }
    public ArrayList<String> getCards(){
        return this.cards;
    }
    public String getOwner(){
        return this.owner;
    }
}
