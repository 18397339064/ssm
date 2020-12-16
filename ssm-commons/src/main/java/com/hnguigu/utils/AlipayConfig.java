package com.hnguigu.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000116673243";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCWzwHQQrb/RXxri9xER85k8esBz5qjMREy1xc0lGUf4Yrllnm09uFFfbS9UqKHhmM6uPZeI4tcQHy5vuQdKQc7MYBUo9zdZIZ0yrvgfHwesHdncAew8NRE+nFbqcU2cu9df7I8z54gSOfCjgEESf+mChZkf1lagQFQJgtTTu5Dq85d8ilXv9k30PdiB9jdq0CfnaOPalbZRugbndjkq/gaEkqwDi3ld5GaU5PlzEPcYAz+QlhAQ5EnAj0ZVnjvvwEytopXRkSgfeXZjVuajSGvl9nIAnloPFKYqr9QiW5hpIWfJa38fqq2a819QtYM0tFihCxvwZWltTEnZHT21TEvAgMBAAECggEBAJJwVJx8C+J5AMYVuz96Uopm9wJ9KvWIMeEiR2BBMKjyg8NIiMoWaMznsdedJEFhV32wGVt0PGDKJdLf7/X43xK1kJ2fuFoqwP0r15+2gXfzdx60BGPmlticL/MIOX4TwScTVmoCWNOUt6eN6KLXkC0U4oWXu5ZMao//QUQWAvslmMtMi3cFpLZrr/L0AzmvkZjseL3FbJuPMahHnzXZgetO+89X2jwtPYXIfP4uqrPWTpwsAk7HPue75Xt+jXb/TojkFDQyTUz1x73KcC6GOJAe9qiVTrB1C9SPJWQ4HiIKr9D6ZIBntGB+TCH5uiROLCqx3ZRpdHPfeGMxed9qrkECgYEA5yrkYnoaR70nXgwwvcPMudKzHRctFDPkcQP3p/H8DoAjDtWjQ8PrKCYW4K/0uF4LadhigHOnvUOj9WMx7mpI6TgSpxtPQ/GeX76i6Y6nIPYT2W4GiQBSX4CKxrO/Ql6m+d8M1W5GIcBed9r0Y/LF6zrCoVkLYhU99jQqpLY0i1ECgYEApwI+j8vKEFMJaVM/8CfEyKiz+FQnj2FP+MORiErKZjTzo2O3MAvgQWARJYa3fv8s5ARWla2YVlN2jntzW+xuwg9vc15PIIvYwTea+NpmnzpTe9wi7jfueFJGHXaj0UxGDXYeJmaSXjTeYu6gbdA5OlcKEozAUbaqhwJ4/ZXV1H8CgYBulJAHo40qwAsy6/Xs8NrgETBpPAruXRxsC4/OoO0IKreagwvEgNXesMnE1ablAufGzCHifHDDErY9ziO2ftU96vrRQTkbsVsnRdQ8kWbVV6GLIxyxMJw23xCDmLxnDUwmv1IuTr/xqUoHX5AEt7+BlOxBrozJcIvhWHcFr7tW4QKBgG+6bKg+qdvp8W3pJ+k+ccPcOSp1AlJFw/6kt4P6pRVjb2trlm4qQ8j4v//e9HudsyaIUHSqQjPeen4v0Kk6r45cTS9ddIpNhKEe1iqN0gHMP3WpfCTqfjs4r3eem1G2OVdgIiOGk3062VxOUD2nA+InwLFQQIlqLwNLgC4GQ5t5AoGBANU7gTAwda6TX55IIOXAdUYPsF1HeID5qwuC6uQxtV//zQDrnRIt8Na1zZNNjC6GoruO2rwUkHNJsuN+3JOLYuozkkpeL2plHof6IIpP0Sb/VFOdQT7TLmdi64dxQPPxWM/cNrpxEv+bZhHC0V0P80bfVPXqQshW7JuzY1WJbUjs";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAutIXki/QNMQ+zTKgPcgArTabkSOdYmxi9MIiz9Gtx11K7oOlG28sdP9uvHpltTErJGzjl9w2ude6E2kIFLyulHFcHkN4/EErZKNKqZ8y77fmp35y542UQzhh3WUtOXA/GTb7x7a8JQGmjrqi+vYyOw6jWaD+CK/tqnmG7j5w0th9kiQ5x6MX2prU1fgJWfFULI5iRTHOM7KlZUmY+mTf93Nrln/aMl4p/2nd7Tq54r/fLRCysNAI9bKQkCpENVlwV6Kv2Xqw1NGS+36Pseq9hw9kDF+zgru1Jaks1vpyHk3Ryj4gu1OeDVIYm2okB5CWNTtIcn2GGtCu9Hp0ZUVcBwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/ssm_web/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/ssm_web/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

