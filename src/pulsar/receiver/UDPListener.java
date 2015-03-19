package pulsar.receiver;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class UDPListener implements Runnable {
  
  private DatagramSocket datagramSocket;
  private ArrayList<JSONObject> queue;
  
  public UDPListener () {
    openDatagramSocket();
    queue = new ArrayList<JSONObject>();
  }
  
  private void openDatagramSocket() {
    int port = 6660;
    try {
      datagramSocket = new DatagramSocket(port);
    } catch (SocketException e) {
      System.out.println("Failed to open datagram socket on port " + port);
      e.printStackTrace();
    }
  }
  
  private void listen() {
    byte[] buffer = new byte[1024];
    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

    try {
      datagramSocket.receive(packet);
    } catch (IOException e) {
      System.out.println("Failed while recieving a datagram packet");
      e.printStackTrace();
      return;
    }
    
    String decoded = "BAD STRING";
    try {
      decoded = new String(buffer, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      System.out.println("Failed while decoding received packet");
      e.printStackTrace();
      return;
    }
    
    JSONObject json = null;
    try {
      json = new JSONObject(decoded);
      if (json.has("Pulsar")) {
        queue.add(json);
      }
    } catch (JSONException e) {
      System.out.println("Non-JSON object recieved");
      e.printStackTrace();
      return;
    }
  }

  @Override
  public void run() {
    while (true) {
      listen();
    }
  }

}
