package pulsar.receiver.drawing;

import org.json.JSONObject;

import processing.core.PApplet;
import pulsar.receiver.Config;

public interface Drawing {
  void setup(PApplet p, JSONObject pulse, Config config);
  
  // called every frame to actually draw the animation
  void draw();
  
  // if this drawing is destroyable it should be garbage collected
  boolean destroyable();
}