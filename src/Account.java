public class Account {

    private String name;
    private String game;
    private int resultGame;

    public void setResultGame(int resultGame) {
        this.resultGame = resultGame;
    }

    public int getResultGame() {
        return resultGame;
    }

    public Account(String name,String game) {
        this.name = name;
        this.game = game;
    }

    public String getName() {
        return this.name;
    }

    public String getGame() {
        return this.game;
    }
}
