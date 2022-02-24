package com.example.springdemo.persistence.mapper;

import com.example.springdemo.domain.Category;
import com.example.springdemo.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);



    @InheritInverseConfiguration //backwards mapping from the previous defined one!!
    @Mapping(target = "productos", ignore = true) // since the products field is not mapped in the Category we want to skip it
    Categoria toCategoria(Category category);
}
