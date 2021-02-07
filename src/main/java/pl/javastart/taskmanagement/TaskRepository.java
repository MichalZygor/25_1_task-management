package pl.javastart.taskmanagement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByArchivedAndStatusAndCategoryAndUser(Boolean archived, Status status, Category category, User user);

    List<Task> findAllByArchivedAndStatusAndCategory(Boolean archived, Status status, Category category);

    List<Task> findAllByArchivedAndStatus(Boolean archived, Status status);

    List<Task> findAllByArchived(Boolean archived);

    List<Task> findAllByStatusAndCategoryAndUser(Status status, Category category, User user);

    List<Task> findAllByStatusAndCategory(Status status, Category category);

    List<Task> findAllByStatus(Status status);

    List<Task> findAllByStatusAndUser(Status status, User user);

    List<Task> findAllByCategoryAndUser(Category category, User user);

    List<Task> findAllByCategory(Category category);

    List<Task> findAllByUser(User user);

    List<Task> findAllByArchivedAndCategory(Boolean archived, Category category);

    List<Task> findAllByArchivedAndUser(Boolean archived, User user);

}
