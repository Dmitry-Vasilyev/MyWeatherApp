
package com.example.dimav.myweatherapp.data.models.weathermodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherModel {

    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<com.example.dimav.myweatherapp.data.models.weathermodel.List> list = null;

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<com.example.dimav.myweatherapp.data.models.weathermodel.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.dimav.myweatherapp.data.models.weathermodel.List> list) {
        this.list = list;
    }

}
