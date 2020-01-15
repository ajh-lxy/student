package com.fh.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Lenovo
 * @title: IsNoLogin
 * @projectName shop_admin_web
 * @description: TODO
 * @date 2020/1/321:10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNoLogin {

}
