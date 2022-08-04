package Homework4.Advanced2;

public class Watch implements IWatch{
    private final boolean isBroken;

    public Watch(boolean isBroken) {
        this.isBroken = isBroken;
    }

    @Override
    public void tick() throws WatchBrokenError {
        if (isBroken) {
            throw new WatchBrokenError("Часы сломались.");
        }
        System.out.println("Часы тикают.");
    }
}
