package JEngine;

public abstract class JObject implements Runnable {

    public boolean waitingForStart = true;
    public boolean loopExecuted;

    Thread objectThread;

    protected JObject() {

        objectThread = new Thread(this);

        JEngine.objects.add(this);
    }

    @Override
    public void run() {
        if(waitingForStart) start();
        waitingForStart = false;

        if(loopExecuted) loopExecuted = false;

        while(Window.window.isShowing()) {

            tick();
            loopExecuted = true;

            try {
                objectThread.sleep(1);
            } catch (InterruptedException e) {
                Debug.logException(getClass(), e);
            }

        }

    }

    public abstract void start();
    public abstract void tick();

    public void destroy() {
        // TODO: remove the object from the ArrayList in JEngine, delete in memory?
    }

}
