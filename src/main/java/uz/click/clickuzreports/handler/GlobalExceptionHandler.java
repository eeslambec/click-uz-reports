package uz.click.clickuzreports.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.click.clickuzreports.dto.response.CustomResponseEntity;
import uz.click.clickuzreports.exception.InvalidArgumentException;
import uz.click.clickuzreports.exception.NotFoundException;
import uz.click.clickuzreports.exception.NullOrEmptyException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public CustomResponseEntity<?> handleNotFoundException(NotFoundException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }
    @ExceptionHandler(NullOrEmptyException.class)
    public CustomResponseEntity<?> handleNullOrEmptyException(NullOrEmptyException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }
    @ExceptionHandler(InvalidArgumentException.class)
    public CustomResponseEntity<?> handleInvalidArgumentException(InvalidArgumentException e){
        return CustomResponseEntity.badRequest(e.getMessage());
    }
}
