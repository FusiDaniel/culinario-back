package com.culinario.domain.commons;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<ID_TYPE, REQUEST, RESPONSE> {
    Page<RESPONSE> getAllPaged(Pageable pageable);
    RESPONSE getById(ID_TYPE id);
    ID_TYPE post(REQUEST data);
    void patch(ID_TYPE id, REQUEST data);
    void delete(ID_TYPE id);
}
