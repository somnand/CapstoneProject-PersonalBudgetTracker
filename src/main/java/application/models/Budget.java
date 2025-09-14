package application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BUDGETS")
public class Budget 
{
	@Id
	@Column(name = "budget_category_type",nullable = false)
	@JsonProperty("budget_category_type")
	private CategoryType categoryType;
	
	@Column(name = "budget_category_value")
	@JsonProperty("budget_category_value")
	private Double value;
}
