package com.rabitabank.task.demo.service;

import com.rabitabank.task.demo.model.*;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;


public interface MainService {

    ResponseEntity<ResultModel> add(RequestModel request);

    ResponseEntity<ResultModel> subtract(RequestModel request);

    ResponseEntity<ResultModel> multiply(RequestModel request);

    ResponseEntity<ResultModel> divide(RequestModel request);

    void logBegin(RequestModel request, String serviceName, LogShort logShort, Timestamp CURRENT_TIME);

    void logEnd(int result, String serviceName, LogShort logShort, Timestamp CURRENT_TIME);
}
