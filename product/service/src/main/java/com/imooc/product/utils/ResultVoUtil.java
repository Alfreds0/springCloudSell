package com.imooc.product.utils;


import com.imooc.product.dataobject.vo.ResultVo;

public class ResultVoUtil {
    public static ResultVo success(Object object) {
        ResultVo resultVo=ResultVo.builder()
                .code(0)
                .data(object)
                .msg("成功")
                .build();
        return resultVo;
    }
    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer integer,String message) {
        ResultVo resultVo=ResultVo.builder()
                .code(integer)
                .msg(message)
                .build();
        return resultVo;
    }
}
