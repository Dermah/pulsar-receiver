package pulsar.receiver;

import processing.core.*;

public class Receiver extends PApplet {

  private UDPListener listener;
  private Processor processor;
  private DrawingManager dM;
  
  public void setup () {
    listener = new UDPListener();
    dM = new DrawingManager(this);
    processor = new Processor(dM);
    
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
