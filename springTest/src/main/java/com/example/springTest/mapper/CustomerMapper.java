package com.example.springTest.mapper;

import com.example.springTest.dao.entity.CustomerEntity;
import com.example.springTest.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "age", target = "age")
    })
    CustomerDto entityToDto(CustomerEntity customerEntity);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "age", target = "age")
    })
    CustomerEntity dtoToEntity(CustomerDto customerDto);
}
