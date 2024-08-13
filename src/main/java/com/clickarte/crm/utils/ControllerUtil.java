package com.clickarte.crm.utils;

import java.net.URI;
import org.springframework.web.util.UriComponentsBuilder;

public class ControllerUtil {

    public static final URI getUri(UriComponentsBuilder uriComponentsBuilder, String path,
            Long id) {

        return uriComponentsBuilder.path(path).buildAndExpand(id).toUri();

    }
}
