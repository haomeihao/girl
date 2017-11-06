package com.imooc.girl.core.rpc.httprpc;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hmh on 2017/8/28.
 */
@WebServlet(urlPatterns = "/provider.do")
public class ServiceProvider extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务
        Map<String, Object> serviceMap = new HashMap();
        String serviceInterfaceName = BaseService.class.getName();
        BaseService providerService = new SayHelloService();
        serviceMap.put(serviceInterfaceName, providerService);

        System.out.println(serviceInterfaceName+"\t"+providerService);

        // 基本参数
        String serviceName = req.getParameter("service");
        String format = req.getParameter("format");

        System.out.println(serviceName+"\t"+format);

        Map parameters = req.getParameterMap();
        System.out.println("parameters-->"+parameters);

        BaseService service = (BaseService) serviceMap.get(serviceName);
        Object result = service.execute(parameters);

        // 生成JSON结果集
        JsonResult jsonResult = JsonResultUtil.success(result);

        String json = JsonUtil.getJson(jsonResult);

        resp.getWriter().write(json);
    }
}
