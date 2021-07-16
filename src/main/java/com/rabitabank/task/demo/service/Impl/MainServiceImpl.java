package com.rabitabank.task.demo.service.Impl;

import com.rabitabank.task.demo.model.LogLong;
import com.rabitabank.task.demo.model.LogShort;
import com.rabitabank.task.demo.model.RequestModel;
import com.rabitabank.task.demo.model.ResultModel;
import com.rabitabank.task.demo.repository.LogLongRepository;
import com.rabitabank.task.demo.repository.LogShortRepository;
import com.rabitabank.task.demo.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final LogShortRepository shortRepository;
    private final LogLongRepository longRepository;

    @Override
    public ResponseEntity<ResultModel> add(RequestModel request) {
        Timestamp CURRENT_TIME = new Timestamp(System.currentTimeMillis());
        LogShort logShort = LogShort.builder().insertDate(CURRENT_TIME).build();
        logBegin(request, "add", logShort, CURRENT_TIME);
        int result = (request.getIntA() + request.getIntB());
        ResultModel model = ResultModel.builder()
                .result(result)
                .build();
        logEnd(result, "add", logShort, CURRENT_TIME);
        return ResponseEntity.ok(model);
    }

    @Override
    public ResponseEntity<ResultModel> subtract(RequestModel request) {
        Timestamp CURRENT_TIME = new Timestamp(System.currentTimeMillis());
        LogShort logShort = LogShort.builder().insertDate(CURRENT_TIME).build();
        logBegin(request, "subtract", logShort, CURRENT_TIME);
        int result = (request.getIntA() - request.getIntB());
        ResultModel model = ResultModel.builder()
                .result(result)
                .build();
        logEnd(result, "subtract", logShort, CURRENT_TIME);
        return ResponseEntity.ok(model);
    }

    @Override
    public ResponseEntity<ResultModel> multiply(RequestModel request) {
        Timestamp CURRENT_TIME = new Timestamp(System.currentTimeMillis());
        LogShort logShort = LogShort.builder().insertDate(CURRENT_TIME).build();
        logBegin(request, "multiply", logShort, CURRENT_TIME);
        int result = (request.getIntA() * request.getIntB());
        ResultModel model = ResultModel.builder()
                .result(result)
                .build();
        logEnd(result, "multiply", logShort, CURRENT_TIME);
        return ResponseEntity.ok(model);
    }

    @Override
    public ResponseEntity<ResultModel> divide(RequestModel request) {
        Timestamp CURRENT_TIME = new Timestamp(System.currentTimeMillis());
        LogShort logShort = LogShort.builder().insertDate(CURRENT_TIME).build();
        if (request.getIntB() != 0) {
            logBegin(request, "divide", logShort, CURRENT_TIME);
            int result = (request.getIntA() / request.getIntB());
            ResultModel model = ResultModel.builder()
                    .result(result)
                    .build();
            logEnd(result, "divide", logShort, CURRENT_TIME);
            return ResponseEntity.ok(model);
        }
        return null;
    }

    @Override
    public void logBegin(RequestModel request, String serviceName, LogShort logShort, Timestamp CURRENT_TIME) {
        shortRepository.save(logShort);
        log.info("Call " + serviceName + " service with : " + request.getIntA() + " and " + request.getIntB());
        longRepository.save(LogLong.builder().insertDate(CURRENT_TIME).logShort(logShort).value("Request " + serviceName + " service : " + request.getIntA() + " and " + request.getIntB()).build());
    }

    @Override
    public void logEnd(int result, String serviceName, LogShort logShort, Timestamp CURRENT_TIME) {
        log.info("Response " + serviceName + " service : " + result);
        longRepository.save(LogLong.builder().insertDate(CURRENT_TIME).logShort(logShort).value("Response " + serviceName + " service : " + result).build());
    }
}