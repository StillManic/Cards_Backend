package com.staging.services;

import java.util.List;

import com.staging.models.Card;

public interface ICardService {
	public Card get(int id);
	public Card getBySuitAndValue(String suit, int value);
	public List<Card> getAll();
	public List<Card> getAllBySuit(int suit);
	public Card add(Card c);
	public Card update(Card c);
	public void delete(int id);
}
