package com.base.scaffold.entity.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaochong.fan
 * @version 1.0
 * @date 2022/5/30 17:28
 * @description: 城市字典
 */
@Data
@Builder(toBuilder = true)
public class DemoPO implements Serializable {
    private static final long serialVersionUID = 3505819326056231009L;

    private Integer id;
    private String name;
    private String countryCode;
    private String district;
    private Integer population;
}
