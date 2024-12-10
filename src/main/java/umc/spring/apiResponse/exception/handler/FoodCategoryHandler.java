package umc.spring.apiResponse.exception.handler;

import umc.spring.apiResponse.code.status.ErrorStatus;
import umc.spring.apiResponse.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(ErrorStatus error) {
        super(error);
    }
}
