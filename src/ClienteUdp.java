import java.io.*;
import java.net.*;

class ClienteUdp {
   private static int portaServidor = 8100;
   private static byte[] sendData = new byte[1024];
   private static byte[] receiveData = new byte[1024];

   public static byte[] lerString () throws Exception {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      return in.readLine().getBytes();
   }

   public static void main(String args[]) throws Exception
   {
      DatagramSocket clientSocket = new DatagramSocket();
      String ip = "192.168.25.5";
      InetAddress ipServidor = InetAddress.getByName(ip);
      sendData = lerString();

      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipServidor, portaServidor);
      clientSocket.send(sendPacket);

      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      clientSocket.close();

      System.out.println("FROM SERVER:" + new String(receivePacket.getData()));
   }
}
