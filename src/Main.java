import adapter.*;
import aop.AopBrowser;
import decorator.*;
import facade.Ftp;
import facade.Reader;
import facade.SftpClient;
import facade.Writer;
import observer.Button;
import observer.IButtonListener;
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

        /*
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
        */

        /*
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar a3 = new A3(audi, "A3");
        a3.showPrice();

        // a4
        ICar a4 = new A4(audi, "A3");
        a4.showPrice();

        // a5
        ICar a5 = new A5(audi, "A3");
        a5.showPrice();
         */

        /*
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지 전달 : click1");
        button.click("메세지 전달 : click2");
        button.click("메세지 전달 : click3");
        button.click("메세지 전달 : click4");
         */

        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");

        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisConnect();
        ftpClient.disConnect();

        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();

    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}