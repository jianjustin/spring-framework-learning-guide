package org.janine.jian.person;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "personMapper")
public interface PersonMapper {
    @Results({
        @Result(property = "id",column = "ID"),
        @Result(property = "name",column = "NAME"),
        @Result(property = "age",column = "AGE"),
        @Result(property = "email",column = "EMAIL")
    })
    @Select("select id,name,age,email from person")
    List<Person> findAll();
}
