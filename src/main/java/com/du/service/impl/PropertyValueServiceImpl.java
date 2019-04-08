package com.du.service.impl;

import com.du.mapper.PropertyValueMapper;
import com.du.pojo.Product;
import com.du.pojo.Property;
import com.du.pojo.PropertyValue;
import com.du.pojo.PropertyValueExample;
import com.du.service.PropertyService;
import com.du.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService{
    @Autowired
    private PropertyValueMapper propertyValueMapper;

    @Autowired
    private PropertyService propertyService;
    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv  : result){
            Property property = propertyService.get(pv.getPtid());
            pv.setProperty(property);
        }
        return result;
    }

    @Override
    public void init(Product product) {
        List<Property> pts = propertyService.list(product.getCid());
        for (Property pt : pts){
            PropertyValue pv = get(pt.getId(),product.getId());
            if (null==pv){
                pv = new PropertyValue();
                pv.setPid(product.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }
    }

    @Override
    public void update(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
        if (pvs.isEmpty()){
            return null;
        }
        return pvs.get(0);
    }
}
