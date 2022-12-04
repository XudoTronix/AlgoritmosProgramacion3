import java.util.Arrays;
import java.util.Scanner;

public class Kruskal extends Grafo{
    int costo;
    boolean ciclo;

    public Kruskal(int v) {
        super(v);
        costo = 0;
        ciclo = false;
    }

    void Kruskal(int[][] arcos){
        for(int i = 0; i<arcos.length; i++){
            int a = arcos[i][0], b = arcos[i][1], w = arcos[i][2];
            if(a==b)	continue;
            agregarArco(a, b);
            if(!esCiclo()){
                System.out.println(a+" "+b+" "+w+" added");
                costo+=w;
            }else{
                vertice[a].adj.removeLast();
                vertice[b].adj.removeLast();
            }
        }
        System.out.println("Cost: "+costo);
    }

    void resetear(){
        for(int i = 0; i<v; i++)
            vertice[i].visitado = 0;
        ciclo = false;
    }

    boolean esCiclo(){
        resetear();
        for(int i=0;i<v && !ciclo;i++){
            if(vertice[i].visitado==0)
                DFSVisit(i);
        }
        return ciclo;
    }

    void DFSVisit(int u){
        vertice[u].visitado=1;
        for(Vertice v: vertice[u].adj){
            if(ciclo)	break;
            if(v.visitado==2){
                ciclo = true;
                return;
            }
            if(v.visitado==0){
                DFSVisit(v.data);
            }
        }
        vertice[u].visitado=2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] arcos = new int[e][3];
        //arcos desde a[0] hasta a[1] con peso a[2]
        for(int i = 0; i<e; i++){
            int a = sc.nextInt(), b = sc.nextInt(), p = sc.nextInt();
            arcos[i][0] = a;
            arcos[i][1] = b;
            arcos[i][2] = p;
        }
        Arrays.sort(arcos,new Check());
        Kruskal g = new Kruskal(v);
        g.Kruskal(arcos);
        sc.close();
    }
}
/*
EJEMPLO
5 8
0 1 1
0 2 4
0 4 2
2 4 3
1 4 3
3 1 3
3 2 1
3 4 2
*/
