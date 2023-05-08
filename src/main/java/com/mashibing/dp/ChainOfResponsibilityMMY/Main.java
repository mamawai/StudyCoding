package com.mashibing.dp.ChainOfResponsibilityMMY;

/**
 * 类描述：责任链模式测试类
 */
public class Main {

    public static void main(String[] args) {

//        Request.Builder builder = new Request.Builder().setName("张三").setDays(6).setReason("肚子疼").setCustomInfo("谢谢领导们");
//        Request request = builder.build();




        Request request = Request.builder().name("张三").days(9).reason("去旅游").customInfo("老子管你们同不同意").build();
        Request request1 = Request.builder().name("lisi").days(9).reason("dsa").customInfo("dsa").build();

        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        Result result = client.execute(request);

        System.out.println("结果：" + result.toString());
    }
}
