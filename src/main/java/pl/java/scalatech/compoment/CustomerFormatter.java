package pl.java.scalatech.compoment;

import java.util.List;
import java.util.Locale;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;
@Component
public class CustomerFormatter implements  Formatter<Customer> {
    private CustomerRepository   repository;
    public  CustomerFormatter(CustomerRepository    repository) {
            this.repository =   repository;
    }
    @Override
    public  Customer   parse(String  name, Locale  locale) throws   ParseException  {
            List<Customer>  customers  =  repository.findByFirstNameLike(name);
            return customers.get(0);
    }
    
    @Override
    public  String  print(Customer customer,   Locale  locale) {
            return customer.getFirstName();
    }
}