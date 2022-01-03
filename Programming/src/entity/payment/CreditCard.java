package entity.payment;

import java.sql.Timestamp;

/**
 * Represent a credit card.
 *
 * @author Group4
 *
 */
public class CreditCard {
	private String cardCode;
	private String owner;
	private int cvvCode;
	private String dateExpired;

	public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
		super();
		this.cardCode = cardCode;
		this.owner = owner;
		this.cvvCode = cvvCode;
		this.dateExpired = dateExpired;
	}
}
