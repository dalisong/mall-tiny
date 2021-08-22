package com.suntrip.hms.modules.hms.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
/**
 * @Author lizh
 * @create 2021-8-18 23:08
 */
@Getter
@Setter
public class CityInfo {

    @JsonIgnore
    @ApiModelProperty(value = "国家ID", required = true)
    private String countryId;

    @ApiModelProperty(value = "国家", required = true)
    private String countryName;

    @JsonIgnore
    @ApiModelProperty(value = "省份ID")
    private String provinceId;

    @ApiModelProperty(value = "省份")
    private String provinceName;

    @NotEmpty
    @ApiModelProperty(value = "城市ID")
    private String cityId;

    @NotEmpty
    @ApiModelProperty(value = "城市")
    private String cityName;

    @ApiModelProperty(value = "全称（包括国家/省份）")
    private String fullName ;
    public String getFullName() {
        StringBuilder result = new StringBuilder();
        String provinceHoldStr = "all cities";
        result.append(this.countryName);
        if ( !this.provinceName.equals((provinceHoldStr)) ){
            result.append("/");
            result.append(this.provinceName);
        }
        if ( !this.provinceName.equals(this.cityName)){
            result.append("/");
            result.append(this.cityName);
        }
        return result.toString();
    }
}
