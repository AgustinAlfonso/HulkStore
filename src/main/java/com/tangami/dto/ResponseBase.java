package com.tangami.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBase {
    /**
     * codigo de error
     */
    protected HttpStatus errorcod;

    /**
     * Descripcion de error
     */
    protected String errordes;

    public ResponseBase(HttpStatus errorcod, String errordes) {
        this.errorcod = errorcod;
        this.errordes = errordes;
    }
}
