package Homework4.Basic;

public class Airplane implements Flying {
    private final int countPassengers;

    public Airplane(int count) {
        this.countPassengers = count;
    }
    @Override
    public void fly() throws FlyException {
        if (countPassengers <= 0) {
            throw new FlyException("В самолете нет пассажиров. Он не полетит.");
        }
        System.out.println("Самолет летит.");
    }
}
