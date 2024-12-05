package com.harishkannarao.demo.feature_toggle;

import com.harishkannarao.demo.feature_toggle.configuration.LocalTestConfiguration;
import org.springframework.boot.SpringApplication;

public class FeatureToggleApplicationLocalRunner {

	public static void main(String[] args) {
		Class<?>[] classes = new Class[] {
				FeatureToggleApplication.class,
				LocalTestConfiguration.class
		};
		SpringApplication.run(classes, args);
	}

}
