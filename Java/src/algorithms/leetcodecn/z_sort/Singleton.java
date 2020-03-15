package algorithms.leetcodecn.z_sort;

/**
 * Created by thpffcj on 2020/3/14.
 */
public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {

    }

    public static Singleton getUniqueInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
