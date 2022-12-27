package com.devpro.javaweb22.model;

public interface MappingCustomEntity<E extends BaseEntity> {
	public E convert(Object[] data);
}
