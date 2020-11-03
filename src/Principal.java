import java.util.ArrayList;

public class Principal implements Callback{
    final int TAMTHREADS = 5;
    ThreadCustom[] hilos = new ThreadCustom[TAMTHREADS];
    ArrayList <String> lista = new ArrayList<String>();

    public Principal() {
        for (int i=1;i<5;i++){
            System.out.println("Iteracion "+i);
            for(int j=0;j<TAMTHREADS;j++){
                ThreadCustom hilo = new ThreadCustom(this);
                hilo.setName("hilo "+j);
                hilo.start();
                hilos[j] = hilo;
            }
            for(ThreadCustom h:hilos){
                try {
                    h.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\n\n El hilo que ha terminado primero es: "+lista.get(0));
            lista.clear();
        }
    }

    public void addStr(String hiloString){
        lista.add(hiloString);
    }

    @Override
    public void finished(String finalizacion) {
        System.out.println(finalizacion );
    }


}
