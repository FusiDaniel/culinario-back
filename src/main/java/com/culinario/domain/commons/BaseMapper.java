package com.culinario.domain.commons;

public interface BaseMapper<ENTITY, REQUEST, RESPONSE> {
    ENTITY requestToEntity(REQUEST request);
    RESPONSE entityToResponse(ENTITY entity);
}
