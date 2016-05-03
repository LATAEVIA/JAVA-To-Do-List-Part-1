import java.util.ArrayList;

public class Category {
  // private String mName;
  private static ArrayList<Category> instances = new ArrayList<Category>();
  // private int mId;

  public Category(String name) {
    // mName = name;
    // instances.add(this);
    // mId = instances.size();
  }

  public static void clear() {
    instances.clear();
  }
}
