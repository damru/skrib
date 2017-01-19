package com.damienrubio.skrib.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * Created by damien on 15/01/2017.
 */
@Data
public class SkribOutput<SkribContext, T> {

    private SkribContext context;
    @Setter(AccessLevel.NONE)
    private String dataType;
    private T data;

    public SkribOutput(SkribContext skribContext, T t) {
        this.context = skribContext;
        this.data = t;
    }

    public String getDataType() {
        return (this.data != null ? this.data.getClass().getSimpleName() : null);
    }
}
