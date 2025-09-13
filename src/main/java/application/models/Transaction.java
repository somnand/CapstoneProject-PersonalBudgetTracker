package application.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction
{
	public static final int INCOME = 1;
	public static final int EXPENSE = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trans_id",updatable = false,nullable = false,columnDefinition="UUID")
	protected UUID transactionId;
	
	@Column(name = "trans_type")
	@JsonProperty("trans_type")
	protected TransactionType transactionType;
	
	@Column(name = "trans_value")
	@JsonProperty("trans_value")
	protected Double transactionValue;
	
	@Column(name = "trans_category_type",nullable = true)
	@JsonProperty("trans_category_type")	
	protected CategoryType categoryType;
	
	@CreationTimestamp
	@Column(name = "trans_time",updatable = false,nullable = false)
	protected LocalDateTime transactionTime;
	
	public void setTransactionType() {}

	@Override
	public String toString()
	{
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", transactionValue=" + transactionValue + ", transactionTime=" + transactionTime + "]";
	};
	
}
