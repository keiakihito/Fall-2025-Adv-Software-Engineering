// 継承でBorderはDisplayと同じmethodを持っている。
// つまり、Border(飾り枠)はDisplay(中身)と同一視できる。
public abstract class Border extends Display {
    protected Display display;          // この飾り枠がくるんでいる「中身」

    protected Border(Display display) { // インスタンス生成時に「中身」を引数で指定
        this.display = display;
    }
}
