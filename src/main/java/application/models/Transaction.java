package application.models;

import java.sql.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Transaction
{
	public static final int INCOME = 1;
	public static final int EXPENSE = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trans_id",updatable = false,nullable = false,columnDefinition="UUID")
	protected UUID transactionId;
	@Column(name = "trans_type")
	protected int transactionType;
	@Column(name = "trans_value")
	protected int transactionValue;
	
	@CreationTimestamp
	@Column(name = "time",updatable = false,nullable = false)
	protected Date transactionTime;
	
	public void setTransactionType() {};
}
