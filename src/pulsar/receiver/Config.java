package pulsar.receiver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

/* stolen from http://stackoverflow.com/questions/3806062/how-to-open-a-txt-file-and-read-numbers-in-java */

public class Config {
  private JSONObject config;
  
  public void loadConfig (String path) {
    BufferedReader reader = null;
    String file = "";
    try {
      reader = new BufferedReader(new FileReader (path));
      String line = null;
      
      while ((line = reader.readLine()) != null) {
        file = file + line;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        } 
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
    
    config = new JSONObject(file);
  }
  
}

