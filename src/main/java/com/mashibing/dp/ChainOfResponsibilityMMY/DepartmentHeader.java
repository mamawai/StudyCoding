package com.mashibing.dp.ChainOfResponsibilityMMY;


/**
 * 部门领导
 */
public class DepartmentHeader implements Ratify {

    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("DepartmentHeader=====>request:"
                + request.toString());
        if (request.getDays() > 7) {
            return new Result(false, "你这个完全没必要最多只会给你7天假期");
        }
        return new Result(true, "DepartmentHeader：不要着急，把事情处理完再回来！");
    }

}
