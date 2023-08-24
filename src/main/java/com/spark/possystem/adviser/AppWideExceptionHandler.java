package com.spark.possystem.adviser;

import com.spark.possystem.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

        @ExceptionHandler(ClassNotFoundException.class)
        public ResponseEntity<StandardResponse> handleNotFoundException(ClassNotFoundException e){
            return new ResponseEntity<>(
                    new StandardResponse(
                            404,
                            e.getMessage(),
                            e.getException()
                    ), HttpStatus.NOT_FOUND
            );
        }
}
