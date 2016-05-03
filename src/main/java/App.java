import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("tasks/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/task-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tasks", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("tasks", Task.all());
      model.put("template", "templates/tasks.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tasks", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("description");
      Task newTask = new Task(description);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/tasks/:id", (request, response) -> {
      //added the route get("tasks/:id", will be called when someone clicks to see the specifications of a particular task. The :id is used to find the individual task.
      HashMap<String, Object> model = new HashMap<String, Object>();
      Task task = Task.find(Integer.parseInt(request.params(":id")));
      //request.params(":id") retrieves the value passed in the :id parameter. (It gets this dynamic portion (:id) from the URL. So if the URL is /tasks/5 then request.params(":id") will be "5".)
      //use our Task.find() method to retrieve the task whose mId is the same as :id. We then save it into the variable task and put it into our model in order to pass it to the task.vtl template.
      model.put("task", task);
      model.put("template", "templates/task.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}

// import java.util.Map;
// import java.util.HashMap;
// import spark.ModelAndView;
// import spark.template.velocity.VelocityTemplateEngine;
// import static spark.Spark.*;
// import java.util.ArrayList;
//
// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     String layout = "templates/layout.vtl";
//
//     get("/", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//       model.put("tasks", request.session().attribute("tasks"));
//       model.put("template", "templates/index.vtl");
//       return new ModelAndView(model, layout);
//     }, new VelocityTemplateEngine());
//
//     post("/tasks", (request, response) -> {
//       Map<String, Object> model = new HashMap<String, Object>();
//
//       ArrayList<Task> tasks = request.session().attribute("tasks");
//       if (tasks == null) {
//         tasks = new ArrayList<Task>();
//         request.session().attribute("tasks", tasks);
//       }
//
//       String description = request.queryParams("description");
//       Task newTask = new Task(description);
//       tasks.add(newTask);
//
//       model.put("template", "templates/success.vtl");
//       return new ModelAndView(model, layout);
//      }, new VelocityTemplateEngine());
//
//   }
// }
