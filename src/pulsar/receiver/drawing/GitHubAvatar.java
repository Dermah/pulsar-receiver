package pulsar.receiver.drawing;

import org.json.JSONObject;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class GitHubAvatar implements Drawing {

  private PApplet p;
  private PImage webImg;
  
  private float r;
  private float g;
  private float b;
  
  private int boxSize = 0;
  private int fade = 0;
  
  private int framesLeft = 255;
  private boolean done = false;
  
  private String user;
  
  @Override
  public void setup (PApplet p, JSONObject pulse) {
    this.p = p;
    String url = pulse.getString("AvatarUrl");
    // Load image from a web server
    webImg = p.loadImage(url, "png");
    r = p.random(255);
    g = p.random(255);
    b = p.random(255);
    user = pulse.getString("User");
  }

  @Override
  public void draw () {
    if (webImg != null) {
      if (boxSize <= (webImg.height + 100)) {
        boxSize += (webImg.height + 100 - boxSize)/4 + 1;
        p.rectMode(PConstants.CENTER);
        p.fill(r, g, b);
        p.rect(p.displayWidth/2, p.displayHeight/2, boxSize, boxSize);
      } else if (framesLeft >= 0) {
        p.imageMode(PConstants.CENTER);
        p.rectMode(PConstants.CENTER);
        p.tint(255, fade);
        p.fill(r, g, b);
        
        p.rect(p.displayWidth/2, p.displayHeight/2, boxSize, boxSize);
        p.image(webImg, p.displayWidth/2, p.displayHeight/2);
        
        p.textAlign(PConstants.CENTER);
        p.textMode(PConstants.CENTER);
        p.textSize(50);
        p.fill(255, 255, 255, fade);
        p.text(user, p.displayWidth/2, p.displayHeight/2 + boxSize/2 + 50);
        
        if (fade <= 255) {
          fade += 5;
        } else {
          framesLeft --;
        }
      } else {
        fade -= 15;
        
        p.imageMode(PConstants.CENTER);
        p.rectMode(PConstants.CENTER);
        p.tint(255, fade);
        p.fill(r, g, b, fade);
        
        p.rect(p.displayWidth/2, p.displayHeight/2, boxSize, boxSize);
        p.image(webImg, p.displayWidth/2, p.displayHeight/2);
        
        p.textAlign(PConstants.CENTER);
        p.textMode(PConstants.CENTER);
        p.textSize(50);
        p.fill(255, 255, 255, fade);
        p.text(user, p.displayWidth/2, p.displayHeight/2 + boxSize/2 + 50);
        
        if (fade >= 255) {
          done = true;
        }
      }
    }
  }

  @Override
  public boolean destroyable () {
    return done;
  }

}