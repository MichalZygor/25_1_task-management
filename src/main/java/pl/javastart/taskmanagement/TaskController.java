package pl.javastart.taskmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    private TaskRepository taskRepository;


    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) Boolean archived,
                       @RequestParam(required = false) Status status,
                       @RequestParam(required = false) Category category,
                       @RequestParam(required = false) User user) {

        List<Task> taskList = getTasksFiltered(archived, status, category, user);
        TaskFilters taskFilters = new TaskFilters(Optional.ofNullable(archived).orElse(false), status, category, user);
        model.addAttribute("taskList", taskList);
        model.addAttribute("filterList", taskFilters);
        return "home";
    }

    @PostMapping("/edit_status/{id}")
    public String taskEditStatus(@PathVariable Long id, Task task) {
        Task task1 = taskRepository.findById(id).orElseThrow();
        task1.setStatus(task.getStatus());
        taskRepository.save(task1);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String taskAdd(Model model) {

        model.addAttribute("task", new Task());
        return "add";
    }

    @PostMapping("/add")
    public String addTask(Task task) {
        task.setCreatedDate(LocalDate.now());
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String taskEdit(Model model, @PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String taskUpdate(@PathVariable Long id, Task task) {
        Task task1 = taskRepository.findById(id).orElseThrow();
        task1.setName(task.getName());
        task1.setDescription(task.getDescription());
        task1.setUser(task.getUser());
        task1.setStatus(task.getStatus());
        task1.setStartDate(task.getStartDate());
        task1.setDueDate(task.getDueDate());
        task1.setArchived(task.getArchived());
        task1.setCategory(task.getCategory());
        taskRepository.save(task1);
        return "redirect:/";
    }

    private List<Task> getTasksFiltered(Boolean archived, Status status, Category category, User user) {
        List<Task> taskList;

        if (archived != null && status != null && category != null && user != null) {
            taskList = taskRepository.findAllByArchivedAndStatusAndCategoryAndUser(archived, status, category, user);
        } else if (archived != null && status != null && category != null) {
            taskList = taskRepository.findAllByArchivedAndStatusAndCategory(archived, status, category);
        } else if (archived != null && status != null) {
            taskList = taskRepository.findAllByArchivedAndStatus(archived, status);
        } else if (archived != null && category != null) {
            taskList = taskRepository.findAllByArchivedAndCategory(archived, category);
        } else if (archived != null && user != null) {
            taskList = taskRepository.findAllByArchivedAndUser(archived, user);
        } else if (archived != null) {
            taskList = taskRepository.findAllByArchived(archived);
        } else if (status != null && category != null && user != null) {
            taskList = taskRepository.findAllByStatusAndCategoryAndUser(status, category, user);
        } else if (status != null && category != null) {
            taskList = taskRepository.findAllByStatusAndCategory(status, category);
        } else if (status != null && user != null) {
            taskList = taskRepository.findAllByStatusAndUser(status, user);
        } else if (status != null) {
            taskList = taskRepository.findAllByStatus(status);
        } else if (category != null && user != null) {
            taskList = taskRepository.findAllByCategoryAndUser(category, user);
        } else if (category != null) {
            taskList = taskRepository.findAllByCategory(category);
        } else if (user != null) {
            taskList = taskRepository.findAllByUser(user);
        } else {
            taskList = taskRepository.findAll();
        }
        return taskList;
    }
}
