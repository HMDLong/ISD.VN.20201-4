package entity.payment;

import java.sql.SQLException;
import java.sql.Statement;

import entity.db.EcoDB;

/**
 * Represent a payment transaction.
 *
 * @author Group4
 *
 */
public class PaymentTransaction {
	private String errorCode;
	private CreditCard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
			int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	/**
	 * This method get error code
	 *
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	
	/**
	 * This method save the transaction to the database.
	 *
	 * @param invoice_id the id of invoice associated with the transaction
	 * @throws SQLException throw if error occurs during query process
	 */
	public void saveTransaction(int invoice_id) throws SQLException {
		Statement stm = EcoDB.getConnection().createStatement();
		String query = String.format("insert into paymenttransactions(transaction_id, create_at, content, invoice_id) values "
								   + "('%s', '%s', '%s', %d)", this.transactionId, this.createdAt, this.transactionContent, invoice_id);
		stm.executeQuery(query);
	}
}
