package TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Task.Task;

	public class TaskService {
		
	// Array list
	private final List<Task> taskList = new ArrayList<>(); 
	
	// Creates unique ID
	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	// search for a task
  private Task searchTask(String ID) throws Exception {
    int index = 0;
    while (index < taskList.size()) {
      if (ID.equals(taskList.get(index).getTaskID())) {
        return taskList.get(index);
      }
      index++;
    }
    throw new Exception("The task does not exist!");
  }
  
  public void newTask() {
    Task task = new Task(newUniqueID());
    taskList.add(task);
  }

  public void newTask(String name) {
    Task task = new Task(newUniqueID(), name);
    taskList.add(task);
  }

  public void newTask(String name, String description) {
    Task task = new Task(newUniqueID(), name, description);
    taskList.add(task);
  }

  public void deleteTask(String ID) throws Exception {
    taskList.remove(searchTask(ID));
  }

  public void updateName(String ID, String name) throws Exception {
    searchTask(ID).setName(name);
  }

  public void updateDescription(String ID, String description)
      throws Exception {
    searchTask(ID).setDescription(description);
  }

  public List<Task> getTaskList() { return taskList; }
}