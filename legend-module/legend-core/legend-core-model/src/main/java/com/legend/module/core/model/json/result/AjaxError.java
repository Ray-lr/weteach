package com.legend.module.core.model.json.result;


import com.legend.module.core.model.contant.code.result.AjaxCode;
import com.legend.module.core.model.contant.message.result.AjaxMessage;
import lombok.Data;
import org.springframework.validation.FieldError;

/**
 * @author Administrator
 * @date 2018/2/12
 */
@Data
public class AjaxError {

    private String field;

    private String msg;

    private Integer code;

    public AjaxError() {
        this(AjaxMessage.UNKNOWN_EXCEPTION, AjaxCode.UNKNOWN_EXCEPTION);
    }

    public AjaxError(String field, String msg, Integer code) {
        this.field = field;
        this.msg = msg;
        this.code = code;
    }

    public AjaxError(String field, String msg) {
        this(field, msg, AjaxCode.PARAMETER_ERROR);
    }

    public AjaxError(String msg, Integer code) {
        this(null, msg, code);
    }
}
