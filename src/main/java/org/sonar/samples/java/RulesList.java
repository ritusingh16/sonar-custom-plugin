package org.sonar.samples.java;

import java.util.List;

import org.sonar.plugins.java.api.JavaCheck;


import org.sonar.samples.java.checks.AvoidHardCodedStringRule;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList;

public final class RulesList {

  private RulesList() {
  }

  public static List<Class> getChecks() {
    return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
  }

  public static List<Class<? extends JavaCheck>> getJavaChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
    
       .add(AvoidHardCodedStringRule.class)
      .build();
  }

  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
      .build();
  }
}
