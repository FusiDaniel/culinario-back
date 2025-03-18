package com.culinario.application.commons;

import com.culinario.domain.commons.BaseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

public abstract class BaseController<ID_TYPE, REQUEST, RESPONSE> {

    protected final BaseService<ID_TYPE, REQUEST, RESPONSE> service;

    public BaseController(BaseService<ID_TYPE, REQUEST, RESPONSE> service) {
        this.service = service;
    }

    @GetMapping
    protected ResponseEntity<Page<RESPONSE>> list(Pageable pageable) {
        return new ResponseEntity<>(service.getAllPaged(pageable), OK);
    }

    @GetMapping("/{id}")
    protected ResponseEntity<RESPONSE> getById(@PathVariable ID_TYPE id) {
        return new ResponseEntity<>(service.getById(id), OK);
    }

    @PostMapping
    @Transactional
    protected ResponseEntity<PostResponse> post(@Valid @RequestBody REQUEST request) {
        ID_TYPE createdId = service.post(request);
        return new ResponseEntity<>(new PostResponse(createdId), CREATED);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Transactional
    protected void patch(@PathVariable ID_TYPE id, @RequestBody REQUEST request) {
        service.patch(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    @Transactional
    protected void delete(@PathVariable ID_TYPE id) {
        service.delete(id);
    }

    @Getter
    @Setter
    protected class PostResponse {
        private ID_TYPE id;

        public PostResponse(ID_TYPE id) {
            this.id = id;
        }
    }
}
