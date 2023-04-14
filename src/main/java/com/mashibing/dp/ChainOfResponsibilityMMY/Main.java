package com.mashibing.dp.ChainOfResponsibilityMMY;

/**
 * 类描述：责任链模式测试类
 */
public class Main {

    public static void main(String[] args) {

        Request.Builder builder = new Request.Builder().setName("张三").setDays(1).setReason("肚子疼");
        Request request = builder.build();
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        Result result = client.execute(request);

        System.out.println("结果：" + result.toString());
    }
}
