package pl.javastart.taskmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskFilters {
    private boolean archived;
    private Status status;
    private Category category;
    private User user;
    private List<String> statusFilters = new ArrayList<>();

    public TaskFilters(boolean archived, Status status, Category category, User user) {
        this.archived = archived;
        this.status = status;
        this.category = category;
        this.user = user;
    }

    public String forStatus(){
        statusFilters.clear();
        if (archived){
            statusFilters.add("archived=" + String.valueOf(archived));
        }
        if(category != null){
            statusFilters.add("category=" + category.name());
        }
        if(user != null){
            statusFilters.add("user=" + user.name());
        }
        return String.join("&", statusFilters);
    }

    public String forCategory(){
        statusFilters.clear();
        if (archived){
            statusFilters.add("archived=" + archived);
        }
        if(status != null){
            statusFilters.add("status=" + status.name());
        }
        if(user != null){
            statusFilters.add("user=" + user.name());
        }
        return String.join("&", statusFilters);

    }

    public String forUser(){
        statusFilters.clear();
        if (archived){
            statusFilters.add("archived=" + archived);
        }
        if(status != null){
            statusFilters.add("status=" + status.name());
        }
        if(category != null){
            statusFilters.add("category=" + category.name());
        }
        return String.join("&", statusFilters);
    }
}
