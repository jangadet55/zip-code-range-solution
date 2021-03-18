package com.app.main.model;

/**
 *This is all about to define the Range bound
 */
public class RangeLimit {
    private int maxRangeBound;
    private int minRangeBound;

    public RangeLimit(int lowerBound, int upperBound) {
        if (lowerBound <= upperBound) {
            this.minRangeBound = lowerBound;
            this.maxRangeBound = upperBound;
        } else {
            this.minRangeBound = upperBound;
            this.maxRangeBound = lowerBound;
        }
    }

    public int getMaxRangeBound() {
        return maxRangeBound;
    }

    public void setMaxRangeBound(int maxRangeBound) {
        this.maxRangeBound = maxRangeBound;
    }

    public int getMinRangeBound() {
        return minRangeBound;
    }

    public void setMinRangeBound(int minRangeBound) {
        this.minRangeBound = minRangeBound;
    }

    /**
     * This method is override because of format the integer value to string
     * @return
     */
    public String formatString() {
        return String.format("[%d,%d]", this.minRangeBound, this.maxRangeBound);
    }
}