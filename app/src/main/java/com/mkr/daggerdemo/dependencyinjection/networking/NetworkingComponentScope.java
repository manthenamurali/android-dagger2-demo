package com.mkr.daggerdemo.dependencyinjection.networking;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Refer the below link why this custom scope is used,
 * https://stackoverflow.com/questions/42387631/singleton-component-cannot-depend-on-scoped-components
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface NetworkingComponentScope {

}
