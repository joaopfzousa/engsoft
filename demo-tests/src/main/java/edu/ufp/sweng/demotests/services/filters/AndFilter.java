package edu.ufp.sweng.demotests.services.filters;

import edu.ufp.sweng.demotests.models.BaseModel;

import java.util.Set;

public class AndFilter<T extends BaseModel> implements FilterI<T>{
    private FilterI<T> filter;
    private FilterI<T> otherFilter;

    public AndFilter(FilterI<T> filter, FilterI<T> otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }


    @Override
    public Set<T> filter(Set<T> entities) {
        Set<T> filter1=this.filter.filter(entities);
        return this.otherFilter.filter(filter1);
    }
}
