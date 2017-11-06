package com.imooc.girl.core.mapper;

import com.imooc.girl.core.domain.Girl;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by hmh on 2017/11/6.
 */
public interface GirlDemoMapper {

    List<Girl> getAll();

    @Select("select * from girl where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "cup_size", property = "cupSize"),
            @Result(column = "age", property = "age"),
            @Result(column = "money", property = "money"),
    })
    Girl getOne(Integer id);

    void insert(Girl girl);

    void update(Girl girl);

    void delete(Integer id);
}
