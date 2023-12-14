package com.dev.BookMyShow.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
	@Id
	private long id;
	
	@LastModifiedDate
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@CreatedDate
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;

}
