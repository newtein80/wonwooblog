package com.wonwoo.wonwooblog.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Navigation라는 어노테이션을 만들자. 해당 어노테이션은 Section이라는 enum을 value 값으로 넣고 해당 클래스의 value를 뷰에 보내줄때 넣어주면 된다.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Navigation {

    Section value();
  
  }