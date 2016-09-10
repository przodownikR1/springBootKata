package pl.java.scalatech.auto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import pl.java.scalatech.domain.Customer;

@Component
@Profile("converter")
class CustomerXStreamConverter implements Converter{

        @Override
        public boolean canConvert(Class type) {          
            return type == Customer.class;
        }

        @Override
        public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
            Customer customer = (Customer) source;
            writer.setValue("My customer is : " +customer.getFirstName() + " and his lastName is : " + customer.getLastName());
            
            
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            // TODO Auto-generated method stub
            return null;
        }
    }