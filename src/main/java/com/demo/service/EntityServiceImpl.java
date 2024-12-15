package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DtoReq;
import com.demo.entity.MyEntity;
import com.demo.repository.MyEntityRepo;

@Service
public class EntityServiceImpl implements EntityService {

	private MyEntityRepo myEntityRepo;

	public EntityServiceImpl(MyEntityRepo myEntityRepo) {
		this.myEntityRepo=myEntityRepo;
	}

	@Override
	public  MyEntity save(MyEntity entity) {
		return myEntityRepo.save(entity);
	}

	@Override
	public List<MyEntity> getAll() {
		return myEntityRepo.findAll();
	}

	@Override
	public Optional<MyEntity> getById(int id) {
		return myEntityRepo.findById(id);
	}

	@Override
	public void deleteById(int n) {
		myEntityRepo.deleteById(n);

	}

	@Override
	public DtoReq update(DtoReq obj) {
		MyEntity myEntity = new MyEntity ();
		 BeanUtils.copyProperties(obj, myEntity);
		 MyEntity save = myEntityRepo.save(myEntity);
		 BeanUtils.copyProperties(save, obj);
		 return obj;
	}




}
