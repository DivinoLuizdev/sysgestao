package br.com.aulaws.sysgestao.error;

import java.time.Instant;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiError {

    private int status;
    private String message;
    private Long timestamp;
    private String path;

    private HashMap<String, String> validacaoErrorCampos;

    public ApiError() {
    }

    public ApiError(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public void setValidacaoErrorCampos(HashMap<String, String> validacaoErrorCampos) {
        this.validacaoErrorCampos = validacaoErrorCampos;
    }

}
