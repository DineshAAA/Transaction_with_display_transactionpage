package Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionExceptionController {
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<error> handleIllegalArgumentException(){

        error er = new error(400,"Illegal Data");
        return new ResponseEntity<error>(er,HttpStatus.BAD_REQUEST);
    }
}
