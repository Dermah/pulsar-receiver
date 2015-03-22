package pulsar.receiver.drawing;

import org.json.JSONObject;

import processing.core.PApplet;

public class CircleGrow implements Drawing {

  PApplet p;
  int x, y, radius;
  int r, g, b;

  public CircleGrow() {
  }

  @Override
  public void setup(PApplet p, JSONObject pulse) {
    this.p = p;
    x = (int) p.random(100, p.displayWidth-100); 
    y = (int) p.random(100, p.displayHeight-100);
    r = (int) p.random(255);
    g = (int) p.random(255);
    b = (int) p.random(255);
    radius = 0;
  }

  @Override
  public void draw() {
    if (radius < 900) {
      p.fill(r, g, b);
      p.ellipse(x, y, radius, radius);
      radius = radius + 75;
    }
  }

  @Override
  public boolean destroyable() {
    return (radius > 900);
  }

}
