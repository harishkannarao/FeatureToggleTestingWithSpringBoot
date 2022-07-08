package com.harishkannarao.demo.feature_toggle.test.runner;

import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

public class SpringBootTearDownListener implements TestExecutionListener {

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        if (SpringBootTestRunner.isRunning()) {
            try {
                SpringBootTestRunner.stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        TestExecutionListener.super.testPlanExecutionFinished(testPlan);
    }
}
