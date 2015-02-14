package pulsar.receiver;

import processing.core.*;

public class Receiver extends PApplet {

  public void setup () {
    size(displayWidth, displayHeight);
    background(0);
  }

  public void draw () {

  }

  public static void main (String[] args) {
    // TODO Auto-generated method stub
    System.out.println("What the hell is this");

    PApplet.main(new String[] { "--present", "pulsar.receiver.Receiver" });
  }

}
