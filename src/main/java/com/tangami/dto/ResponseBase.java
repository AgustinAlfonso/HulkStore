package com.tangami.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBase {
    /**
     * codigo de error
     */
    protected HttpStatus statusCod;

    /**
     * Descripcion de error
     */
    protected String statusDescription;

    public ResponseBase(HttpStatus statusCod, String statusDescription) {
        this.statusCod = statusCod;
        this.statusDescription = statusDescription;
    }
}
