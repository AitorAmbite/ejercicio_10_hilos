import java.util.ArrayList;
import java.util.HashMap;

public class Principal implements Callback{
    final int NUMTHREADS = 5;
    int numFinalizados = 0;

    HashMap<Integer,ArrayList<String>> iteraciones = new HashMap<Integer,ArrayList<String>>();
    public Principal() {
        for(int i=1;i<6;i++){
            ThreadCustom hilo = new ThreadCustom(this);
            hilo.setName("Hilo "+i);
            hilo.start();
        }
        while(numFinalizados != NUMTHREADS){
            continue;
        }
        System.out.println(iteraciones.values());
    }

    @Override
    public void addStr(String hiloString,int i){
        //TODO
    }

    public void finished() {
        setNumFinalizados(getNumFinalizados()+1);
    }

    public int getNumFinalizados() {
        return numFinalizados;
    }

    public void setNumFinalizados(int numFinalizados) {
        this.numFinalizados = numFinalizados;
    }
}
