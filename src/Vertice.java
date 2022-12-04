import java.util.LinkedList;

public class Vertice {
    LinkedList<Vertice> adj;
    int data;
    int visitado;//0=no, 1=visitando, 2=terminado
    Vertice padre;
    int tiempoVisita;
    int tiempoFinalizado;

    public Vertice(int data){
        this.data=data;
        visitado=0;
        padre=null;
        adj = new LinkedList<>();
        tiempoVisita=0;
        tiempoFinalizado=0;
    }
}

