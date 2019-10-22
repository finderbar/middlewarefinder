package com.finder.middleware.domain;

import java.io.Serializable;
/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName(){
        return name;
    }

    public void setName(String name) {
      this.name = name;
    }
}