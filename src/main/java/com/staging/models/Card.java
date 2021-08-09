package com.staging.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "deck")
public class Card {
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "deck_id_seq")
	@Column(name = "id", insertable = false, updatable = false)
	private int id;
	
	@Enumerated(EnumType.ORDINAL)
	private Suit suit;
	
	private int value;
	
	public Card() {}
	
	public Card(Suit suit, Integer value) {
		this.suit = suit;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String getFace() {
		if (this.value >= 2 && this.value < 11) {
			return String.valueOf(this.value);
		} else {
			switch (this.value) {
				case 11: return "J";
				case 12: return "Q";
				case 13: return "K";
				case 14: return "A";
				default: return "0";
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (id != other.id)
			return false;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", suit=" + suit + ", value=" + value + ", getFace()=" + getFace() + "]";
	}
}
