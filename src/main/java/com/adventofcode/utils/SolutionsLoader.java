package com.adventofcode.utils;

import java.util.Set;

import org.reflections.Reflections;

import com.adventofcode.AoCSolution;
import com.adventofcode.annotations.Solution;

public class SolutionsLoader {
  public static AoCSolution getSolution(int year, int day) {
    Reflections reflections = new Reflections("com.adventofcode");
    Set<Class<?>> solutions = reflections.getTypesAnnotatedWith(Solution.class);
    for (Class<?> clazz : solutions) {
      Solution annotation = clazz.getAnnotation(Solution.class);
      if (annotation != null && annotation.year() == year && annotation.day() == day) {
        try {
          return (AoCSolution) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
          e.printStackTrace();
          break;
        }
      }
    }
    return null;
  }
}
