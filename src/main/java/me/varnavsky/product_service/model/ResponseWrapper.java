package me.varnavsky.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseWrapper<T> {

    ZonedDateTime datetime;
    String errorMessage;
    T payload;

    public static <T> ResponseWrapper<T> of(T payload) {
        return new ResponseWrapper<>(ZonedDateTime.now(), null, payload);
    }

    public static <T> ResponseWrapper<T> failureOf(Exception e) {
        return new ResponseWrapper<>(ZonedDateTime.now(), e.getMessage(), null);
    }
}
