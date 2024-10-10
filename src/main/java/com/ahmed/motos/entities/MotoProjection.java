package com.ahmed.motos.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomMoto",types = {Moto.class})
public interface MotoProjection {
    public String getMarqueMoto();
}
