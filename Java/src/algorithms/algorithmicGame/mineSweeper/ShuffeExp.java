package algorithms.algorithmicGame.mineSweeper;

/**
 * Created by Thpffcj on 2017/10/11.
 */
public class ShuffeExp {

    private int N;
    private int n, m;

    public ShuffeExp(int N, int n, int m) {

        this.N = N;
        this.n = n;
        this.m = m;
    }

    public void run() {

        int freq[] = new int[n];

        int arr[] = new int[n];
        for (int i = 0; i < N; i++) {
            reset(arr);
            shuffle(arr);
            for (int j = 0; j < n; j++) {
                freq[j] += arr[j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " : " + (double)freq[i]/N);
        }
    }

    private void reset(int[] arr) {

        for (int i = 0; i < m; i++ ) {
            arr[i] = 1;
        }

        for (int i = m; i < n; i++) {
            arr[i] = 0;
        }
    }

    private void shuffle(int[] arr) {

        for (int i = n-1; i >= 0; i--) {
            // 从[0,i]区间里随机选择元素
            int x = (int)(Math.random() * (i+1));
            swap(arr, i, x);
        }
    }

    private void swap(int[] arr, int x, int y){
       int t = arr[x];
       arr[x] = arr[y];
       arr[y] = t;
    }

    public static void main(String[] args) {

        int N = 1000000;
        int n = 10;
        int m = 5;

        ShuffeExp exp = new ShuffeExp(N, n, m);
        exp.run();
    }
}
