package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void WhenSecondPlayerWin() {
        Player misha = new Player(2323, "Миша", 120);
        Player vasya = new Player(1234567, "Вася", 100);
        Game game = new Game();

        game.register(misha);
        game.register(vasya);

        int actual = game.round("Вася", "Миша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void WhenFirstPlayerWin() {
        Player vasya = new Player(2323, "Вася", 120);
        Player misha = new Player(1234567, "Миша", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(misha);


        int actual = game.round("Вася", "Миша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void WhenStringTheEqual() {
        Player misha = new Player(1, "Миша", 100);
        Player vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(vasya);
        game.register(misha);


        int actual = game.round("Вася", "Миша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void WhenFirstPlayerNotExist() {
        Player misha = new Player(1, "Миша", 100);
        Game game = new Game();

        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Лев", "Миша"));


    }

    @Test
    public void WhenSecondPlayerNotExist() {
        Player misha = new Player(1, "Миша", 100);
        Game game = new Game();

        game.register(misha);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Лев"));


    }


}