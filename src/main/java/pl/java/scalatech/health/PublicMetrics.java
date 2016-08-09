package pl.java.scalatech.health;

import java.util.Collection;

import org.springframework.boot.actuate.metrics.Metric;

public interface PublicMetrics {
Collection<Metric<?>> metrics();
}