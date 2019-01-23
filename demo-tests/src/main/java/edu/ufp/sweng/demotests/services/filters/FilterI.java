package edu.ufp.sweng.demotests.services.filters;

import edu.ufp.sweng.demotests.models.BaseModel;

import java.util.Set;

public interface FilterI<T extends BaseModel> {
    Set<T> filter(Set<T> entities);
}
