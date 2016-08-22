package pl.java.scalatech.web.controller.utils;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequestUri;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;

public final class Utils {

    public static List<Link> getLinks(Page page) {
        List<Link> links = new ArrayList<>();

        String self = fromCurrentRequestUri().queryParam("page", page.getNumber()).queryParam("size", page.getSize()).build().toUriString();
        links.add(new Link(self, "rel_self"));

        if (!page.isFirst()) {
            String path = fromCurrentRequestUri().queryParam("page", 0).queryParam("size", page.getSize()).build().toUriString();
            links.add(new Link(path, "rel_first"));
        }
        if (page.hasPrevious()) {
            String path = fromCurrentRequestUri().queryParam("page", page.getNumber() - 1).queryParam("size", page.getSize()).build().toUriString();
            links.add(new Link(path, "rel_previous"));
        }
        if (page.hasNext()) {
            String path = fromCurrentRequestUri().queryParam("page", page.getNumber() + 1).queryParam("size", page.getSize()).build().toUriString();
            links.add(new Link(path, "rel_next"));
        }
        if (!page.isLast()) {
            String path = fromCurrentRequestUri().queryParam("page", page.getTotalPages() - 1).queryParam("size", page.getSize()).build().toUriString();
            links.add(new Link(path, "rel_last"));
        }

        return links;
    }

    public static PagedResources.PageMetadata getMetadata(Page<?> page) {
        return new PagedResources.PageMetadata(page.getSize(), page.getNumber(), page.getTotalElements(), page.getTotalPages());
    }

}
