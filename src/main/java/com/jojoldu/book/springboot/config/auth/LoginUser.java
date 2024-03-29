package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  // 어노테이션이 생성될 수 있는 위치 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션을 런타임시에까지 사용할 수 있다.
public @interface LoginUser {
}
