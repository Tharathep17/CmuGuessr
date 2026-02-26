
package cmuguesser.Model;


public class Location {
    private String name;
    private int x, y;
    
    public Location(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public double calcDistance(int clickX, int clickY){
        int disX = clickX - x;
        int disY = clickY - y;
        
        return Math.sqrt((disX*disX) + (disY*disY));
    }
    
    
    public int getX(){return x;}
    public int getY(){return y;}
    
    public String getName(){return name;}
    
}
