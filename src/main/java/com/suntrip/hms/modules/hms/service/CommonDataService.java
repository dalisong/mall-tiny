package com.suntrip.hms.modules.hms.service;

import com.suntrip.hms.modules.hms.dto.CityInfo;
import com.suntrip.hms.modules.hms.model.District;

import java.util.List;

/**
 * @Author lizh
 * @create 2021-8-17 22:31
 */
public interface CommonDataService {
    /**
     * 获取城市列表
     * @param keyword
     * @return
     */
  List<CityInfo> getCityList(String keyword);

    /***
     * 获取热门城市
     * @return
     */
  List<CityInfo> getHotCityList();

    /**
     * 获取行政区
     * @param cityId
     * @return
     */
  List<District> getDistrictList(Long cityId);


}
