package ua.com.my.aop.exception;

public class BranchNotFound extends RuntimeException {
    private static final String message = "Branch was not found";
    public BranchNotFound() {
        super(message);
    }
}
