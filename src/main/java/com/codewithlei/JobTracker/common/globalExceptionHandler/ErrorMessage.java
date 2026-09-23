package com.codewithlei.JobTracker.common.globalExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ErrorMessage {
    private int status;
    private String message;
    private LocalDateTime dateTime;
}
