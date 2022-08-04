package Homework4.Basic;

public class Duck implements Flying {
    private final boolean isInjured;

    public Duck(boolean isInjured) {
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
