//    Yuri Manna, i6316134
//    Helena Posyniak, i6303009
//    A new class, because a player has many properties it was best to make it an object

public class Player {

    private String name; // Players name
    private int place; // Keeps track of where on the board the player is
    private int coins;  // Keeps track of how many coins a player has
    private boolean inPenaltyBox;  // Either true or false, depending on whether the player is ina penalty box or not

    private boolean isGettingOutOfPenaltyBox;
    public Player(String name, int place, int coins, boolean inPenaltyBox) {
        // Constructor method

        this.name = name;
        this.place = place;
        this.coins = coins;
        this.inPenaltyBox = inPenaltyBox;
    }

    public String getName() {
        // Name getter
        return name;
    }

    public int getPlace() {
        // Place getter
        return place;
    }

    public void setPlace(int place) {
        // Place setter
        this.place = place;
    }

    public int getCoins() {
        // Coin getter
        return coins;
    }

    public void addCoins(int coins) {
        // Adds coins to the players purse
        this.coins = this.coins + coins;
    }

    public boolean isInPenaltyBox() {
        // Returns whether the player is in a penalty box
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        // InPenaltyBox setter
        this.inPenaltyBox = inPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }
}
