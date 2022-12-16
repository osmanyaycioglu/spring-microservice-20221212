package com.training.inno.ms.msorder.retry.test;


import io.github.resilience4j.circuitbreaker.CircuitBreaker;

public class CBMetric {

    private float failureRate;
    private float slowCallRate;
    private int numberOfSlowCalls;
    private int numberOfSlowSuccessfulCalls;
    private int numberOfSlowFailedCalls;
    private int numberOfBufferedCalls;
    private int numberOfFailedCalls;
    private long numberOfNotPermittedCalls;
    private int numberOfSuccessfulCalls;

    public CBMetric() {
    }

    public CBMetric(CircuitBreaker.Metrics metricsParam) {
        failureRate = metricsParam.getFailureRate();
        slowCallRate = metricsParam.getSlowCallRate();
        numberOfSlowCalls = metricsParam.getNumberOfSlowCalls();
        numberOfSlowSuccessfulCalls = metricsParam.getNumberOfSlowSuccessfulCalls();
        numberOfSlowFailedCalls = metricsParam.getNumberOfSlowFailedCalls();
        numberOfBufferedCalls = metricsParam.getNumberOfBufferedCalls();
        numberOfFailedCalls = metricsParam.getNumberOfFailedCalls();
        numberOfNotPermittedCalls = metricsParam.getNumberOfNotPermittedCalls();
        numberOfSuccessfulCalls = metricsParam.getNumberOfSuccessfulCalls();
    }

    public float getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(float failureRateParam) {
        failureRate = failureRateParam;
    }

    public float getSlowCallRate() {
        return slowCallRate;
    }

    public void setSlowCallRate(float slowCallRateParam) {
        slowCallRate = slowCallRateParam;
    }

    public int getNumberOfSlowCalls() {
        return numberOfSlowCalls;
    }

    public void setNumberOfSlowCalls(int numberOfSlowCallsParam) {
        numberOfSlowCalls = numberOfSlowCallsParam;
    }

    public int getNumberOfSlowSuccessfulCalls() {
        return numberOfSlowSuccessfulCalls;
    }

    public void setNumberOfSlowSuccessfulCalls(int numberOfSlowSuccessfulCallsParam) {
        numberOfSlowSuccessfulCalls = numberOfSlowSuccessfulCallsParam;
    }

    public int getNumberOfSlowFailedCalls() {
        return numberOfSlowFailedCalls;
    }

    public void setNumberOfSlowFailedCalls(int numberOfSlowFailedCallsParam) {
        numberOfSlowFailedCalls = numberOfSlowFailedCallsParam;
    }

    public int getNumberOfBufferedCalls() {
        return numberOfBufferedCalls;
    }

    public void setNumberOfBufferedCalls(int numberOfBufferedCallsParam) {
        numberOfBufferedCalls = numberOfBufferedCallsParam;
    }

    public int getNumberOfFailedCalls() {
        return numberOfFailedCalls;
    }

    public void setNumberOfFailedCalls(int numberOfFailedCallsParam) {
        numberOfFailedCalls = numberOfFailedCallsParam;
    }

    public long getNumberOfNotPermittedCalls() {
        return numberOfNotPermittedCalls;
    }

    public void setNumberOfNotPermittedCalls(long numberOfNotPermittedCallsParam) {
        numberOfNotPermittedCalls = numberOfNotPermittedCallsParam;
    }

    public int getNumberOfSuccessfulCalls() {
        return numberOfSuccessfulCalls;
    }

    public void setNumberOfSuccessfulCalls(int numberOfSuccessfulCallsParam) {
        numberOfSuccessfulCalls = numberOfSuccessfulCallsParam;
    }

    @Override
    public String toString() {
        return "CBMetric{" +
               "\n\tfailureRate=" + failureRate +
               "\n\tslowCallRate=" + slowCallRate +
               "\n\tnumberOfSlowCalls=" + numberOfSlowCalls +
               "\n\tnumberOfSlowSuccessfulCalls=" + numberOfSlowSuccessfulCalls +
               "\n\tnumberOfSlowFailedCalls=" + numberOfSlowFailedCalls +
               "\n\tnumberOfBufferedCalls=" + numberOfBufferedCalls +
               "\n\tnumberOfFailedCalls=" + numberOfFailedCalls +
               "\n\tnumberOfNotPermittedCalls=" + numberOfNotPermittedCalls +
               "\n\tnumberOfSuccessfulCalls=" + numberOfSuccessfulCalls +
               "\n}";
    }
}
