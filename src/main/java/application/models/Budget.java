package application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;

public class Budget 
{
	@Column(name = "budget_category_type",nullable = false)
	@JsonProperty("budget_category_type")
	private CategoryType categoryType;
	
	@Column(name = "budget_category_value")
	@JsonProperty("budget_category_value")
	private Double value;

}
