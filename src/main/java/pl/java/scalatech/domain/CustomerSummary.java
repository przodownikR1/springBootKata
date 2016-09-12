package pl.java.scalatech.domain;

import org.springframework.beans.factory.annotation.Value;

public interface CustomerSummary {

	@Value("#{target.firstName + ' ... ' + target.lastName}")
	String getFullName();
}