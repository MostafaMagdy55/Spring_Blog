package com.spring.blog.handelExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class exceptionResponse {
    private int status;
    private String message;
    private long timeStamp;

}
