package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    Wallet wallet = new Wallet();
    String owner = "Arsyad";

    @Test
    void setOwner() {
        wallet.setOwner(owner);
        Assertions.assertEquals(owner,wallet.getOwner());
    }

    @Test
    void addCard() {
    }

    @Test
    void getCards() {
    }

    @Test
    void getOwner() {
        Assertions.assertEquals(owner,wallet.getOwner());
    }
}