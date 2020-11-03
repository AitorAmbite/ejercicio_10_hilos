import java.util.Random;

public class ThreadCustom extends Thread{
    Callback callback;

    public ThreadCustom(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        Random r = new Random();
        int tiempo = r.nextInt(7000)+1000;
        try {
            sleep(tiempo);
            callback.finished("El "+getName()+" ha dormido por "+tiempo+" Milisegundos");
            tiempo = r.nextInt(6000)+2000;
            sleep(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
