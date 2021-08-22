package com.suntrip.hms.modules.hms.controller;

import com.suntrip.hms.common.api.CommonResult;
import com.suntrip.hms.modules.hms.dto.CityInfo;
import com.suntrip.hms.modules.hms.model.District;
import com.suntrip.hms.modules.hms.service.CommonDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lizh
 * @create 2021-8-18 23:57
 */
@Controller
@Api(tags = "CommonDataController", description = "公共数据管理")
@RequestMapping("/commonData")
public class CommonDataController {

    @Autowired
    private CommonDataService dataService;

    @ApiOperation(value = "城市列表")
    @RequestMapping(value = {"/cityList/{cityName}","/cityList"}, method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CityInfo>> cityList(@PathVariable(value="cityName",required=false) String cityName) {
        List<CityInfo> cityList;
        cityList = cityName == null ? dataService.getHotCityList() : dataService.getCityList(cityName);
        if (cityList == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(cityList);
    }

    @ApiModelProperty(value = "行政区列表")
    @RequestMapping(value = "/districtList/{cityId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<District>> districtList(@PathVariable Long cityId) {
        List<District> districtList = dataService.getDistrictList(cityId);
        if (districtList == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(districtList);
    }

}
