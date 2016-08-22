package pl.java.scalatech.web.controller.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.web.controller.CustomerController;
import pl.java.scalatech.web.controller.CustomerHateoasController;
@Component
public class CustomerAssembler extends ResourceAssemblerSupport<Customer, Resource> {

    public CustomerAssembler() {
        super(CustomerHateoasController.class, Resource.class);
    }

    @Override
    public Resource<Customer> toResource(Customer customer) {
        Resource<Customer> resource = new Resource<>(customer, ControllerLinkBuilder.linkTo(CustomerController.class).
                slash(customer.getId()).withSelfRel());
        resource.add(getLinks(customer));
        return resource;
    }

    protected Iterable<Link> getLinks(Customer customer) {
        List<Link> links = new ArrayList<>();
        //links.add(linkTo(MemberOfController.class, user.getId()).withRel("member"));
        //links.add(linkTo(ProjectController.class).withRel("project"));
        //links.add(linkTo(UserTaskController.class, user.getId()).withRel("task"));                
        return links;
    }
}


