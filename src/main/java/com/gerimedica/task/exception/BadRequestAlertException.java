package com.gerimedica.task.exception;

public class BadRequestAlertException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BadRequestAlertException(String msg) {
    super(msg);
  }
}
