package pl.java.scalatech.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.java.scalatech.route.JMSRouteBuilder;

@Configuration
public class AdapterConfig {

    @Autowired
    private JMSRouteBuilder jmsRouteBuilder;


    @Bean
    ConnectionFactory jmsConnectionFactory() {
        // use a pool for ActiveMQ connections
        PooledConnectionFactory pool = new PooledConnectionFactory();
        pool.setConnectionFactory(new ActiveMQConnectionFactory("tcp://localhost:61616"));
        return pool;
}
    
    @Bean
    public SpringCamelContext camelContext(ApplicationContext applicationContext) throws Exception {
        SpringCamelContext camelContext = new SpringCamelContext(applicationContext);
        camelContext.addRoutes(jmsRouteBuilder);
        camelContext.addComponent("jms", getJmsComponent());
        return camelContext;
    }

    @Bean
    public JmsComponent getJmsComponent() {
        ActiveMQComponent jms = new ActiveMQComponent();
        jms.setBrokerURL("tcp://localhost:61616");
        return jms;
    }

}
