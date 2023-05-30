// Yuri Manna, i6316134
// Helena Posyniak, i6303009
//
// Deliverable 1:
//
// SMELL 1 - Primitive Obsession
//
//    Player and question should be objects, it would be much easier (and cleaner) if player and question were
//    object classes. The player class would keep track where on the board the player is, how many gold coins they have
//    and whether they are in a penalty box. The question class would keep track of all the questions and their types.
//    This smell is bad because it makes the code harder to read and adds unnecessary complications
//    and possible errors.
//
//SMELL 2 - Long Method
//
//    Method roll() is 38 lines long, usually when a method exceeds 10 lines of code we should look
//    into how to keep them shorter.
//
//SMELL 3 - Duplicate Code
//
//    In methods roll() and wasCorrectlyAnswered(), parts of code are duplicated.To fix this we
//    should implement an extract method, which will make the code more efficient, readable and
//    consistent. Duplicates affect the complexity of the code and impacts its performance.
//
//Deliverable 2:
// - the howManyPlayers() method is never used, which means the game never checks if there is enough players to play
// - the code has poor structure, is hard to read. The methods are not in order and have inconsistent names which makes
//	it harder to use them.
// - the code neither handles nor reports errors or exceptions which may lead to unexpected behaviours


import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private final Category pop = new Category("Pop");
    private final Category science = new Category("Science");
    private final Category sports = new Category("Sports");
    private final Category rock = new Category("Rock");

    //int token = 0; // renamed the previous currentPlayer int variable to token, as in the current player has the token
    int token = 0; // current player has a token that is like a pointer, it means they are the current player
    Player currentPlayer;

    public boolean isPlayable() {
        //checks whether there is sufficient amount of players to play

        return (howManyPlayers() >= 2);
    }

    public void addPlayer(Player player) {
        // adds players to the game

        players.add(player);

        System.out.println(player.getName() + " was added");
        System.out.println("They are player number " + players.size());

    }

    public void setCurrentPlayer(){

        currentPlayer = players.get(token);

    }


    public Game() {
        // Adds questions to categories

        for (int i = 0; i < 50; i++) {

            pop.addQuestion(i);
            science.addQuestion(i);
            sports.addQuestion(i);
            rock.addQuestion(i);

        }
    }


    public int howManyPlayers() {
        // returns amount of players in the game
        return players.size();
    }

    public void roll(int roll) {

        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {

            if (roll % 2 != 0) {

                getOutOfPenaltyBox();

                move(roll);

                askQuestion();

            } else {

                stayInPenaltyBox();
            }

        } else {

            move(roll);

            askQuestion();
        }

    }

    public void getOutOfPenaltyBox(){

        currentPlayer.setGettingOutOfPenaltyBox(true);

        System.out.println(currentPlayer.getName() + " is getting out of the penalty box");

    }

    public void stayInPenaltyBox(){

        System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");

        currentPlayer.setGettingOutOfPenaltyBox(false);

    }

    public void move(int roll){

        currentPlayer.setPlace(currentPlayer.getPlace() + roll);

        if (currentPlayer.getPlace() > 11)
            currentPlayer.setPlace(currentPlayer.getPlace() - 12);

        System.out.println(currentPlayer.getName()
                + "'s new location is "
                + currentPlayer.getPlace());
        System.out.println("The category is " + currentCategory().getName());

    }

    public void askQuestion() {
        // Asks a question based on the current category

        if (currentCategory().getName().equals("Pop"))
            pop.removeQuestion();
        if (currentCategory().getName().equals("Science"))
            science.removeQuestion();
        if (currentCategory().getName().equals("Sports"))
            sports.removeQuestion();
        if (currentCategory().getName().equals("Rock"))
            rock.removeQuestion();
    }

    public Category currentCategory() {
        // Sets current category based on the players position on the board
        if (currentPlayer.getPlace() == 0 || currentPlayer.getPlace() == 4 || currentPlayer.getPlace() == 8)
            return pop;
        if (currentPlayer.getPlace() == 1 || currentPlayer.getPlace() == 5 || currentPlayer.getPlace() == 9 )
            return science;
        if (currentPlayer.getPlace() == 2 || currentPlayer.getPlace() == 6 || currentPlayer.getPlace() == 10)
            return sports;
        return rock;
    }

    public boolean correctAnswer() {
        if (currentPlayer.isInPenaltyBox()) {
            if (currentPlayer.isGettingOutOfPenaltyBox()) {

                return onceAnsweredCorrectly(currentPlayer);

            } else {
                token++;
                if (token == players.size())
                    token = 0;
                return true;
            }

        } else {

            return onceAnsweredCorrectly(currentPlayer);
        }
    }

    public boolean onceAnsweredCorrectly(Player player){

        // This method returns whether the player won after answering a question correctly

        System.out.println("Answer was correct!!!!");
        player.addCoins(1);
        System.out.println(player.getName()
                + " now has "
                + player.getCoins()
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        token++;
        if (token == players.size())
            token = 0;

        return winner;
    }

    public boolean wrongAnswer() {

        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);

        token++;
        if (token == players.size())
            token = 0;
        return true;
    }

    private boolean didPlayerWin() {
        // Checks whether a player has won
        return !(currentPlayer.getCoins() == 6);
    }

}
