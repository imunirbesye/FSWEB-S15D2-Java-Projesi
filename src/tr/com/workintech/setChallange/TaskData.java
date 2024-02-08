package tr.com.workintech.setChallange;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String assignee){
        if(assignee.equals("Ann"))
            return annsTasks;
        else if(assignee.equals("Bob"))
            return bobsTasks;
        else if(assignee.equals("Carol"))
            return carolsTasks;
        else if(assignee.equals("Unassigned"))
            return unassignedTasks;
        else if(assignee.equals("All")) {
            return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
        }
        else return null;
    }

    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> unionSet = new HashSet<>();
        for(Set<Task> s : sets){
            unionSet.addAll(s);
        }
        return unionSet;
    }

    public Set<Task> getIntersect(Set<Task> s1, Set<Task> s2){
        Set<Task> intersect = new LinkedHashSet<>(s1);
        intersect.retainAll(s2);
        return intersect;
    }

    public Set<Task> getDifference(Set<Task> s1, Set<Task> s2){
        Set<Task> difference = new LinkedHashSet<>(s1);
        difference.removeAll(s2);
        return difference;
    }
}
