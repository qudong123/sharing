package com.yn.controller;

import com.yn.common.util.IpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class GetInfoController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getInfo(HttpServletRequest request){
        String path = "\\"+request.getSession().getId()+".txt";
        File f = new File(path);
        /**
         * 1.获得客户机信息
         */
        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        String remoteAddr = IpUtils.getIpAddr(request);//得到来访者的IP地址
        String requestUri = request.getRequestURI();//得到请求的资源
        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名
        String agent = request.getHeader("USER-AGENT");//浏览器类型

        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("获取到的客户机信息如下：");
            bw.newLine();
            bw.write("请求的URL地址："+requestUrl);
            bw.newLine();
            bw.write("请求的资源："+requestUri);
            bw.newLine();
            bw.write("请求的URL地址中附带的参数："+queryString);
            bw.newLine();
            bw.write("来访者的IP地址："+remoteAddr);
            bw.newLine();
            bw.write("来访者的主机名："+remoteHost);
            bw.newLine();
            bw.write("使用的端口号："+remotePort);
            bw.newLine();
            bw.write("remoteUser："+remoteUser);
            bw.newLine();
            bw.write("请求使用的方法："+method);
            bw.newLine();
            bw.write("pathInfo："+pathInfo);
            bw.newLine();
            bw.write("localAddr："+localAddr);
            bw.newLine();
            bw.write("localName："+localName);
            bw.newLine();
            bw.write("浏览器类型："+agent);
            bw.flush();
            System.out.println("绝对路径--------------------" + f.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}