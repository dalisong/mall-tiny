package com.suntrip.hms.modules.hms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suntrip.hms.modules.hms.dto.CityInfo;
import com.suntrip.hms.modules.hms.mapper.CityMapper;
import com.suntrip.hms.modules.hms.mapper.DistrictMapper;
import com.suntrip.hms.modules.hms.model.District;
import com.suntrip.hms.modules.hms.service.CommonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lizh
 * @create 2021-8-18 23:50
 */
@Service
public class CommonDataServiceImpl implements CommonDataService {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<CityInfo> getCityList(String keyword){
        return cityMapper.getCityList(keyword);
    }

    @Override
    public List<District> getDistrictList(Long cityId){
        QueryWrapper<District> wrapper = new QueryWrapper<>();

        LambdaQueryWrapper<District> lambda = wrapper.lambda();        if(cityId!=null){
            lambda.eq(District::getCityId,cityId);
        }
      return districtMapper.selectList(wrapper);
    }

    @Override
    public List<CityInfo> getHotCityList(){
        return cityMapper.getHotCityList();
    }


}
