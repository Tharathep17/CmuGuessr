
package cmuguesser.Model;

import cmuguesser.Config.MapConfig;

public class Location {
    private String name;
    private int x, y;
    
    Location(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public double calcDistance(int clickX, int clickY){
        int disX = clickX - x;
        int disY = clickY - y;
        
        return Math.sqrt((disX*disX) + (disY*disY));
    }
    
    public int calcScore(int ClickX, int ClickY, int maxScore){
        double distance = calcDistance(ClickX, ClickY);
        
        double ratio = 1 - (distance/MapConfig.maxDistance);
        if(ratio < 1){
            ratio = 0;
        }
        
        return (int)(maxScore*ratio);
    }
    
    public int getX(){return x;}
    public int getY(){return y;}
    
    public String getName(){return name;}
    
}
