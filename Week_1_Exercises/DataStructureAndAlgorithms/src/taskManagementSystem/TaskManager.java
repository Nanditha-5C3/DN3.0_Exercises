package taskManagementSystem;

import java.util.Scanner;

public class TaskManager {

    // Task class
    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "taskId=" + taskId +
                    ", taskName='" + taskName + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }

    // TaskNode class
    public static class TaskNode {
        Task task;
        TaskNode nextNode;

        public TaskNode(Task task) {
            this.task = task;
            this.nextNode = null;
        }
    }

    // TaskManager class to manage the linked list of tasks
    private TaskNode headNode;

    public TaskManager() {
        this.headNode = null;
    }

    // Add a task to the linked list
    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        TaskNode newNode = new TaskNode(newTask);

        if (headNode == null) {
            headNode = newNode;
        } else {
            TaskNode currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        System.out.println("Task added: " + newTask);
    }

    // Search for a task by taskId
    public void searchTask(int taskId) {
        TaskNode currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.task.getTaskId() == taskId) {
                System.out.println("Task found: " + currentNode.task);
                return;
            }
            currentNode = currentNode.nextNode;
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Delete a task by taskId
    public void deleteTask(int taskId) {
        if (headNode == null) {
            System.out.println("The task list is empty.");
            return;
        }

        if (headNode.task.getTaskId() == taskId) {
            headNode = headNode.nextNode;
            System.out.println("Task with ID " + taskId + " has been deleted.");
            return;
        }

        TaskNode currentNode = headNode;
        while (currentNode.nextNode != null && currentNode.nextNode.task.getTaskId() != taskId) {
            currentNode = currentNode.nextNode;
        }

        if (currentNode.nextNode != null) {
            currentNode.nextNode = currentNode.nextNode.nextNode;
            System.out.println("Task with ID " + taskId + " has been deleted.");
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    // Traverse and display all tasks
    public void displayTasks() {
        if (headNode == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode currentNode = headNode;
        System.out.println("Tasks List:");
        while (currentNode != null) {
            System.out.println(currentNode.task);
            currentNode = currentNode.nextNode;
        }
    }

    // Main method to interact with the TaskManager
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanVar = new Scanner(System.in);

        while (true) {
            System.out.println("----- Task Management System -----");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Search Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanVar.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int taskId = scanVar.nextInt();
                    System.out.print("Enter Task Name: ");
                    String taskName = scanVar.next();
                    System.out.print("Enter Task Status: ");
                    String status = scanVar.next();
                    taskManager.addTask(taskId, taskName, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID: ");
                    int deleteId = scanVar.nextInt();
                    taskManager.deleteTask(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Task ID: ");
                    int searchId = scanVar.nextInt();
                    taskManager.searchTask(searchId);
                    break;
                case 4:
                    taskManager.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanVar.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
