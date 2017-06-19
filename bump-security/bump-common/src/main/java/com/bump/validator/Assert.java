package com.bump.validator;

import com.bump.utils.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 * @author lixi
 * 
 * @date 2017-04-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
