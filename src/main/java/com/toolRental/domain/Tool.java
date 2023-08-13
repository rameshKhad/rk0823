package com.toolRental.domain;

public class Tool {
    public String getToolCode() {
        return toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public String getBrand() {
        return brand;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public boolean isWeekdayCharge() {
        return weekdayCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }

    private String toolCode;
    private String toolType;
    private String brand;
    private double dailyCharge;
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    Tool(String toolCode, String toolType, String brand, double dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public static ToolBuilder builder() {
        return new ToolBuilder();
    }

    public static class ToolBuilder {
        private String toolCode;
        private String toolType;
        private String brand;
        private double dailyCharge;
        private boolean weekdayCharge;
        private boolean weekendCharge;
        private boolean holidayCharge;

        ToolBuilder() {
        }

        public ToolBuilder toolCode(String toolCode) {
            this.toolCode = toolCode;
            return this;
        }

        public ToolBuilder toolType(String toolType) {
            this.toolType = toolType;
            return this;
        }

        public ToolBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public ToolBuilder dailyCharge(double dailyCharge) {
            this.dailyCharge = dailyCharge;
            return this;
        }

        public ToolBuilder weekdayCharge(boolean weekdayCharge) {
            this.weekdayCharge = weekdayCharge;
            return this;
        }

        public ToolBuilder weekendCharge(boolean weekendCharge) {
            this.weekendCharge = weekendCharge;
            return this;
        }

        public ToolBuilder holidayCharge(boolean holidayCharge) {
            this.holidayCharge = holidayCharge;
            return this;
        }

        public Tool build() {
            return new Tool(this.toolCode, this.toolType, this.brand, this.dailyCharge, this.weekdayCharge, this.weekendCharge, this.holidayCharge);
        }

        public String toString() {
            return "Tool.ToolBuilder(toolCode=" + this.toolCode + ", toolType=" + this.toolType + ", brand=" + this.brand + ", dailyCharge=" + this.dailyCharge + ", weekdayCharge=" + this.weekdayCharge + ", weekendCharge=" + this.weekendCharge + ", holidayCharge=" + this.holidayCharge + ")";
        }
    }
}
