package com.mobiquity.tests;

import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;

public class TestListener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional){
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        System.out.println("Test Succeeded");
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable){
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable){
        System.out.println("Test Failed");
    }
}
