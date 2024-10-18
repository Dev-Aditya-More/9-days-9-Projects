public class Task {

    private final String title;
    private boolean isCompleted;
    private final int taskID;

    public Task(int taskID, String title) {

        this.taskID = taskID;
        this.title = title;
        this.isCompleted = false; // initially

    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public int getTaskId() {
        return taskID;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return taskID + ". " + title + " [" + (isCompleted ? "Completed" : "Pending") + "]";
    }

}
