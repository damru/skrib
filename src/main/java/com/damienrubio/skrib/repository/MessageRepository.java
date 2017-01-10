package com.damienrubio.skrib.repository;

import com.damienrubio.skrib.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by damien on 09/01/2017.
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
}
