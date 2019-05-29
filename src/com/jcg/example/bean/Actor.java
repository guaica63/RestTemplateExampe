package com.jcg.example.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor implements Serializable {

	private static final long serialVersionUID = 7679620555959552912L;

	private Long id;

	private String login;

	private String avatar_url;
	
	public Actor(
		@JsonProperty("id") Long id,
		@JsonProperty("login") String login,
		@JsonProperty("avatar_url") String avatar_url) {
		this.id = id;
		this.login = login;
		this.avatar_url = avatar_url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", login=" + login + ", avatar_url=" + avatar_url + "]";
	}

	
	
}
