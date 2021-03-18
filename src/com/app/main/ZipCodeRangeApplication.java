package com.app.main;

import com.app.main.model.RangeLimit;

import java.util.ArrayList;
import java.util.ListIterator;

public class ZipCodeRangeApplication {

    private static ArrayList<RangeLimit> rangeLimits = new ArrayList<>();

    /**
     * @param rangeLimit It will accept the rangeLimit List
     */
    public static void findMinimumRange(RangeLimit rangeLimit) {
        if (rangeLimits.size() == 0) {
            rangeLimits.add(rangeLimit);
        } else {
            ListIterator<RangeLimit> limitListIterator = rangeLimits.listIterator();
            boolean isValidRange = true;

            while (limitListIterator.hasNext()) {
                RangeLimit findNextRange = limitListIterator.next();
                if (rangeLimit.getMinRangeBound() >= findNextRange.getMinRangeBound() && rangeLimit.getMaxRangeBound() <= findNextRange.getMaxRangeBound()) {
                    isValidRange = false;
                } else if (rangeLimit.getMinRangeBound() > findNextRange.getMaxRangeBound() || rangeLimit.getMaxRangeBound() < findNextRange.getMinRangeBound()) {
                    isValidRange = true;
                } else if (rangeLimit.getMinRangeBound() < findNextRange.getMinRangeBound() && rangeLimit.getMaxRangeBound() > findNextRange.getMaxRangeBound()) {
                    limitListIterator.remove();
                    isValidRange = true;
                } else if (rangeLimit.getMinRangeBound() < findNextRange.getMinRangeBound() && rangeLimit.getMaxRangeBound() < findNextRange.getMaxRangeBound()) {
                    rangeLimit.setMaxRangeBound(findNextRange.getMaxRangeBound());
                    limitListIterator.remove();
                    isValidRange = true;
                } else if (rangeLimit.getMinRangeBound() > findNextRange.getMinRangeBound() && rangeLimit.getMaxRangeBound() > findNextRange.getMaxRangeBound()) {
                    rangeLimit.setMinRangeBound(findNextRange.getMinRangeBound());
                    limitListIterator.remove();
                    isValidRange = true;
                }
            }

            if (isValidRange) {
                rangeLimits.add(rangeLimit);
            }
        }
    }

    /**
     * This method will be responsible for print minimum range based on every range object in rangelist
     */
    public static void displayMinimumRangeLimit() {
        if (rangeLimits.size() > 0) {
            for (RangeLimit range : rangeLimits) {
                System.out.println(range.formatString());
            }
        }
    }


    /**
     * Main mentod to test the Apps by passing the Range Limit
     *
     * @param args
     */
    public static void main(String[] args) {
        RangeLimit firstLimit = new RangeLimit(94133, 94133);
        RangeLimit secondLimit = new RangeLimit(94200, 94299);
        RangeLimit thirdLimit = new RangeLimit(94600, 94699);

        ZipCodeRangeApplication.findMinimumRange(firstLimit);
        ZipCodeRangeApplication.findMinimumRange(secondLimit);
        ZipCodeRangeApplication.findMinimumRange(thirdLimit);
        ZipCodeRangeApplication.displayMinimumRangeLimit();
    }
}