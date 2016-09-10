package pl.java.scalatech.conditional;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import lombok.extern.slf4j.Slf4j;
@Slf4j
class AvailableOnClasspathCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(AvailableOnClasspath.class.getName());
        String className = String.valueOf(attributes.get("value"));
        log.info("++++ conditional : {}",className);
        try {
            Class.forName(className);
            log.info("class exists on classpath");
            
            return true;
        } catch (ClassNotFoundException ignored) {
            
        }
        log.info("class not exists on classpath");
        return false;
    }

}