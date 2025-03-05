package org.example;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    private static Wallet wallet;

    @BeforeAll
    static void setUpAll() {
        System.out.println("Starting Wallet Tests...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All Wallet Tests Completed.");
    }

    @BeforeEach
    void setUp() {
        Assertions.assertNull(wallet);
        System.out.println("Wallet is clear");
        wallet = new Wallet("Amhar");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clear the wallet");
        wallet = null;
        Assertions.assertNull(wallet);
    }

    @Test
    void ownerOnWallet() {
        assertEquals("Amhar", wallet.getOwner());
    }

    @Test
    void setOwner() {
        wallet.setOwner("Arsyad");
        assertEquals("Arsyad", wallet.getOwner());
    }

    @Test
    void addCard() {
        wallet.addCard("BCA");
        assertEquals(1, wallet.getCards().size());
        assertEquals("BCA", wallet.getCards().get(0));
    }

    @Test
    void getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add("BCA");
        cards.add("BRI");
        wallet.addCard(cards.get(0));
        wallet.addCard(cards.get(1));
        assertArrayEquals(cards.toArray(), wallet.getCards().toArray());
    }

    @Test
    void takeCard() {
        wallet.addCard("BCA");
        String card = wallet.takeCard("BCA");
        assertEquals("BCA", card);
        assertNull(wallet.takeCard("BCA"));
    }

    @Test
    void getOwner() {
        assertEquals("Amhar", wallet.getOwner());
    }

    @Test
    void addMoney() {
        wallet.addMoney(100000);
        assertEquals(1, wallet.getMoney().size());
    }

    @Test
    void addMoneyOnType() {
        wallet.addMoney(100000);
        assertEquals("kertas", wallet.getMoney().get(0).getType());
    }

    @Test
    void takeMoney() {
        wallet.addMoney(100);
        assertNull(wallet.takeMoney(1000));
        assertEquals(100, wallet.takeMoney(100).getValue());
        assertNull(wallet.takeMoney(100));
    }

    @Test
    void getBalance() {
        wallet.addMoney(100000);
        wallet.addMoney(50000);
        assertEquals(150000, wallet.getBalance());
    }
}