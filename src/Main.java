import adapter.*;
import aop.AopBrowser;
import proxy.Browser;
import proxy.BrowserProxy;
import proxy.IBrowser;
import singleton.AClazz;
import singleton.BClazz;
import singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        /*
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aSocketClient = aClazz.getSocketClient();
        SocketClient bSocketClient = bClazz.getSocketClient();

        System.out.println("동일한 클라이언트인가 = " + aSocketClient.equals(bSocketClient));
        */
        /*
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        //connect(cleaner);
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
        */

        /*
        // IBrowser browser = new Browser("www.naver.com");
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();
        */

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println(end.get());

        aopBrowser.show();
        System.out.println(end.get());


    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}