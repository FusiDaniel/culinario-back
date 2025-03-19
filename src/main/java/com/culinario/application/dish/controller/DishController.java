package com.culinario.application.dish.controller;

import com.culinario.application.commons.BaseController;
import com.culinario.application.dish.request.DishRequest;
import com.culinario.application.dish.response.DishResponse;
import com.culinario.domain.dish.service.IDishService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dishes")
public class DishController extends BaseController<Long, DishRequest, DishResponse> {
    public DishController(IDishService service) { super(service); }
}
