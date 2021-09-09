package create;

public class FirstThreadTest extends Thread{

    int i = 0;

    public FirstThreadTest(String name, int i){
        this.i = i;
        this.setName(name);
    }

    @Override
    public void run() {
        for(int j = 0; j < 10; j++){
            i++;
            System.out.println(Thread.currentThread().getName() + ":" +i);
        }
    }

    public static void main(String[] args) {

        System.out.println("activeCount:" + Thread.activeCount());
        int i = 1;
        //1
        new FirstThreadTest("a",i).start();
        new FirstThreadTest("b",i).start();
        new FirstThreadTest("c",i).start();

        System.out.println("activeCount:" + Thread.activeCount());

        //2.1
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
        //2.2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        System.out.println("activeCount:" + Thread.activeCount());
        //3
        new Thread(new FirstThreadTest("e",100)).start();
    }
}
