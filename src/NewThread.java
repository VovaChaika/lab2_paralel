import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;



public class NewThread implements Callable {
    private final List<MyFunction> listOfTasks ;
    NewThread(List<MyFunction> listOfTasks ){
        this.listOfTasks = listOfTasks;
    }
    @Override
    public Future call(){
        MyFunction functionToDo = listOfTasks.get(findNotLocked(listOfTasks));
        Callable func = () -> functionToDo.apply(functionToDo.getValue());
        FutureTask future = new FutureTask(func);
        future.run();
        listOfTasks.remove(functionToDo);
        return future;
    }
    public int findNotLocked( List<MyFunction> listOfTasks ){
        for(int i = 0; i < listOfTasks.size(); i++){
            if(!listOfTasks.get(i).isLocked()) {
                listOfTasks.get((i)).setLocked();
                return i;
            }
        }
        return 0;
    }
}
