package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.DtoReq;
import com.demo.entity.MyEntity;

public interface EntityService {

	public MyEntity save(MyEntity entity);

	public List<MyEntity> getAll();

	public Optional<MyEntity> getById(int id);

	public void deleteById(int id);

	public DtoReq update(DtoReq obj);
	
}
