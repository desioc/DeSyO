package com.cdsc.desyo;

import java.util.ArrayList;
import java.util.List;

public class Profile {
	private List<Resource> resources;

	public Profile() {
		resources = new ArrayList<>();
	}
	
	public void addResource(Resource resource) {
		resources.add(resource);
	}
	
	public List<Resource> getAllResources() {
		return resources;
	}
	
}
