package com.staging.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staging.models.Card;
import com.staging.repositories.ICardRepository;

@Service
public class CardService implements ICardService {
	private ICardRepository cr;
	
	@Autowired
	public CardService(ICardRepository cr) {
		this.cr = cr;
	}
	
	@Override
	public Card get(int id) {
		return this.cr.findById(id).get();
	}
	
	@Override
	public Card getBySuitAndValue(String suit, int value) {
		return this.cr.findBySuitAndValue(Card.Suit.valueOf(suit.strip().toUpperCase()).ordinal(), value);
	}

	@Override
	public List<Card> getAll() {
		return (List<Card>) this.cr.findAll();
	}
	
	@Override
	public List<Card> getAllBySuit(int suit) {
//		Card.Suit cardSuit = Card.Suit.valueOf(suit.strip().toUpperCase());
		return this.cr.findAllBySuit(suit);
	}

	@Override
	public Card add(Card c) {
		return this.cr.save(c);
	}

	@Override
	public Card update(Card c) {
		return this.cr.save(c);
	}

	@Override
	public void delete(int id) {
		this.cr.deleteById(id);
	}	
}
