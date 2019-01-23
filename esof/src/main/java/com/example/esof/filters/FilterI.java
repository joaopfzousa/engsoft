package com.example.esof.filters;

import com.example.esof.models.BaseModel;

import java.util.Set;

public interface FilterI<T extends BaseModel> {
    Set<T> filter(Set<T> entities);
}
