package create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThirdThreadTest implements Callable<Integer> {

    int i = 0;

    public ThirdThreadTest(int i){
        this.i = i;
    }

    @Override
    public Integer call() throws Exception {
        i++;
        i++;
        i++;
        return i;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int i = 0;
        ThirdThreadTest threadTest = new ThirdThreadTest(i);
        FutureTask<Integer> futureTask = new FutureTask<>(threadTest);

        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
