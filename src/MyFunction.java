public class MyFunction  {
    private boolean isLocked;
    private final String value;
    MyFunction(String value){
        this.value = value;
        this.isLocked = false;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void setLocked (){
        this.isLocked = true;
    }
    public String getValue(){
        return value;
    }
    public <T> String apply(T t) {
        return t + "\n------------ target done ------------";
    }
}
