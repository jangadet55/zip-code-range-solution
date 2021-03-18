package com.test;


import com.app.main.ZipCodeRangeApplication;
import com.app.main.model.RangeLimit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipCodeRangeApplicationTest {

    @BeforeAll
    static void setUp() throws Exception {
        System.out.println("********************");
    }

    @AfterAll
    static void tearDown() throws Exception {
        System.out.println("All Process completed");
    }

    @Test
    public void testDisplayMinimumRangeLimit() {
        System.out.println("Main test started...");
        RangeLimit firstLimit = new RangeLimit(94133, 94133);
        RangeLimit secondLimit = new RangeLimit(94200, 94299);
        RangeLimit thirdLimit = new RangeLimit(94600, 94699);

        ZipCodeRangeApplication.findMinimumRange(firstLimit);
        ZipCodeRangeApplication.findMinimumRange(secondLimit);
        ZipCodeRangeApplication.findMinimumRange(thirdLimit);

        assertTrue(firstLimit.getMaxRangeBound() == 94133);
        assertTrue(firstLimit.getMinRangeBound() == 94133);

        assertTrue(secondLimit.getMaxRangeBound() != 94199);
        assertTrue(secondLimit.getMinRangeBound() != 94300);

        assertTrue(thirdLimit.getMaxRangeBound() != 94600);
        assertTrue(thirdLimit.getMinRangeBound() != 94699);
        ZipCodeRangeApplication.displayMinimumRangeLimit();
    }
}
