package pulsar.receiver.drawing;

import processing.core.PApplet;
import processing.core.PImage;

public class GitHubAvatar implements Drawing {

  private PApplet p;
  private PImage webImg;
  
  @Override
  public void setup (PApplet p) {
    this.p = p;
    String url = "https://processing.org/img/processing-web.png";
    // Load image from a web server
    webImg = p.loadImage(url, "png");
    System.out.println("loading");
  }

  @Override
  public void draw () {
    if (webImg != null) {
      p.image(webImg, 0, 0);
    }
  }

  @Override
  public boolean destroyable () {
    // TODO Auto-generated method stub
    return false;
  }

}