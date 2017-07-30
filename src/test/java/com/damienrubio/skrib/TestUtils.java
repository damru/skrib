package com.damienrubio.skrib;

import org.apache.commons.text.RandomStringGenerator;

/**
 * Created by damien on 29/07/2017.
 */
public class TestUtils {

    public static String randomString() {
        return new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(8);
    }


}
