//    Yuri Manna, i6316134
//    Helena Posyniak, i6303009

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;


public class GameTest {


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

    }

    @Test
    public void testIsPlayableOnePlayer(){
     game.addPlayer(player1);

     assertFalse(game.isPlayable());

    }

    @Test
    public void testIsPlayableTwoPlayers(){
        game.addPlayer(player1);
        game.addPlayer(player2);

        assertTrue(game.isPlayable());

    }

    @Test
    public void testIsPlayableMoreThanTwoPlayers(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        assertTrue(game.isPlayable());

    }
    @Test
    public void testRollInPenaltyBoxAndRollOdd() {
        game.addPlayer(player1);
        player1.setInPenaltyBox(true);
        game.setCurrentPlayer();
        game.roll(3);
        assertFalse(player1.isInPenaltyBox());
        assertEquals(3, player1.getPlace());
        assertEquals("Rock", game.currentCategory().getName());
    }

    @Test
    public void testRollInPenaltyBoxAndRollEven() {
        game.addPlayer(player1);
        player1.setInPenaltyBox(true);
        game.setCurrentPlayer();
        game.roll(4);
        assertTrue(player1.isInPenaltyBox());
    }

    @Test
    public void testRollNotInPenaltyBox() {
        game.addPlayer(player1);
        game.setCurrentPlayer();
        game.roll(5);
        assertEquals(5, player1.getPlace());
        assertEquals("Science", game.currentCategory().getName());
    }


    @Test
    public void testRoll(){
        game.addPlayer(player1);
        game.setCurrentPlayer();
        game.roll(3);

        assertEquals("Rock",game.currentCategory().getName());

        assertEquals(3,player1.getPlace());

    }

    @Test
    public void testCorrectAnswer(){
        game.addPlayer(player1);
        game.setCurrentPlayer();
        game.correctAnswer();

        assertEquals(1,player1.getCoins());

    }

    @Test
    public void testCorrectAnswerInPenaltyBoxIsGettingOut() {
        game.addPlayer(player1);
        player1.setInPenaltyBox(true);
        player1.setGettingOutOfPenaltyBox(true);
        game.setCurrentPlayer();

        assertEquals(1, player1.getCoins());

    }

    @Test
    public void testWrongAnswer(){
        game.addPlayer(player1);
        game.setCurrentPlayer();
        game.wrongAnswer();

        assertTrue(player1.isInPenaltyBox());
        assertEquals(0, player1.getCoins());
    }

    @Test
    public void testCurrentCategory(){
        game.addPlayer(player1);
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
        game.addPlayer(player1);
        game.setCurrentPlayer();
        Category science = game.currentCategory();
        game.askQuestion();

        assertEquals(49,science.howManyQuestionsLeft());

    }

    @Test
    public void testMoveUsual(){

        game.addPlayer(player1);
        game.setCurrentPlayer();
        game.move(4);
        assertEquals(4,player1.getPlace());

    }

    @Test
    public void testMoveWrap(){

        game.addPlayer(player1);
        game.setCurrentPlayer();
        player1.setPlace(10);
        game.move(4);
        assertEquals(2,player1.getPlace());

    }



}