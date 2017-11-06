package com.imooc.girl.core.rpc.httprestful;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hmh on 2017/8/28.
 */
@Controller
public class PeopleController {

    @GetMapping(value = "/person/{name}")
    public String get(@PathVariable("name") String name, Model model) {
        // 根据名称查找逻辑
        return "/result.jsp";
    }

    @PostMapping(value = "/person")
    public String post(Model model) {
        // 新增逻辑
        return "/result.jsp";
    }

    @DeleteMapping(value = "/person/{name}")
    public String delete(@PathVariable("name") String name, Model model) {
        // 删除逻辑
        return "/result.jsp";
    }

    @PutMapping(value = "/person/{name}")
    public String put(@PathVariable("name") String name, Model model) {
        // 更新逻辑
        return "/result.jsp";
    }


}
