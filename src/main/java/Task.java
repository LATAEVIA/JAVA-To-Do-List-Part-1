import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task {
  private String mDescription;
  private boolean mCompleted;
  private LocalDateTime mCreatedAt;
  private static ArrayList<Task> instances = new ArrayList<Task>();
  //By making it a static variable, we are associating it with the class itself rather than with an instance of the class.
  private int mId;

  public Task(String description) {
    mDescription = description;
    mCompleted = false;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public static ArrayList<Task> all() {
    return instances;
    //Because it is static, we call it on the Task class itself rather than on an instance of the class. So we write Task.all() rather than myTask.all() or newTask.all()
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Task find(int id) {
    try {
      //Using try, we tell Java to run a block of code, and then we can tell Java to catch specific exceptions and run some other code instead.
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }
}
