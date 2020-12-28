package com.hnguigu.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.hnguigu.utils.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PayController {

    //点击付款按钮，接收付款金额，生成付款页面
    //返回结果为付款页面代码   前端接收到在页面展示
    @RequestMapping(value = "pay.action",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String pay1(String tradeno,float price,String tradename){
    //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);



        alipayRequest.setBizContent("{\"out_trade_no\":\""+ tradeno +"\","
                + "\"total_amount\":\""+ price +"\","
                + "\"subject\":\""+ tradename +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result="";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //输出
        System.out.println(result);

        /*response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();



        out.println("<html>"+result+"</html>");
*/
        return result;
    }


}
