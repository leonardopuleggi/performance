package com.k8s.performance.rest;

import java.util.Map;

/**
 * Dummy result from the RestController.
 *
 */
public class ExecutionResult {
    private Boolean isResultOk;
    private Map<String, Object> resultSet;

    public ExecutionResult(Boolean isResultOk) {
        this.isResultOk = isResultOk;
    }

    public Boolean getResultOk() {
        return isResultOk;
    }

    public void setResultOk(Boolean resultOk) {
        isResultOk = resultOk;
    }

    public Map<String, Object> getResultSet() {
        return resultSet;
    }

    public void setResultSet(Map<String, Object> resultSet) {
        this.resultSet = resultSet;
    }
}
