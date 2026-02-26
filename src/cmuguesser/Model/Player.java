
package cmuguesser.Model;

public class Player {
    private final String name;
    private int score;
    
    public Player(String name){
        this.name = name;
        this.score = 0;
    }
    
    public void addScore(int point){
        this.score += point;
    }
    
    public int getScore(){return this.score;}
    
    public String getName(){return this.name;}
}
