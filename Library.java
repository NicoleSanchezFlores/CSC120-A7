import java.util.Hashtable;

// Library class representing a library building
public class Library extends Building {

  // Hashtable to store titles and their availability
  private Hashtable<String, Boolean> collection;

  // Constructor to create a new Library instance
  public Library(String name, String address, int nFloors) {
    // Call the superclass constructor (Building)
    super(name, address, nFloors);
    // Initialize the collection Hashtable
    this.collection = new Hashtable<>();
  }

  // Method to add a new title to the library collection
  public void addTitle(String title) {
    // Check if the title is already in the collection
    if (collection.containsKey(title)) {
      // If title already exists, throw an exception
      throw new RuntimeException(title + " is already in the collection");
    }
    // Add the title to the collection with availability status true (available)
    collection.put(title, true);
  }

  // Method to remove a title from the library collection
  public String removeTitle(String title) {
    // Check if the title exists in the collection
    if (!collection.containsKey(title)) {
      // If title doesn't exist, throw an exception
      throw new RuntimeException(title + " is not in the collection");
    }
    // Remove the title from the collection and return it
    collection.remove(title);
    return title;
  }

  // Method to mark a title as checked out
  public void checkOut(String title) {
    collection.replace(title, true, false);
  }

  // returnned
  public void returnBook(String title) {
    collection.replace(title, false, true);
  }

  // does it contrai title
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  // is title avzilbke for checking out
  public boolean isAvailable(String title) {
    return collection.getOrDefault(title, false);
  }

  // Overriding tfor library-specific options
  @Override
  public void showOptions() {
    super.showOptions(); // Show superclass options
    System.out.println(" + addTitle(String title)"); // title addig
    System.out.println(" + removeTitle(String title)"); // removig title
    System.out.println(" + checkOut(String title)"); // Additional option for checking out a book
    System.out.println(" + returnBook(String title)"); // Additional option for returning a book
  }

  // Overriding the goToFloor method to reflect library-specific behavior
  @Override
  public void goToFloor(int n) {
    System.out.println("Can't move between floors here. "); // Library-specific behavior
  }
}
