package create;

public class SecondThreadTest implements Runnable{

    int i = 0;

    public SecondThreadTest(int i){
        this.i = i;
    }

    @Override
    public void run() {
        for(int j = 0; j < 10; j++){
            i++;
            System.out.println(Thread.currentThread().getName() + ":" +i);
        }
    }

    public static void main(String[] args) {

        int i = 1;
        //3
        new Thread(new SecondThreadTest(i)).start();
    }
}
