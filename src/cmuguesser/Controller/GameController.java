
package cmuguesser.Controller;

import cmuguesser.Config.GameConfig;
import cmuguesser.Model.Location;
import cmuguesser.Model.Player;

public class GameController {
    private Player player;
    private Location currentLocation;
    
    GameController(Player player, Location location){
        this.player = player;
        this.currentLocation = location;
    }
    
    public int click(int x, int y){
        int score = currentLocation.calcScore(x, y, GameConfig.maxScore);
        
        player.addScore(score);
        return score;
    }
    
    public Player getPlayer(){return player;}
    public Location getCurrentLocation(){return currentLocation;}
}
