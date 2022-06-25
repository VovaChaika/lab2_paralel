public class MyTask {
    String task;
    MyTask(String task){
        this.task = task;
    }
    public String runTask() {
        return null;
    }
    public static class task1 extends MyTask {
        task1(String task) {
            super(task);
        }
        public String runTask(){
            return "This is function for task1: " + task;
        }
    }
    public static class task2 extends MyTask {
        task2(String task) {
            super(task);
        }
        public String runTask(){
            return "This is function for task2: : " + task;
        }
    }
    public static class task3 extends MyTask {
        task3(String task) {
            super(task);
        }
        public String runTask(){
            return "This is function for task3: " + task;
        }
    }
}
