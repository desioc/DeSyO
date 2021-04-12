package com.cdsc.desyo;

public abstract class Resource {
	private String name;
	private String path;

	
	public Resource(String path) {
		//this(getDefaultName(), path);
	}

	/* 
	 * return the default name taken from the last part of the path
	 */
	protected abstract String getDefaultName();

	public Resource(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
