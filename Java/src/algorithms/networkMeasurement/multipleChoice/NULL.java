package algorithms.networkMeasurement.multipleChoice;

/**
 * Created by thpffcj on 2020/1/17.
 */
public class NULL {

    public static void print(){
        System.out.println("MTDP");
    }

    public static void main(String[] args) {
        try{
            ((NULL)null).print();
        }catch(NullPointerException e){
            System.out.println("NullPointerException");
        }
    }
}
