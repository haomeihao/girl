package com.imooc.girl.core.mapper.slave;

import com.imooc.girl.core.model.Girl;
import com.imooc.girl.core.model.GirlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GirlMapper {
    long countByExample(GirlExample example);

    int deleteByExample(GirlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Girl record);

    int insertSelective(Girl record);

    List<Girl> selectByExample(GirlExample example);

    Girl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Girl record, @Param("example") GirlExample example);

    int updateByExample(@Param("record") Girl record, @Param("example") GirlExample example);

    int updateByPrimaryKeySelective(Girl record);

    int updateByPrimaryKey(Girl record);
}