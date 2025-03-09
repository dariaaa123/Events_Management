package org.launchcode.hello_spring.data;

import org.launchcode.hello_spring.models.EventCategory;
import org.springframework.data.repository.CrudRepository;

public interface EventCategoryRepository extends CrudRepository<EventCategory,Integer> {
}
