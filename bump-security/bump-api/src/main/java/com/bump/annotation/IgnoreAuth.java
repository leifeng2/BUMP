package com.bump.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 * @author lixi
 * 
 * @date 2017-04-23 15:44
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
