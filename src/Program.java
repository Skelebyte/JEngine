import BoneSource.*;

public class Program extends Application {

    public static void main(String[] args) {
        Main.run(new Program());
    }

    @Override
    public void start() {
        Window.makeWindow("Hi, mum!", 920, 520);


    }

    @Override
    public void update() {
        Debug.print("Hi, mum!");
        float a = 2.5f;
        Debug.print("round(" + a + ") to 0 dp = " + Mathf.round(a, 0));
    }
}
