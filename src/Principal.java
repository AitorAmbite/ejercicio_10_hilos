import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Principal implements Callback{

    ArrayList <String> lista = new ArrayList<String>();

    public Principal() {
        for(int i=0;i<5;i++){
            ThreadCustom hilo = new ThreadCustom(this);
            hilo.setName("hilo "+i);
            hilo.start();
        }
    }

    public void addStr(String hiloString, List<String> listaCadenas){

    }

    @Override
    public void finished(String finalizacion) {
        System.out.println(finalizacion );
    }
}
