package pl.java.scalatech.compoment;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

import pl.java.scalatech.domain.Customer;

public class CustomerEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.hasText(text)) {
            setValue(new Customer(text.trim(), ""));
        } else {
            setValue(null);
        }
    }

    @Override
    public String getAsText() {
        Customer customer = (Customer) getValue();
        if (customer != null) {
            return customer.getFirstName();
        }
        return "";
    }
}