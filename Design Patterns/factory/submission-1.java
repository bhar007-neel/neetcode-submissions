// ==========================================
// FACTORY METHOD PATTERN - JAVA
// ==========================================
//
// MOTIVE:
// We want to create objects like Car, Bike, and Truck,
// but we don't want the main/client code to directly worry about:
//
//      new Car()
//      new Bike()
//      new Truck()
//
// Instead, we create special "factory" classes.
//
// The factory's job is:
//      "You tell me what kind of factory I am,
//       and I will create the correct object for you."
//
// This separates:
//      OBJECT CREATION
// from
//      OBJECT USAGE
interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}
// ==========================================
// 5. VEHICLE FACTORY
// ==========================================

// THIS IS THE IMPORTANT PART.
//
// We now create another interface.
//
// VehicleFactory says:
//
// "Every factory must know how to create a Vehicle."
//
// But notice:
//
// We DO NOT say:
//      return new Car();
//
// here.
//
// Why?
//
// Because this parent factory does not know
// what specific Vehicle should be created.
//
// The CHILD factories will decide.
//
// This is the core idea of Factory Method
abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    // Write your code here
     @Override
    public Vehicle createVehicle(){
        return new Car();
    }
}


class BikeFactory extends VehicleFactory {
    // Write your code here
     @Override
    public Vehicle createVehicle(){
        return new Bike();
    }
}

class TruckFactory extends VehicleFactory {
    // Write your code here
     @Override
    public Vehicle createVehicle(){
        return new Truck();
    }
}

