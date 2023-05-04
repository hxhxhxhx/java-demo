package com.huaxiti.泛型;
import org.springframework.core.GenericTypeResolver;
public abstract class People<T> {

    protected Class<T> getType() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(this.getClass(), People.class);
    }

}
