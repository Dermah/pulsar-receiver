package pulsar.receiver;

import org.json.JSONObject;

import processing.core.*;

public class Receiver extends PApplet {

  private UDPListener listener;
  private Processor processor;
  
  public void setup () {
    listener = new UDPListener();
    processor = new Processor();
    
    size(displayWidth, displayHeight);
    background(0);
  }

  public void draw () {
	  while (!listener.queue.isEmpty()) {
      processor.process(this, listener.queue.remove(0));
      
    }
  }

  public static void main (String[] args) {
    
    System.out.println("Starting pulsar-reciever");

    PApplet.main(new String[] { "--present", "pulsar.receiver.Receiver" });
  }

}
