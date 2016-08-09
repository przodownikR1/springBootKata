package pl.java.scalatech.config;

import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jmx.export.MBeanExporter;

@Configuration
public class ApplicationMetric {
    @Bean
    @ExportMetricWriter
    MetricWriter metricWriter(MBeanExporter exporter) {
        return new JmxMetricWriter(exporter);
    }

    @Bean
    @Primary
    MBeanExporter mBeanExporter() {
        return new MBeanExporter();
    }
}