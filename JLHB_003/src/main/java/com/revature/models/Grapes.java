package com.revature.models;

public class Grapes {
	
	private String name;
	
	private int seeds;

	
	
	
	public Grapes() {
		super();
	}

	public Grapes(String name, int seeds) {
		super();
		this.name = name;
		this.seeds = seeds;
	}
	
	
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeeds() {
		return seeds;
	}

	public void setSeeds(int seeds) {
		this.seeds = seeds;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + seeds;
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
		Grapes other = (Grapes) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seeds != other.seeds)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grapes [name=" + name + ", seeds=" + seeds + "]";
	}
	
	

}
