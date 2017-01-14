package com.damienrubio.skrib.repository;

import com.damienrubio.skrib.model.UserSettings;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by damien on 09/01/2017.
 */
public interface UserSettingsRepository extends CrudRepository<UserSettings, Long> {

    UserSettings findByUserId(Long userId);

}
