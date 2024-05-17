import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents; // list of residints
  private boolean hasDiningRoom; // indicates if the house has a dinning room

  // constructor for creating a new house instanse
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); // call the superclass constructor
    this.residents = new ArrayList<String>(); // makes residents list
    this.hasDiningRoom = hasDiningRoom; 
  }

  // accessor method to check if the house has a dining room
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  // accessor method to get the number of residents in the house
  public int nResidents() {
    return this.residents.size();
  }

  // method to add a new residint to the house
  public void moveIn(String name) {
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! lets say hi!");
  }

  // override toString method to provide a string representation of the house
  @Override
  public String toString() {
    String description = super.toString(); // get superclass description
    description += " There are currently " + this.nResidents() + " people living in this house."; // add residint count
    description += " This house " + (this.hasDiningRoom ? "has" : "does not have") + " an active dining room."; // add diining room info
    return description;
  }

  // override showOptions method to show specific options for House
  @Override
  public void showOptions() {
    super.showOptions(); // show superclass options
    System.out.println(" + moveIn(String name)"); // additional option for moving in
  }

  // override goToFloor method to handle moving in a house-specific way
  @Override
  public void goToFloor(int n) {
    System.out.println("Moving within a house is not applicable."); // house-specific behavoir
  }

  // another overloaded method example
  public void moveIn(String name, String occupation) {
    moveIn(name); // call the original moveIn method
    System.out.println(name + "'s job is " + occupation); // additional functionality
  }
}
