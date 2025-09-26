package MiniProject;

public abstract class AbstractRoutine implements RoutineContract {
    private String name; //루틴 이름
    private boolean done;

    public AbstractRoutine(String name) {
        this.name = name;
        this.done = false;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean isDone() {
        return done;
    }
    @Override
    public void setDone(boolean done) {
        this.done = done;
    }
}
