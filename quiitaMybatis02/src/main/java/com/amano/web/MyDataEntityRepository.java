package com.amano.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amano.web.model.MyDataModel;

@Repository
public interface MyDataEntityRepository extends JpaRepository<MyDataModel, Integer> {

	List<MyDataModel> findByName(String find);
}
