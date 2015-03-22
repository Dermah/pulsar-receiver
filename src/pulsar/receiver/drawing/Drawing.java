package pulsar.receiver.drawing;

import org.json.JSONObject;

import processing.core.PApplet;

public interface Drawing {
  void setup(PApplet p, JSONObject pulse);
  
  // called every frame to actually draw the animation
  void draw();
  
  // if this drawing is destroyable it should be garbage collected
  boolean destroyable();
}