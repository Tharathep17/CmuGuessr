
package cmuguesser.Controller;


import cmuguesser.Model.Location;
import cmuguesser.Model.Player;
import cmuguesser.UI.MainFrame;
import cmuguesser.util.FileLoader;
import java.util.*;

public class GameController {
    private final Player player;
    private List<Location> location;
    private List<Location> allLocation;
    private Location currentLocation;
    private int currentIndex = 0;
    
    private final int max_score = 1000;
    private double max_distance = 220.0;
    
    public GameController(Player player){
        this.player = player;
    }
    
    public void randomLocation(){
        if(currentIndex < allLocation.size()){
            currentLocation = allLocation.get(currentIndex);
            currentIndex += 1;
        }
        else{
            currentLocation = null;
        }
    }
    
    public void loadMap(String filePath){
        allLocation = FileLoader.load(filePath);
        
        Collections.shuffle(allLocation);
        currentIndex = 0;
        
    }
    
    public int calcScore(int clickX, int clickY){
        if(MainFrame.hard == true){max_distance = 50;}
        
        double distance = Math.sqrt(Math.pow(clickX - currentLocation.getX(), 2) + Math.pow(clickY - currentLocation.getY(), 2));

        
        double r = 1 - (distance / max_distance);
        if(r < 0){r = 0;}
        
        int score = (int)(r * max_score);
        player.addScore(score);
        
        return score;
    }
    
    public int getScore(){return player.getScore();}
    public Player getPlayer(){return player;}
    public Location getCurrentLocation(){return currentLocation;}
}
