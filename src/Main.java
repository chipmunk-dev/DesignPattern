import singleton.AClazz;
import singleton.BClazz;
import singleton.SocketClient;

public class Main {
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aSocketClient = aClazz.getSocketClient();
        SocketClient bSocketClient = bClazz.getSocketClient();

        System.out.println("동일한 클라이언트인가 = " + aSocketClient.equals(bSocketClient));
    }
}