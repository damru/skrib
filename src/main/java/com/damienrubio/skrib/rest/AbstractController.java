package com.damienrubio.skrib.rest;

import com.damienrubio.skrib.SkribApplication;
import org.springframework.http.HttpHeaders;

/**
 * Created by damien on 19/01/2017.
 */
public abstract class AbstractController {

    protected HttpHeaders generateHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        if (SkribApplication.contexte.hasErrors())
            headers.add("errors", SkribApplication.contexte.getErrors().toString());
        if (SkribApplication.contexte.hasWarnings())
            headers.add("warnings", SkribApplication.contexte.getWarnings().toString());
        if (SkribApplication.contexte.hasInfos())
            headers.add("infos", SkribApplication.contexte.getInfos().toString());
        return headers;
    }

}
