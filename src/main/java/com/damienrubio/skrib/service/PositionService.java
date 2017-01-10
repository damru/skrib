package com.damienrubio.skrib.service;

import com.damienrubio.skrib.model.Position;
import org.springframework.stereotype.Service;

/**
 * Created by damien on 09/01/2017.
 */
@Service
public class PositionService {

    public Long distanceBetweenPositionAndMessage(Position userPosition, Position messagePosition) {
        return 1000L;
    }

}
