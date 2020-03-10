package logging;

public class LogicClass {
    private void methodPrivate(){
        System.out.println("Private method");
    }

    public void methodPublic(){
        System.out.println("Public method and: ");
        methodPrivate();
    }
}
