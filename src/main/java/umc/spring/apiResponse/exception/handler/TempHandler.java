package umc.spring.apiResponse.exception.handler;

import umc.spring.apiResponse.code.status.ErrorStatus;
import umc.spring.apiResponse.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}
