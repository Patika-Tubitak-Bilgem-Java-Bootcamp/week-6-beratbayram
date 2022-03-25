import java.util.ArrayList;

public class Main {
    public static void fillFromTo(int[] arr, int offset) {
        for (int i = 0; i < 2500; i++) {
            arr[i] = i + offset;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> oddList = new ArrayList<Integer>();
        ArrayList<Integer> evenList = new ArrayList<Integer>();

        Worker[] workers = new Worker[4];

        int[] arr_0000_2499 = new int[2500];
        fillFromTo(arr_0000_2499, 0);
        workers[0] = new Worker(arr_0000_2499, oddList, evenList);

        int[] arr_2500_4999 = new int[2500];
        fillFromTo(arr_2500_4999, 2500);
        workers[1] = new Worker(arr_2500_4999, oddList, evenList);

        int[] arr_5000_7499 = new int[2500];
        fillFromTo(arr_5000_7499, 5000);
        workers[2] = new Worker(arr_5000_7499, oddList, evenList);

        int[] arr_7500_9999 = new int[2500];
        fillFromTo(arr_7500_9999, 7500);
        workers[3] = new Worker(arr_7500_9999, oddList, evenList);

        Thread[] threads = {
                new Thread(workers[0]),
                new Thread(workers[1]),
                new Thread(workers[2]),
                new Thread(workers[3])
        };

        for(Thread thread:threads){
            thread.start();
        }

        // Wait till all threads are completed
        for(Thread thread:threads){
            thread.join();
        }

        System.out.println(oddList);
        System.out.println(evenList);
    }
}
