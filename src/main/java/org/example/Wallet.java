package org.example;

import java.util.ArrayList;

public class Wallet {
    private String owner;
    private ArrayList<String> cards = new ArrayList<String>();
    private ArrayList<Money> money = new ArrayList<Money>();

    public Wallet(String owner){
        this.owner = owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }
    public void addMoney(int money) {
        this.money.add(new Money(money));
    }
    public int getBalance() {
        int sum = 0;
        for(Money money : money){
            sum += money.getValue();
        }
        return sum;
    }

    public ArrayList<Money> getMoney() {
        return money;
    }
    public Money takeMoney(int amount) {
        for(Money money : money){
            if (money.getValue() == amount) {
                Money taked = money;
                this.money.remove(money);
                return taked;
            }
        }
        return null;
    }
    public ArrayList<String> getCards(){
        return this.cards;
    }
    public String takeCard(String takeCard) {
        for (String card : this.cards){
            if (card.equals(takeCard)){
                this.cards.remove(takeCard);
                return takeCard;
            }
        }
        return null;
    }
    public String getOwner(){
        return this.owner;
    }
}
