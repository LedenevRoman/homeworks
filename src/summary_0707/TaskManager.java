package summary_0707;

import java.util.*;

public class TaskManager {
    private final NavigableMap<Integer, List<Task>> map = new TreeMap<>();

    public TaskManager() {
    }

    public void addTask(int priority, Task task) {
        List<Task> list = new ArrayList<>();
        list.add(task);
        map.merge(priority, list, (oldValue, newValue) -> {
            oldValue.addAll(newValue);
            return oldValue;
        });
    }

    public Task getMostPriorityTask() {
        Task task = map.lastEntry()
                .getValue()
                .remove(0);
        Integer key = map.lastKey();
        if (map.lastEntry().getValue().isEmpty()) {
            map.remove(key);
        }
        return task;
    }

    public NavigableMap<Integer, List<Task>> getMap() {
        return map;
    }
}
