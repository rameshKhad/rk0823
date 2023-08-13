package com.toolRental.repository;


import com.toolRental.domain.constant.Brand;
import com.toolRental.domain.Tool;
import com.toolRental.domain.constant.ToolCode;
import com.toolRental.domain.constant.ToolType;

import java.util.HashMap;
import java.util.Map;

public class ToolsRepository {
    private static ToolsRepository instance;

    private ToolsRepository() {}

    public static ToolsRepository getToolsRepository() {
        if (instance == null) {
            instance = new ToolsRepository();
        }
        return instance;
    }
    public Map<String, Tool>  getTools(){
        Map<String, Tool> tools = new HashMap<>();
        tools.put(ToolCode.LADW.toString(), getTool(ToolCode.LADW.toString(),ToolType.Ladder.toString(),Brand.Werner.toString(),1.99,true,true,false));
        tools.put(ToolCode.CHNS.toString(), getTool(ToolCode.CHNS.toString(), ToolType.Chainsaw.toString(), Brand.Stihl.toString(), 1.49, true, false, true));
        tools.put(ToolCode.JAKD.toString(), Tool.builder().toolCode(ToolCode.JAKD.toString()).toolType(ToolType.Jackhammer.toString()).brand(Brand.DeWalt.toString()).dailyCharge(2.99).weekdayCharge(true).weekendCharge(false).holidayCharge(false).build());
        tools.put(ToolCode.JAKR.toString(), Tool.builder().toolCode(ToolCode.JAKR.toString()).toolType(ToolType.Jackhammer.toString()).brand(Brand.Ridgid.toString()).dailyCharge(2.99).weekdayCharge(true).weekendCharge(false).holidayCharge(false).build());
        return tools;
    }

    private static Tool getTool(String toolCode, String toolType, String brand, double dailyCharge, boolean weekdayCharge, boolean weekendCharge,boolean holidayCharge ) {
        return Tool.builder()
                .toolCode(toolCode)
                .toolType(toolType)
                .brand(brand)
                .dailyCharge(dailyCharge)
                .weekdayCharge(weekdayCharge)
                .weekendCharge(weekendCharge)
                .holidayCharge(holidayCharge)
                .build();
    }
}