package pulsar.receiver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONArray;
import org.json.JSONObject;

import processing.core.PApplet;

public class Processor {
  
  public Processor() {
    
  }
  
  
  public void process (PApplet p, JSONObject packet) { 
    JSONArray pulses = packet.getJSONArray("Pulses");
    JSONObject pulse = pulses.getJSONObject(0);
    
    try {
      Class<?> drawingClass = Class.forName("pulsar.receiver.UDPListener");
      Constructor<?> constructor = drawingClass.getConstructor(String.class, Integer.class);
      Object instance = constructor.newInstance("stringparam", 42);
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
