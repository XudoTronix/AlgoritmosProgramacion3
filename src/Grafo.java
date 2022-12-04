import java.util.LinkedList;

public class Grafo {
    int v;
    Vertice[] vertice;

    public Grafo(int v){
        this.v=v;
        vertice = new Vertice[v];
        for(int i = 0; i<v; i++){
            vertice[i] = new Vertice(i);
        }
    }

    void agregarArco(int a, int b){
        vertice[a].adj.add(vertice[b]);
        if(a!=b)
            vertice[b].adj.add(vertice[a]);
    }

    void imprimirLista(LinkedList<Vertice> l){
        for(Vertice v: l){
            System.out.print(v.data+" ");
        }
        System.out.println();
    }

    void imprimirListaAdyasente(){
        for(Vertice v: vertice){
            System.out.print("Vertex "+v.data+": ");
            imprimirLista(v.adj);
        }
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.agregarArco(0, 1);
        g.agregarArco(1, 2);
        g.agregarArco(2, 0);
        g.agregarArco(3, 3);
        g.agregarArco(4, 2);
        g.imprimirListaAdyasente();
    }
}
