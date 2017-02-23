#!/usr/bin/env groovy

def call(String sauceCredential, String platforms = null, String testFilter = null) {
    platforms = platforms ? "-e '" + platforms + "'" : ''
    testFilter = testFilter ? "--test '" + testFilter + "'" : ''

    // Add sauce credentials
    sauce(sauceCredential) {
        // Start sauce connect
        sauceconnect() {
            // Run selenium tests using Nightwatch.js
            // Ignore error codes. The junit publisher will cover setting build status.
            sh "./node_modules/.bin/nightwatch ${platforms} ${testFilter} || true" // <1>
        }
    }
}
