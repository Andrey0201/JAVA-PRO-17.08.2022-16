package com.javapro.lesson21.model;

import java.util.NoSuchElementException;

/**
 * @author Andrii Andriutsa on 31.10.2022
 */
public class NoFindElementException extends NoSuchElementException {

  public NoFindElementException(String message) {
    super(message);
  }
}

