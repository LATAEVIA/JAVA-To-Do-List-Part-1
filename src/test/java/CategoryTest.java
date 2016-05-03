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


}

// git commit -m "add forth working test in -categoryTest- with all necessary code to make the .clear method on Category empth all categories from the list"
