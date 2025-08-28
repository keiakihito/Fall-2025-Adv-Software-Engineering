import framework.Product;
import framework.Manager;

public class Main {
    public static void main(String[] args) {
        // プロトタイプの登録
        Manager manager = new Manager();
        UnderPen upen = new UnderPen('-');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        
        // プロトタイプの登録
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // プロトタイプの生成と利用
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}

/*
Sample Run

Hello, world.
-------------
***************
*Hello, world.*
***************
///////////////
/Hello, world./
///////////////

 */