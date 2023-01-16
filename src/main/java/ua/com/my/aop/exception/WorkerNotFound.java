package ua.com.my.aop.exception;

public class WorkerNotFound extends RuntimeException {
    private static final String message = "Worker was not found";
    public WorkerNotFound() {
        super(message);
    }
}
