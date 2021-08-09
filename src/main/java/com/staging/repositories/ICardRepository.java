package com.staging.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.staging.models.Card;

@Repository
public interface ICardRepository extends CrudRepository<Card, Integer> {
	public List<Card> findAllBySuit(int suit);
	public Card findBySuitAndValue(int suit, int value);
}
