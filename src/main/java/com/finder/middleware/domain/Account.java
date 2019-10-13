package com.finder.middleware.domain;

import java.io.Serializable;
/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
      this.name = name;
    }
}