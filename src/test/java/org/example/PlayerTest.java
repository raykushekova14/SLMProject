package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testGetName() {
        Player player = new Player("Alice", 'X');
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testGetSymbol() {
        Player player = new Player("Bob", 'O');
        assertEquals('O', player.getSymbol());
    }
}

