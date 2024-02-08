import tr.com.workintech.setChallange.Priority;
import tr.com.workintech.setChallange.Status;
import tr.com.workintech.setChallange.Task;
import tr.com.workintech.setChallange.TaskData;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task("Sprint 15", "S15 sunum hazırla", "Bob", Priority.HIGH, Status.ASSIGNED);
        Task t2 = new Task("Sprint 16", "S15 sunum hazırla", "Bob", Priority.HIGH, Status.ASSIGNED);
        Task t3 = new Task("Sprint 17", "S15 sunum hazırla", "Ann", Priority.HIGH, Status.ASSIGNED);
        Task t4 = new Task("Sprint 18", "S15 sunum hazırla", "Ann", Priority.HIGH, Status.ASSIGNED);
        Task t5 = new Task("Sprint 19", "S15 sunum hazırla", "Carol", Priority.HIGH, Status.ASSIGNED);
        Task t6 = new Task("Sprint 20", "S15 sunum hazırla", "Carol", Priority.HIGH, Status.ASSIGNED);

        Set<Task> annsTask = new LinkedHashSet<>();
        Set<Task> bobsTask = new LinkedHashSet<>();
        Set<Task> carolsTask = new LinkedHashSet<>();
        Set<Task> unassignedTasks = new LinkedHashSet<>();

        annsTask.add(t3);
        annsTask.add(t4);

        bobsTask.add(t1);
        bobsTask.add(t2);
        bobsTask.add(t5);

        carolsTask.add(t5);
        carolsTask.add(t6);

        unassignedTasks.add(new Task("Sprint 21", "", "", Priority.LOW, Status.IN_QUEUE));

        TaskData data = new TaskData(annsTask, bobsTask, carolsTask, unassignedTasks);

        System.out.println("ALL TASKS");
        System.out.println(data.getTasks("All"));
        System.out.println("ANNS TASKS");
        System.out.println(data.getTasks("Ann"));
        System.out.println("BOBS TASKS");
        System.out.println(data.getTasks("Bob"));
        System.out.println("CAROLS TASKS");
        System.out.println(data.getTasks("Carol"));
        System.out.println("UNASSIGNED TASKS");
        System.out.println(data.getTasks("Unassigned"));
        System.out.println("BOB VE CAROL'DA OLMAYAN TASKS");
        System.out.println(data.getDifference(data.getTasks("All"), data.getUnion(bobsTask, carolsTask)));
        System.out.println("Carol ve Bob Tasks");
        System.out.println(data.getIntersect(carolsTask, bobsTask));
    }
}