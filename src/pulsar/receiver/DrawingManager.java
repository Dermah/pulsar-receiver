package pulsar.receiver;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONObject;

import processing.core.PApplet;
import pulsar.receiver.drawing.Drawing;

public class DrawingManager {
  PApplet p;
  ArrayList<Drawing> queue;
  
  public DrawingManager(PApplet p) {
    this.p = p;
    queue = new ArrayList<Drawing>();
  }
  
  public void addDrawing (Drawing d, JSONObject pulse, Config config) {
    if (d != null) {
      d.setup(p, pulse, config);
      queue.add(d);
    }
  }
  
  public void draw() {
    for (Drawing drawing : queue) {
      drawing.draw();
    }
    cleanQueue();
  }
  
  public void cleanQueue() {
    for (Iterator<Drawing> q = queue.iterator(); q.hasNext();) {
      Drawing drawing = (Drawing) q.next();
      if (drawing.destroyable()) {
        q.remove();
      }
    }
  }
}
