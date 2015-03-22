package pulsar.receiver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import processing.core.PApplet;
import pulsar.receiver.drawing.Drawing;

public class Processor {
  private DrawingManager dM;
  
  public Processor(DrawingManager dM) {
    this.dM = dM;
  }
  
  
  public void process (PApplet p, JSONObject packet) { 
    JSONArray pulses = packet.getJSONArray("Pulses");
    JSONObject pulse = pulses.getJSONObject(0);
    
    // Based on the name of the pulse, try and load a drawing class named the same thing 
    try {
      // Stolen from http://stackoverflow.com/questions/9886266/is-there-a-way-to-instantiate-a-class-by-name-in-java
      Class<?> drawingClass = Class.forName("pulsar.receiver.drawing." + pulse.getString("Name"));
      Constructor<?> constructor = drawingClass.getConstructor();
      Object instance = constructor.newInstance();
      Drawing drawing = (Drawing) instance;
      dM.addDrawing(drawing);
    } catch (JSONException e) {
      System.out.println("Error reading recieved JSON packet");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("Could not load drawing class");
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      System.out.println("Could not load a constructor for the drawing class");
      e.printStackTrace();
    } catch (InstantiationException e) {
      System.out.println("An error occured while making an instance of the drawing class");
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      System.out.println("An error occured while making an instance of the drawing class");
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      System.out.println("An error occured while making an instance of the drawing class");
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      System.out.println("An error occured while making an instance of the drawing class");
      e.printStackTrace();
    }
  }
}
