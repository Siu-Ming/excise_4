package com.shm.dao;


import com.shm.tools.JdbcUtils;
import com.shm.vo.City;
import com.shm.vo.Province;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ProvinceCiteDao
 * @CreateTime: 2020/10/17 14:11
 * @Description: 用于查询省和城市
 */

public class ProvinceCiteDao {

    public List<Province> queryProvince() {
        List<Province> list = new ArrayList<Province>();
        ResultSet resultSet;
        try {
            resultSet = JdbcUtils.query("SELECT * FROM t_province");
            while (resultSet.next()) {
                Province province = new Province();
                province.setP_id(resultSet.getInt(1));
                province.setProvince(resultSet.getString(2));
                list.add(province);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("省份查询失败！");
        }
        return list;
    }

    public List<City> queryCity(int p_id) {
        List<City> list = new ArrayList<City>();
        ResultSet resultSet;
        try {
            resultSet = JdbcUtils.query("SELECT * FROM t_city WHERE p_id=?",p_id);
            while (resultSet.next()) {
                City city = new City();
                city.setC_id(resultSet.getInt(1));
                city.setCity(resultSet.getString(2));
                city.setP_id(resultSet.getInt(3));
                list.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("省份查询失败！");
        }
        return list;
    }

}
