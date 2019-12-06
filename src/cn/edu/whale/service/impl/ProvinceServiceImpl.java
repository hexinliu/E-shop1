package cn.edu.whale.service.impl;

import cn.edu.whale.dao.ProvinceDao;
import cn.edu.whale.dao.impl.ProvinceDaoImpl;
import cn.edu.whale.domain.Province;
import cn.edu.whale.service.ProvinceService;

import java.util.List;

/**
 * @Author: hexin Liu
 * @Description:
 * @Date: Created in 18:37 2019/11/17
 * @Modified By：
 */
public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }
}
