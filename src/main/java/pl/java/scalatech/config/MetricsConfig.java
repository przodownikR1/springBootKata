package pl.java.scalatech.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jvm.FileDescriptorRatioGauge;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MetricsConfig extends MetricsConfigurerAdapter {

    @Bean(name = "metrics")
    public MetricRegistry metricRegistry() {
        final MetricRegistry metrics = new MetricRegistry();
        metrics.register("jvm.gc", new GarbageCollectorMetricSet());
        metrics.register("jvm.memory", new MemoryUsageGaugeSet());
        metrics.register("thread-states", new ThreadStatesGaugeSet());
        metrics.register("jvm.fd.usage", new FileDescriptorRatioGauge());
        return metrics;
    }

    @Value("${metrics.refresh.interval:30}")
    private long perfStatsPeriod;

    @Override
    public void configureReporters(final MetricRegistry metricRegistry) {

        registerReporter(
                Slf4jReporter.forRegistry(metricRegistry).outputTo(log).convertRatesTo(TimeUnit.MILLISECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build())
                        .start(perfStatsPeriod, TimeUnit.SECONDS);

        registerReporter(JmxReporter.forRegistry(metricRegistry).build());

    }

    @Bean
    @Autowired
    public ServletRegistrationBean servletRegistrationBean(MetricRegistry metricRegistry) {
        MetricsServlet ms = new MetricsServlet(metricRegistry);
        ServletRegistrationBean srb = new ServletRegistrationBean(ms, "/metrics/stats/*");
        srb.setLoadOnStartup(1);
        return srb;
    }

    @Bean(name = "healthCheckMetrics")
    public HealthCheckRegistry healthCheckMetrics() {
        return new HealthCheckRegistry();
    }

    
      @Bean
      @Autowired
      public ServletRegistrationBean servletHealthRegistryBean(HealthCheckRegistry healthCheckRegistry) {
      HealthCheckServlet hc = new HealthCheckServlet(healthCheckRegistry);
      ServletRegistrationBean srb = new ServletRegistrationBean(hc, "/metrics/health/*");
      srb.setLoadOnStartup(2);
      return srb;
      }
     
}
