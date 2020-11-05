import java.util.Random;

public class ThreadCustom extends Thread{
    Callback callback;

    public ThreadCustom(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        Random r = new Random();
        int tiempo = 0;
        try {
            for(int i=1;i<6;i++){
                tiempo = r.nextInt(7000)+1000;
                sleep(tiempo);
                System.out.println("Espero "+getName());
                callback.addStr("El "+getName()+" ha dormido por "+tiempo+" milisegundos" ,i);
            }
            callback.finished();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
