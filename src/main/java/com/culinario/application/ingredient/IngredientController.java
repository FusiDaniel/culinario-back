package com.culinario.application.ingredient;

import com.culinario.application.commons.BaseController;
import com.culinario.application.ingredient.request.IngredientRequest;
import com.culinario.application.ingredient.response.IngredientResponse;
import com.culinario.domain.ingredient.service.IIngredientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientController extends BaseController<Long, IngredientRequest, IngredientResponse> {
    public IngredientController(IIngredientService service) {
        super(service);
    }
}
