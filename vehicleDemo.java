class Vehicle {
    void start(){
        System.out.println("Vehicle is Starting");
    }
}


class Car extends Vehicle{
    void stop(){
        System.out.println("Car is Stop");
    }
}


class Bus extends Car{
    void move(){
        System.out.println("Bus is moveing");
    }
}

public class vehicleDemo{
public static void main(String[] args) {
    Bus b = new Bus();
    b.start();
    b.stop();
    b.move();
}
}
