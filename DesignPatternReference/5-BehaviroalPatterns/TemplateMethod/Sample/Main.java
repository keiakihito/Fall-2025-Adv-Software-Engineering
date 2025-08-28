package TemplateMethod.Sample;

public class Main {
    public static void main(String[] args) {

        // Liskov Substitution Principle:
        // We can replace the AbstractDisplay with the CharDisplay or the StringDisplay
        // and the program will still work
        // 全てのサブクラスはスーパークラスの型として使っても問題なく動作するべき。
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
        d1.display();
        d2.display();
    }
}

/*
 <<HHHHH>>
+-------------+
|Hello, world.|
|Hello, world.|
|Hello, world.|
|Hello, world.|
|Hello, world.|
+-------------+
 */