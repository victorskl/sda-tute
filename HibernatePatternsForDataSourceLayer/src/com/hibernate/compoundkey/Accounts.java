package com.hibernate.compoundkey;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {

    private CompoundKey compundKey;

    private int accountBalance;

    @Id
    public CompoundKey getCompundKey() {
	return compundKey;
    }

    public void setCompundKey(CompoundKey compundKey) {
	this.compundKey = compundKey;
    }

    public int getAccountBalance() {
	return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
	this.accountBalance = accountBalance;
    }
}
