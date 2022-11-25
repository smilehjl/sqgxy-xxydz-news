package sqgxy.xxydz.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sqgxy.xxydz.entity.Information;
import sqgxy.xxydz.service.InformationService;
import sqgxy.xxydz.vo.Result;

import java.util.Date;
import java.util.List;

/**
 * @author xmp
 * @date 2022-11-14 00:25
 */

@Api(tags = "学院联系方式")
@RestController
@RequestMapping("/Information")
public class InformationController {

    @Autowired
    InformationService informationService;

    @ApiOperation(value = "查询所有学院联系方式")
    @GetMapping("/all")
    public Result getAll(){
        List<Information> list = informationService.list();
        return new Result().ok().data(list);
    }

    @ApiOperation(value = "根据Id查询学院联系方式")
    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        Information byId = informationService.getById(id);
        return new Result().ok().data(byId);
    }


    @ApiOperation(value = "添加学院联系方式")
    @PutMapping
    public Result save(@RequestBody Information information ){
        information.setCreateTime(new Date());
        boolean issave = informationService.save(information);
        if (issave){
            return new Result().ok();
        }
        return new Result().fail("添加失败！");
    }

    @ApiOperation(value = "删除学院联系方式")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean isremove = informationService.removeById(id);
        if (isremove){
            return new Result().ok();
        }
        return new Result().fail("删除失败！");
    }

    @ApiOperation(value = "修改学院联系方式")
    @PostMapping
    public Result updateById(@RequestBody Information information ){
        information.setUpdateTime(new Date());
        boolean b = informationService.updateById(information);
        if (b){
            return new Result().ok();
        }
        return  new Result().fail("修改失败！");
    }

}
