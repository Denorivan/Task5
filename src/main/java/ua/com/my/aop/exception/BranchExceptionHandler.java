package ua.com.my.aop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class BranchExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<BranchIncorrectData> handlerException(BranchNotFound exception) {
        BranchIncorrectData expData = new BranchIncorrectData();
        expData.setInfo(exception.getMessage());
        return new ResponseEntity<>(expData, HttpStatus.NOT_FOUND);
    }
}
