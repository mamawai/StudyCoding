package com.mashibing.dp.ChainOfResponsibilityMMY;

/**
 * 组长
 *
 */
public class GroupLeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("GroupLeader=====>request:" + request.toString());

        if (request.getDays() > 1) {
            // 包装新的Request对象

//            Request1 build = Request1.builder().newRequest1(request1).managerInfo(request1.name() + " ").build();
//            Request1.Request1Builder request1Builder = new Request1.Request1Builder();
//            Request1.Request1Builder builder = Request1.builder();

//            Request newRequest = new Request.Builder().newRequest(request)
//                    .setGroupLeaderInfo(request.name() + "平时表现不错，而且现在项目也不忙")
//                    .build();
//            Request newRequest = Request.builder().newRequest(request).groupLeaderInfo(request.name() + "平时表现不错，而且现在项目也不忙").build();

            Request build = request.toBuilder().groupLeaderInfo(request.getName() + "平时表现不错，而且现在项目也不忙").build();

            return chain.proceed(build);
        }

        return new Result(true, "GroupLeader：早去早回");
    }
}
