import java.util.ArrayList;

public class Worker implements Runnable{

    private final int[] mainArr;
    private final ArrayList<Integer> oddArr;
    private final ArrayList<Integer> evenArr;

    Worker(int[] mainArr, ArrayList<Integer> oddArr, ArrayList<Integer> evenArr){
        this.mainArr = mainArr;
        this.oddArr = oddArr;
        this.evenArr = evenArr;
    }

    @Override
    public void run() {
        for(int elem:mainArr){
            if(elem % 2 == 1)
                oddArr.add(elem);
            else
                evenArr.add(elem);
        }
    }
}
