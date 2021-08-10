package com.staging.models;

import java.util.Objects;

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
	
	private String card_img;
	
	public Card() {}
	
	public Card(Suit suit, Integer value, String card_img) {
		this.suit = suit;
		this.value = value;
		this.card_img = card_img;
	}

	public String getImage() {
		return card_img;
	}

	public void setImage(String card_img) {
		this.card_img = card_img;
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
		return Objects.hash(id, card_img, suit, value);
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
		return id == other.id && Objects.equals(card_img, other.card_img) && suit == other.suit && value == other.value;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", suit=" + suit + ", value=" + value + ", image=" + card_img + "]";
	}



}
