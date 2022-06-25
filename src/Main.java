import java.util.*;

public class Main extends Thread {
    public static void main(String[] args) throws InterruptedException {
        List<MyFunction> listOfTasks = Collections.synchronizedList(new ArrayList<>());
        MyTask.task1 calculate = new MyTask.task1("2+2 = 5");
        MyTask.task2 develop = new MyTask.task2("developing a robot");
        MyTask.task3 putinVirus = new MyTask.task3("kill the virus");

        MyFunction myFunctionForMobileApp = new MyFunction(calculate.runTask());
        MyFunction myFunctionForTerminal = new MyFunction(develop.runTask());
        MyFunction myFunctionForReception = new MyFunction(putinVirus.runTask());

        listOfTasks.add(myFunctionForMobileApp);
        listOfTasks.add(myFunctionForTerminal);
        listOfTasks.add(myFunctionForReception);

        NewExecutor newExecutor = new NewExecutor( 2, listOfTasks);
        newExecutor.execute();
    }
}