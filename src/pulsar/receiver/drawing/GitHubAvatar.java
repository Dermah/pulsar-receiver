package pulsar.receiver.drawing;

import org.json.JSONObject;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class GitHubAvatar implements Drawing {

  private PApplet p;
  private PImage webImg;
  
  
  
  @Override
  public void setup (PApplet p, JSONObject pulse) {
    this.p = p;
    String url = pulse.getString("AvatarUrl");
    // Load image from a web server
    webImg = p.loadImage(url, "png");
    System.out.println("loading");
  }

  @Override
  public void draw () {
    if (webImg != null) {
      p.imageMode(PConstants.CENTER);
      p.rectMode(PConstants.CENTER);
      p.fill(127, 255, 231);
      
      p.rect(p.displayWidth/2, p.displayHeight/2, webImg.width + 100, webImg.height + 100);
      p.image(webImg, p.displayWidth/2, p.displayHeight/2);
    }
  }

  @Override
  public boolean destroyable () {
    // TODO Auto-generated method stub
    return false;
  }

}