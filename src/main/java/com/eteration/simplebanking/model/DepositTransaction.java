package com.eteration.simplebanking.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DEPOSIT")
public class DepositTransaction  {
}
