//    Yuri Manna, i6316134
//    Helena Posyniak, i6303009

import java.util.Random;

public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {

        Game aGame = new Game(50);

        Player Chet = new Player("Chet",0,0,false);
        Player Pat = new Player("Pat",0,0,false);
        Player Sue = new Player("Sue",0,0,false);

        aGame.addPlayer(Chet);
        aGame.addPlayer(Pat);
        aGame.addPlayer(Sue);



        Random rand = new Random();

        do {
            aGame.setCurrentPlayer();

            if(!aGame.isPlayable()){

                System.out.println("Not enough players!");
                return;

            }



            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.correctAnswer();
            }

        } while (notAWinner);

        System.out.println("Game is finished!!!!");

    }
}
