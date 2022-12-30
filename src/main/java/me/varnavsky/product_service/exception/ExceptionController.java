package me.varnavsky.product_service.exception;

import lombok.extern.slf4j.Slf4j;
import me.varnavsky.product_service.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    private static final MediaType MEDIA_TYPE = new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8);

    @ExceptionHandler({IntegrationException.class})
    public ResponseEntity<ResponseWrapper<Void>> handleIntegrationException(Exception exception) {
        printStackTrace(exception);
        return getBaseResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseWrapper.failureOf(exception));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ResponseWrapper<Void>> handleException(Exception exception) {
        printStackTrace(exception);
        return getBaseResponseEntity(HttpStatus.BAD_REQUEST).body(ResponseWrapper.failureOf(exception));
    }

    private ResponseEntity.BodyBuilder getBaseResponseEntity(HttpStatus httpStatus) {
        return ResponseEntity.status(httpStatus).contentType(MEDIA_TYPE);
    }

    private void printStackTrace(Exception e) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter( writer );
        e.printStackTrace( printWriter );
        printWriter.flush();

        log.error(writer.toString());
    }
}
