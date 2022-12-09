package com.songday.benchmark.springboot3mvc.dao;

import com.songday.benchmark.springboot3mvc.model.Person;
import org.apache.ibatis.annotations.*;

public interface PersonMapper {
    @Insert("INSERT INTO persons(id,name,age,description)VALUES(#{id},#{name},#{age},#{description})")
    void addPerson(Person person);

    @Select("SELECT * FROM persons ORDER BY id DESC LIMIT 1")
    Person getLatestPerson();

    @Update("UPDATE persons SET description=#{description} WHERE id=#{id}")
    int updateDescription(Person person);

    @Delete("DELETE FROM persons WHERE id=#{id}")
    int delete(String id);
}
