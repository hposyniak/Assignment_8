//    Yuri Manna, i6316134
//    Helena Posyniak, i6303009

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;


public class GameTest {

    // roll method

    // The correct/incorrect answering of questions

    //The changing of question categories and whether a question relating to the correct
    //category is asked

    Game game;
    Player player1;
    Player player2;
    Player player3;

    @Before
    public void setUp(){

        game = new Game(50);

        player1 = new Player("Jim",0,0,false);
        player2 = new Player("Mia",0,0,false);
        player3 = new Player("Alex",0,0,false);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
    }

    @Test
    public void testRoll(){

        game.setCurrentPlayer();
        game.roll(3);

        assertEquals("Rock",game.currentCategory().getName());

        assertEquals(3,player1.getPlace());

    }

    @Test
    public void testCorrectAnswer(){

        game.setCurrentPlayer();
        game.correctAnswer();

        assertEquals(1,player1.getCoins());

    }

    @Test
    public void testWrongAnswer(){

        game.setCurrentPlayer();
        game.wrongAnswer();

        assertTrue(player1.isInPenaltyBox());

    }

    @Test
    public void testCurrentCategory(){

        game.setCurrentPlayer();

        player1.setPlace(0);
        assertEquals("Pop",game.currentCategory().getName());

        player1.setPlace(1);
        assertEquals("Science",game.currentCategory().getName());

        player1.setPlace(2);
        assertEquals("Sports",game.currentCategory().getName());

        player1.setPlace(3);
        assertEquals("Rock",game.currentCategory().getName());

        player1.setPlace(4);
        assertEquals("Pop",game.currentCategory().getName());

        player1.setPlace(5);
        assertEquals("Science",game.currentCategory().getName());

        player1.setPlace(6);
        assertEquals("Sports",game.currentCategory().getName());

        player1.setPlace(7);
        assertEquals("Rock",game.currentCategory().getName());

        player1.setPlace(8);
        assertEquals("Pop",game.currentCategory().getName());

        player1.setPlace(9);
        assertEquals("Science",game.currentCategory().getName());

        player1.setPlace(10);
        assertEquals("Sports",game.currentCategory().getName());

        player1.setPlace(11);
        assertEquals("Rock",game.currentCategory().getName());

    }

    @Test
    public void testAskQuestion(){

        game.setCurrentPlayer();
        Category science = game.currentCategory();
        game.askQuestion();



        assertEquals(49,science.howManyQuestionsLeft());

    }




}