package TaskService; 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

  private String ID, name, description;
  private String tooLongName, tooLongDescription;

  @BeforeEach
  void startingVariables() { 
    ID = "123456789";
    name = "Replace light bulb.";
    description = "The task object shall have a required description.";
    tooLongName = "Replacing a light bulb with a new energy efficient light bulb.";
    tooLongDescription ="In order to replace the light bulb, I will need a ladder, from there I replace the lightbult with a new energy effiecient light bulb.";
  }

  @Test
  void newTaskTest() {
    TaskService service = new TaskService();
    service.newTask();
    Assertions.assertNotNull(service.getTaskList().get(0).getTaskID());
    Assertions.assertNotEquals("INITIAL",
                               service.getTaskList().get(0).getTaskID());
  }

  @Test
  void newTaskNameTest() {
    TaskService service = new TaskService();
    service.newTask(name);
    Assertions.assertNotNull(service.getTaskList().get(0).getName());
    Assertions.assertEquals(name, service.getTaskList().get(0).getName());
  }

  @Test
  void newTaskDescriptionTest() {
    TaskService service = new TaskService();
    service.newTask(name, description);
    Assertions.assertNotNull(service.getTaskList().get(0).getDescription());
    Assertions.assertEquals(description,
                            service.getTaskList().get(0).getDescription());
  }

  @Test
  void newTaskTooLongNameTest() {
    TaskService service = new TaskService();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> service.newTask(tooLongName));
  }

  @Test
  void newTaskTooLongDescriptionTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class,
                 () -> service.newTask(name, tooLongDescription));
  }

  @Test
  void newTaskNameNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
  }

  @Test
  void newTaskDescriptionNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class,
                 () -> service.newTask(name, null));
  }

  @Test
  void deleteTaskTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertEquals(1, service.getTaskList().size());
    service.deleteTask(service.getTaskList().get(0).getTaskID());
    assertEquals(0, service.getTaskList().size());
  }

  @Test
  void deleteTaskNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertEquals(1, service.getTaskList().size());
    assertThrows(Exception.class, () -> service.deleteTask(ID));
    assertEquals(1, service.getTaskList().size());
  }

  @Test
  void updateNameTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    service.updateName(service.getTaskList().get(0).getTaskID(), name);
    assertEquals(name, service.getTaskList().get(0).getName());
  }

  @Test
  void updateDescriptionTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    service.updateDescription(service.getTaskList().get(0).getTaskID(),
                              description);
    assertEquals(description, service.getTaskList().get(0).getDescription());
  }

  @Test
  void updateNameNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertThrows(Exception.class, () -> service.updateName(ID, name));
  }

  @Test
  void updateDescriptionNotFoundTest() throws Exception {
    TaskService service = new TaskService();
    service.newTask();
    assertThrows(Exception.class,
                 () -> service.updateDescription(ID, description));
  }
}
