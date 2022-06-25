import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
public class NewExecutor {
    private final int maxThreads;
    private final List<MyFunction> listOfTasks ;
    private List<NewThread> listOfThreads;
    NewExecutor(int maxThreads, List<MyFunction> listOfTasks) {
        this.maxThreads = maxThreads;
        this.listOfTasks = listOfTasks;
        if(listOfTasks.size() == 0) {System.exit(1);}
        if(maxThreads == 0) {System.exit(1);}
    }
    public synchronized void execute() throws InterruptedException {
        int countOfThreads ;
        int thread = 1;
        while(!listOfTasks.isEmpty()) {
            countOfThreads = Math.min(listOfTasks.size(), maxThreads);
            listOfThreads = new LinkedList<>();
            System.out.println("Thread - " + thread);
            thread++;
            for (int i = 0; i < countOfThreads; i++) {
                Thread.sleep(500);
                NewThread newThread = new NewThread(listOfTasks);
                try {
                    Future futureResult = newThread.call();
                    System.out.println(futureResult.get());
                } catch (Exception exception) {
                    System.out.println(exception);
                }
                listOfThreads.add(newThread);
            }
        }
        shutdown();
    }
    private int shutdown(){
        listOfThreads.clear();
        listOfTasks.clear();
        System.gc();
        return 0;
    }
}