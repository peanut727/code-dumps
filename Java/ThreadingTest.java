import java.lang.Thread;

public class ThreadingTest {


    public static class MyThreadClass extends Thread {

        
        public void run() 
        {
            

            for (int loopCount = 1; loopCount < 5; loopCount++)
            {
              
              Thread thread = Thread.currentThread();
              System.out.println("Name of thread: " + thread.getName() + " = " + loopCount);
              
              try {
                Thread.sleep(1500);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
        }
    }

    public static void main(String [] args) throws InterruptedException
    {
        System.out.println("--Begin of thread--");
        Thread threadA = new MyThreadClass();
        threadA.setName("A");
        threadA.start();
        Thread threadB = new MyThreadClass();
        threadB.setName("B");
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("--End of Thread--");
    }
}
