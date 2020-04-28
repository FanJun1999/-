package com.hdax.constant;

/**
 * 常量数据存放类
 */
public class Constants {

    public static class LoginInfo {
        public static final String LOGIN_USER = "userInfo";

        public static final String ERR_LOGIN_INVALID_USERNAME = "用户名不正确";
        public static final String ERR_LOGIN_INVALID_PASSWORD = "密码不正确";
    }

    public static class BillInfo{

        public static final String ERR_BILL_DEL_CODE = "1003";
        public static final String ERR_BILL_DEL_MSG = "订单删除失败!";


        public static final String ERR_BILL_INS_CODE = "1004";
        public static final String ERR_BILL_INS_MSG = "订单添加失败!";


        public static final String ERR_BILL_UPD_CODE = "1005";
        public static final String ERR_BILL_UPD_MSG = "订单修改失败!";

    }
}
