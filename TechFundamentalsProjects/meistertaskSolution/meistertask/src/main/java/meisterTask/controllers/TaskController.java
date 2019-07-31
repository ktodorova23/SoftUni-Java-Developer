package meisterTask.controllers;

import meisterTask.bindingModels.TaskBindingModel;
import meisterTask.entities.Task;
import meisterTask.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public ModelAndView index() {
        List<Task> openTasks = this.taskRepository.findAllByStatus("Open");
        List<Task> inProgressTasks = this.taskRepository.findAllByStatus("In Progress");
        List<Task> finishedTasks = this.taskRepository.findAllByStatus("Finished");

        return new ModelAndView("base-layout")
                .addObject("view", "task/index")
                .addObject("openTasks", openTasks)
                .addObject("inProgressTasks", inProgressTasks)
                .addObject("finishedTasks", finishedTasks);
    }

    @GetMapping("/create")
    public ModelAndView create(ModelAndView modelAndView) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/create");

        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Task task) {
        this.taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(ModelAndView modelAndView,
                             @PathVariable(value = "id") Integer id) {
        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/edit");
        modelAndView.addObject("task", this.taskRepository.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(TaskBindingModel taskBindingModel,
                       @PathVariable(value = "id") Integer id) {
        Task taskToEdit = this.taskRepository.findById(id).get();
        taskToEdit.setTitle(taskBindingModel.getTitle());
        taskToEdit.setStatus(taskBindingModel.getStatus());
        this.taskRepository.save(taskToEdit);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(ModelAndView modelAndView,
                               @PathVariable(value = "id") Integer id) {

        modelAndView.setViewName("base-layout");
        modelAndView.addObject("view", "task/delete");
        modelAndView.addObject("task", this.taskRepository.findById(id).get());

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public String delete(Task task) {
        this.taskRepository.delete(task);

        return "redirect:/";
    }
}
