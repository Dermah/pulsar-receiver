package pulsar.receiver;

import processing.core.*;

public class Receiver extends PApplet {

  private UDPListener udp;
  
  public void setup () {
    udp = new UDPListener();
    
    size(displayWidth, displayHeight);
    background(0);
  }

  public void draw () {
	  
  }

  public static void main (String[] args) {
    
    System.out.println("What the hell is this");

    PApplet.main(new String[] { "--present", "pulsar.receiver.Receiver" });
  }

}
