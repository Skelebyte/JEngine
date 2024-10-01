import BoneSource.*;

public class Program extends Application {

    public static void main(String[] args) {
        BoneSource.run(new Program());
    }

    @Override
    public void start() {
        Window.makeWindow("hi mum", 256, 256, false);
        Window.setBackgroundColor(new RGBA(24, 29, 85));
    }

    @Override
    public void update() {
    }
}
