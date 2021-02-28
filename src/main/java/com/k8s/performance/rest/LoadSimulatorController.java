package com.k8s.performance.rest;

import com.martensigwart.fakeload.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api")
public class LoadSimulatorController {

    @GetMapping("cpu-bound")
    public ResponseEntity<ExecutionResult> simulateCPUBoundJob(@RequestParam(required = false) Integer time, @RequestParam(required = false) Integer limit) {
        FakeLoad fakeload = FakeLoads.create()
                .lasting(time != null? time: 10, TimeUnit.SECONDS)
                .withCpu(limit != null? limit: 10);

        // Execution
        FakeLoadExecutor executor = FakeLoadExecutors.newDefaultExecutor();
        executor.execute(fakeload);

        ExecutionResult result = new ExecutionResult(true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("memory-bound")
    public ResponseEntity<ExecutionResult> simulateMemoryBoundJob(@RequestParam Integer time, @RequestParam Integer limit) {
        FakeLoad fakeload = FakeLoads.create()
                .lasting(time != null? time: 10, TimeUnit.SECONDS)
                .withMemory(limit != null? limit: 10, MemoryUnit.MB);;

        // Execution
        FakeLoadExecutor executor = FakeLoadExecutors.newDefaultExecutor();
        executor.execute(fakeload);

        ExecutionResult result = new ExecutionResult(true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("normalJobs")
    public ResponseEntity<ExecutionResult> simulateRandomJobs() {
        int time = getRandomNumberUsingNextInt(5, 20); //time duration
        int cpuMax = getRandomNumberUsingNextInt(50, 70); //CPU range
        int memoryMax = getRandomNumberUsingNextInt(30, 200); //memory duration

        FakeLoad fakeload = FakeLoads.create()
                .lasting(time, TimeUnit.SECONDS)
                .withCpu(cpuMax)
                .withDiskInput(memoryMax, MemoryUnit.MB);

        // Execution
        FakeLoadExecutor executor = FakeLoadExecutors.newDefaultExecutor();
        executor.execute(fakeload);

        ExecutionResult result = new ExecutionResult(true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
