package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

  private String ID, name, description;
  private String tooLongID, tooLongName, tooLongDescription;

  @BeforeEach
  void startingVariables() { 
    ID = "123456789";
    name = "Replace light bulb.";
    description = "The task object shall have a required description.";
    tooLongID = "12345678987654321";
    tooLongName = "Replacing a light bulb with a new energy efficient light bulb.";
    tooLongDescription ="In order to replace the light bulb, I will need a ladder, from there I replace the lightbult with a new energy effiecient light bulb.";
  }

  @Test
  void getTaskIDTest() {
    Task task = new Task(ID);
    Assertions.assertEquals(ID, task.getTaskID());
  }

  @Test
  void getNameTest() {
    Task task = new Task(ID, name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void getDescriptionTest() {
    Task task = new Task(ID, name, description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void setNameTest() {
    Task task = new Task();
    task.setName(name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void setDescriptionTest() {
    Task task = new Task();
    task.setDescription(description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void TaskIDTooLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(tooLongID));
  }

  @Test
  void setTooLongNameTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(tooLongName));
  }

  @Test
  void setTooLongDescriptionTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(tooLongDescription));
  }

  @Test
  void TaskIDNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(null));
  }

  @Test
  void TaskNameNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(null));
  }

  @Test
  void TaskDescriptionNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(null));
  }
}