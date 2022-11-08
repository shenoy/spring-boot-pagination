package dev.shenoy.jpapaging.repository;

import dev.shenoy.jpapaging.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {
}
