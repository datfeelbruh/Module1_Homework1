package Homework4;

public class Duck implements Flying {
    boolean isInjured;

    Duck(boolean isInjured) {
        this.isInjured = isInjured;
    }
    @Override
    public void fly() throws FlyException {
        if (isInjured) {
            throw new FlyException("Утка ранена. Она не полетит.");
        }
        System.out.println("Утка летит.");
    }
}
