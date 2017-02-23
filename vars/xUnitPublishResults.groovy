#!/usr/bin/env groovy

def call(String pattern, Integer failWhenSkippedExceeds,
        Integer failWhenFailedExceeds) {
    step([$class: 'XUnitBuilder',
        thresholds: [
            [$class: 'SkippedThreshold', failureThreshold: failWhenSkippedExceeds.toString()],
            // Allow for a significant number of failures
            // Keeping this threshold so that overwhelming failures are guaranteed
            //     to still fail the build
            [$class: 'FailedThreshold', failureThreshold: failWhenFailedExceeds.toString()]],
        tools: [[$class: 'JUnitType', pattern: pattern]]])
}
