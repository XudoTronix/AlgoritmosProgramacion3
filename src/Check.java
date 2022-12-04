import java.util.Comparator;

class Check implements Comparator<int[]> {
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[2], o2[2]);
    }
}