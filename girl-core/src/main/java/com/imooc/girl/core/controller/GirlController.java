package com.imooc.girl.core.controller;

import com.imooc.girl.core.domain.Result;
import com.imooc.girl.core.repository.GirlRepository;
import com.imooc.girl.core.service.GirlService;
import com.imooc.girl.core.utils.ResultUtil;
import com.imooc.girl.core.domain.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hmh on 2017/7/31.
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    private final static Logger log = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getList() {
        log.info("222222");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return null;
//            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girl/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdateOne(@PathVariable("id") Integer id, Girl girl) {
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girl/{id}")
    public void girlDeleteOne(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlAddTwo() {
        girlService.girlAddTwo();
    }

    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
