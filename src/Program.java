import JEngine.*;

public class Program extends Application {

    public static void main(String[] args) {
        JEngine.run(new Program());
    }

    @Override
    public void start() {
        Window.makeWindow("hi mum", 256, 256, true);
        Window.setBackgroundColor(new RGBA(25, 50, 75));
    }

    float start = 1;
    float end = 5;

    @Override
    public void update() {
        start = Mathf.lerp(start, end, 2 * Time.deltaTime());
        Debug.print(start);
    }
}
