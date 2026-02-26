
package cmuguesser.Model;

public class MapData {
    private String  imagePath;
    private String dataPath;
    
    MapData(String imagePath, String dataPath){
        this.imagePath = imagePath;
        this.dataPath = dataPath;
    }
    
    public String getImagePath(){return imagePath;}
    public String getdataPath(){return dataPath;}
}
