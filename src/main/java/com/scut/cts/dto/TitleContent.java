package com.scut.cts.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tutorial")
public class TitleContent
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tutoId;
	private String titleContent;
	private String titleNum;
}
