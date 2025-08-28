public class Display {
    private DisplayImpl impl;
    // To use DisplayImpl methods, we need to pass an instance of DisplayImpl to the Display constructor
    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
    // Diplay methods translate to DisplayImpl methods
    public void open() {
        impl.rawOpen();
    }
    // Diplay methods translate to DisplayImpl methods
    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }
    // Diplay methods calls Display APIs above
    public final void display() {
        open();
        print();
        close();
    }
}
