package com.imooc.girl.core.service;

import com.imooc.girl.core.exception.GirlException;
import com.imooc.girl.core.repository.GirlRepository;
import com.imooc.girl.core.domain.Girl;
import com.imooc.girl.core.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hmh on 2017/7/31.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void girlAddTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("C");
        girlA.setAge(20);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("DDD");
        girlB.setAge(22);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {

        }
    }

    /**
     * 通过id查询一个女孩的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
