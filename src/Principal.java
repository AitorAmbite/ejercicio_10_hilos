import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Principal implements Callback{
    final int NUMTHREADS = 100;
    int numFinalizados = 0;

    HashMap<Integer,ArrayList<String>> iteraciones = new HashMap<Integer,ArrayList<String>>();

    public Principal() {
        for(int i=1;i<NUMTHREADS+1;i++){
            ThreadCustom hilo = new ThreadCustom(this);
            hilo.setName("Hilo "+i);
            hilo.start();
        }

    }

    @Override
    public void addStr(String hiloString,int i){
        ArrayList<String> aux = null;
        if(iteraciones.containsKey(i)){
            aux = new ArrayList<String>(iteraciones.get(i));
            aux.add(hiloString);
            iteraciones.put(i,aux);
        }else{
            aux = new ArrayList<String>();
            aux.add(hiloString);
            iteraciones.put(i,aux);
        }
    }

    @Override
    public void acaba() {
        setNumFinalizados(getNumFinalizados()+1);
        if(getNumFinalizados() >= NUMTHREADS){
            System.out.println(getNumFinalizados());
            for (Map.Entry<Integer, ArrayList<String>> ite : iteraciones.entrySet()) {
                System.out.println("Iteracion " + ite.getKey());
                for (String hilo : ite.getValue()) {
                    System.out.println(hilo);
                }
            }
        }
    }

    public int getNumFinalizados() {
        return numFinalizados;
    }

    public void setNumFinalizados(int numFinalizados) {
        this.numFinalizados = numFinalizados;
    }
}
