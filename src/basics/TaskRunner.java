package basics;

import java.util.ArrayList;

public class TaskRunner {

    public static void main(String[] args) {
        ArrayList<Task> tasks = createTasks();
        runTasks(tasks);
    }

    private static ArrayList<Task> createTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(new CharFrequencyApp());
        tasks.add(new StudentApp());
        return tasks;
    }

    private static void runTasks(ArrayList<Task> tasks) {
        for(Task task: tasks) {
            task.run();
        }
    }

}
