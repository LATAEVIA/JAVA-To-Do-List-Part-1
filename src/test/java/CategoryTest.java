import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {
  @After
  public void tearDown() {
    Category.clear();
    Task.clear();
  }

  @Test
    public void category_instantiatesCorrectly_true() {
    Category testCategory = new Category("Home");
    assertEquals(true, testCategory instanceof Category);
  }

  @Test
  public void getName_categoryInstantiatesWithName_Home() {
    Category testCategory = new Category("Home");
    assertEquals("Home", testCategory.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCategory_true() {
    Category firstCategory = new Category("Home");
    Category secondCategory = new Category("Work");
    assertTrue(Category.all().contains(firstCategory));
    assertTrue(Category.all().contains(secondCategory));
  }

  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Category testCategory = new Category("Home");
    Category.clear();
    assertEquals(0, Category.all().size());
  }

  @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Category testCategory = new Category("Home");
    assertEquals(1, testCategory.getId());
  }

  @Test
  public void find_returnsCategoryWithSameId_secondCategory() {
    Category firstCategory = new Category("Home");
    Category secondCategory = new Category("Work");
    assertEquals(Category.find(secondCategory.getId()), secondCategory);
    //why wont "Work" work in place of secondCategory?
    //solution - I was asking for a string when the other paremeter returns an object. This will fix it --> assertEquals(Category.find(secondCategory.getId()).getName(), "Work"); 
  }

  @Test
  public void getTasks_initiallyReturnsEmptyList_ArrayList() {
    Category testCategory = new Category("Home");
    assertEquals(0, testCategory.getTasks().size());
  }

  @Test
  public void addTask_addsTaskToList_true() {
    Category testCategory = new Category("Home");
    Task testTask = new Task("Mow the lawn");
    testCategory.addTask(testTask);
    assertTrue(testCategory.getTasks().contains(testTask));
  }
}


// git commit -m "add working test in -categoryTest- with all necessary code to make the .getTasks method on mTasks_Array start off empty"
