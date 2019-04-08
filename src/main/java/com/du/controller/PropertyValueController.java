package com.du.controller;

import com.du.pojo.Product;
import com.du.pojo.PropertyValue;
import com.du.service.ProductService;
import com.du.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    private PropertyValueService propertyValueService;
    @Autowired
    private ProductService productService;
    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model,int pid){
        Product p = productService.get(pid);
        propertyValueService.init(p);
        List<PropertyValue>  pvs = propertyValueService.list(p.getId());

        model.addAttribute("p",p);
        model.addAttribute("pvs",pvs);
        return "admin/editPropertyValue";
    }
    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue propertyValue){
        propertyValueService.update(propertyValue);
        return "success";
    }
}
