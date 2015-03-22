package pulsar.receiver;

import org.json.JSONObject;

import processing.core.*;

public class Receiver extends PApplet {

  private UDPListener listener;
  
  public void setup () {
    listener = new UDPListener();
    
    size(displayWidth, displayHeight);
    background(0);
  }

  public void draw () {
	  while (!listener.queue.isEmpty()) {
      
      
    }
  }

  public static void main (String[] args) {
    
    System.out.println("Starting pulsar-reciever");

    PApplet.main(new String[] { "--present", "pulsar.receiver.Receiver" });
  }

}
