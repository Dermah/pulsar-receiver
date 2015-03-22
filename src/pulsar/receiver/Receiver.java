package pulsar.receiver;

import processing.core.*;

public class Receiver extends PApplet {

  private Config config;
  private UDPListener listener;
  private Processor processor;
  private DrawingManager dM;
  
  public void setup () {
    listener = new UDPListener();
    dM = new DrawingManager(this);

    config = new Config();
    config.loadConfig("pulsar.json");
    
    processor = new Processor(dM, config);
    
    
    frameRate(30);
    size(displayWidth, displayHeight);
    background(0);
  }

  public void draw () {
    background(0);
    
	  while (!listener.queue.isEmpty()) {
      processor.process(this, listener.queue.remove(0));
      
    }
	  
	  dM.draw();
  }

  public static void main (String[] args) {
    
    System.out.println("Starting pulsar-reciever");

    PApplet.main(new String[] { "--present", "pulsar.receiver.Receiver" });
  }

}
