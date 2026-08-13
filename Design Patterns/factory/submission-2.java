// ==========================================
// FACTORY METHOD PATTERN - JAVA
// ==========================================
// The main purpose of Factory Method is to keep object creation separate from the code that uses the object.
///// Your main code can just ask factory.createVehicle() without caring whether it creates a Car, Bike, Truck, or future Airplane.
// So later, you can add new vehicle types with their own factories without changing the existing client code.
// In short: less hard-coding, easier to extend, and cleaner object creation.
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

