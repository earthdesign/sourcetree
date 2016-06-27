package com.amano.web;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebAppApplication {
	@Autowired
	MyDataEntityRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebAppApplication.class, args);
	}

	@PostConstruct
	public void initialData(){
/*		repository.save(new MyDataModel("tuyano","syoda@tuyano"));
		repository.save(new MyDataModel("hanako","hanako@flower"));
		repository.save(new MyDataModel("sachiko","sachico@happy"));
		repository.save(new MyDataModel("taro","taro@yamada"));*/
		repository.flush();
	}
}
