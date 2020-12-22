public class Ch02_09 {
    public static void main(String[] args) {
        Car car = new Car(10 , 50);
        car.fillTheTank(60)
                .move(10)
                .move(1000)
                .showLocation()
                .fillTheTank(30)
                .move(-100)
                .showLocation()
                .showGasLevel();
    }
}

class Car {
    private final double cop;
    private final double tankVolume;
    private double location;
    private double gasoline;
    private double tank;


    public Car(double cop, double tankVolume) {
        this.cop = cop;
        this.tankVolume = tankVolume;
    }

    public Car fillTheTank(double litres) {
        if (litres <= 0) {
            System.out.println("You can't fill in this amount of gasoline.");
        } else if (litres > tankVolume - tank) {
            System.out.printf("Filling in just %.2f litres of gasoline cause the tank is full (%.2f litres).\n", tankVolume - tank, tankVolume);
            tank = tankVolume;
        } else {
            tank += litres;
            System.out.printf("Filled in the tank. Current volume is %.2f\n", tank);
        }
        return this;
    }

    public Car move(double distance) {
        if (tank * cop < distance) {
            System.out.printf("You've ran out of gas while passed %.2f km of %.2f.\n", tank * cop, distance);
            location += distance > 0 ? tank * cop : -tank * cop;
            tank = 0;
        } else {
            System.out.printf("You passed %.2f km.\n", distance);
            tank -= Math.abs(distance) / cop;
            location += distance;
        }
        return this;
    }

    public Car showLocation() {
        System.out.printf("The current location is %.2fkm away from the start point.\n", location);
        return this;
    }

    public Car showGasLevel() {
        System.out.printf("There is %.2f litres of gas left.\n", tank);
        return this;
    }

}

