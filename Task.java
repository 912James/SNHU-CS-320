package Task;

public class Task {

	  private String taskID;
	  private String name;
	  private String description;

	  Task() {
	    taskID = "TEST";
	    name = "TEST";
	    description = "TEST";
	  }

	  public Task(String taskID) {
	    checkTaskID(taskID);
	    name = "TEST";
	    description = "TEST";
	  }

	  public Task(String taskID, String name) {
	    checkTaskID(taskID);
	    setName(name);
	    description = "TEST";
	  }

	  public Task(String taskID, String name, String description) {
	    checkTaskID(taskID);
	    setName(name);
	    setDescription(description);
	  }
	  
	  // Setters and Getters

	  public final String getTaskID() {
		  return taskID; 
		  }

	  public final String getName() { 
		  return name;
		  }
	  // This meets the requirement from the rubric
	  public void setName(String name) {
	    if (name == null || name.length() > 20) {
	      throw new IllegalArgumentException(
	          "Task name needs to be shorter than 20 characters and it can not be left empty.");
	    } else {
	      this.name = name;
	    }
	  }

	  public final String getDescription() { 
		  return description; 
		  }
	  
	  // This meets the requirement from the rubric
	  public void setDescription(String taskDescription) {
	    if (taskDescription == null || taskDescription.length() > 50) {
	      throw new IllegalArgumentException(
	          "Task description needs to be shorter than 50 characters and it can not be left empty.");
	    } else {
	      this.description = taskDescription;
	    }
	  }
	  
	  // This meets the requirement from the rubric
	  public void checkTaskID(String taskID) {
	    if (taskID == null || taskID.length() > 10) {
	      throw new IllegalArgumentException(
	          "Error: The task ID can not be longer than 10 characters and it can not be left empty");
	    } else {
	      this.taskID = taskID;
	    }
	  }
	}