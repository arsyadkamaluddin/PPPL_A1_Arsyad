package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    @Test
    void ownerOnWallet() {
        Wallet wallet = new Wallet("Amhar");
        Assertions.assertEquals("Amhar",wallet.getOwner());
    }

    @Test
    void setOwner() {
        Wallet wallet = new Wallet("Amhar");
        wallet.setOwner("Arsyad");
        Assertions.assertEquals("Arsyad",wallet.getOwner());
    }

    @Test
    void addCard() {
        Wallet wallet = new Wallet("Amhar");
        wallet.addCard("BCA");
        Assertions.assertEquals(1, wallet.getCards().size());
        Assertions.assertEquals("BCA",wallet.getCards().get(0));
    }

    @Test
    void getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add("BCA");
        cards.add("BRI");
        Wallet wallet = new Wallet("Amhar");
        wallet.addCard(cards.get(0));
        wallet.addCard(cards.get(1));
        Assertions.assertArrayEquals(cards.toArray(),wallet.getCards().toArray());
    }

    @Test
    void takeCard() {
        Wallet wallet = new Wallet("Amhar");
        wallet.addCard("BCA");
        String card = wallet.takeCard("BCA");
        Assertions.assertEquals("BCA",card);
        Assertions.assertNull(wallet.takeCard("BCA"));
    }

    @Test
    void getOwner() {
        Wallet wallet = new Wallet("Amhar");
        Assertions.assertEquals("Amhar",wallet.getOwner());
    }

    @Test
    void addMoney(){
        Wallet wallet = new Wallet("Amhar");
        wallet.addMoney(100000);
        Assertions.assertEquals(1,wallet.getMoney().size());
    }

    @Test
    void addMoneyOnType(){
        Wallet wallet = new Wallet("Amhar");
        wallet.addMoney(100000);
        Assertions.assertEquals("kertas",wallet.getMoney().get(0).getType());
    }

    @Test
    void takeMoney(){
        Wallet wallet = new Wallet("Amhar");
        wallet.addMoney(100);
        Assertions.assertNull(wallet.takeMoney(1000));
        Assertions.assertEquals(100,wallet.takeMoney(100).getValue());
        Assertions.assertNull(wallet.takeMoney(100));
    }
    
    @Test 
    void getBalance(){
        Wallet wallet = new Wallet("Amhar");
        wallet.addMoney(100000);
        wallet.addMoney(50000);
        Assertions.assertEquals(150000,wallet.getBalance());
    }
}