import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("Hiroshi Yuki");
        Product card2 = factory.create("Tomura");
        Product card3 = factory.create("Hanako Sato");
        card1.use();
        card2.use();
        card3.use();
    }
}
/*
Sample Run 
Hiroshi Yukiのカードを作ります。
[IDCard:Hiroshi Yuki]を登録しました。
Tomuraのカードを作ります。
[IDCard:Tomura]を登録しました。
Hanako Satoのカードを作ります。
[IDCard:Hanako Sato]を登録しました。
[IDCard:Hiroshi Yuki]を使います。
[IDCard:Tomura]を使います。
[IDCard:Hanako Sato]を使います。

 */


