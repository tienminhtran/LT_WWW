package vn.edu.iuh.fit.week2_phantiensinh.converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper>{
    //ContextResolver<ObjectMapper> chuyển đổi java -> Json
    final ObjectMapper mapper = new ObjectMapper();

    public ObjectMapperContextResolver() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
