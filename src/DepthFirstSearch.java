public class DepthFirstSearch extends Grafo{
    int tiempo;

    public DepthFirstSearch(int v) {
        super(v);
        tiempo=0;
    }

    void DFS(){
        tiempo=0;
        for(int i=0;i<v;i++){
            if(vertice[i].visitado==0)
                DFSVisita(i);
        }
    }

    void DFSVisita(int u){
        tiempo++;
        vertice[u].tiempoVisita=tiempo;
        vertice[u].visitado=1;
        for(Vertice v: vertice[u].adj){
            if(v.visitado==0){
                v.padre=vertice[u];
                DFSVisita(v.data);
            }
        }
        tiempo++;
        vertice[u].tiempoFinalizado=tiempo;
        vertice[u].visitado=2;
    }

    void printVeces(){
        for(Vertice v: vertice){
            System.out.printf("Vertice: %2d Empieza:%2d Termina:%2d\n",v.data,
                    vertice[v.data].tiempoVisita, vertice[v.data].tiempoFinalizado);
        }
    }

    public static void main(String[] args){
        DepthFirstSearch g = new DepthFirstSearch(5);
        g.agregarArco(0, 1);
        g.agregarArco(1, 2);
        g.agregarArco(2, 0);
        g.agregarArco(3, 3);
        g.agregarArco(4, 2);
        g.DFS();
        g.printVeces();

    }
}
