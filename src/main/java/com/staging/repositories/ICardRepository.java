package com.staging.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.staging.models.Card;

@Repository
public interface ICardRepository extends CrudRepository<Card, Integer> {
	public List<Card> findAllBySuit(Card.Suit suit);
	public Card findBySuitAndValue(Card.Suit suit, int value);
}
