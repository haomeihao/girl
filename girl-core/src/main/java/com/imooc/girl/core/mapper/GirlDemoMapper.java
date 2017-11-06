package com.imooc.girl.core.mapper;

import com.imooc.girl.core.domain.Girl;

import java.util.List;

/**
 * Created by hmh on 2017/11/6.
 */
public interface GirlDemoMapper {

    List<Girl> getAll();

    Girl getOne(Integer id);

    void insert(Girl girl);

    void update(Girl girl);

    void delete(Integer id);
}
