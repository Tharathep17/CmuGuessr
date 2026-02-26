
package cmuguesser.util;

import cmuguesser.Model.Location;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class FileLoader {
    
    public static List<Location> load(String filePath){
        List<Location> location = new ArrayList<>();
        
        try(InputStream is = FileLoader.class.getResourceAsStream(filePath);
         BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            String line;
            
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                
                String nameImage = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                
                location.add(new Location(nameImage, x, y));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        
        return location;
    }
}
