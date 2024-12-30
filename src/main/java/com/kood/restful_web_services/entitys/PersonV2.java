package com.kood.restful_web_services.entitys;

public class PersonV2 {
	public FullName name;

	public PersonV2(FullName name) {
		super();
		this.name = name;
	}

	public FullName getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}

}
