package com.mbstu.ehcare.controller.LogicDoc;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
abstract public class BaseInfo {

	@CreatedDate
	private Date createdDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private Date modifiedDate;
	@LastModifiedBy
	private String modifiedBy;
	private boolean enabled;
	@Column(nullable=false)
	private boolean deleted;

}
