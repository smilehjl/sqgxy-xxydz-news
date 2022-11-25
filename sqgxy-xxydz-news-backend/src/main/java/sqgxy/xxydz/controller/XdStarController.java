package sqgxy.xxydz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sqgxy.xxydz.dto.XdstarPageDto;
import sqgxy.xxydz.entity.XdStar;
import sqgxy.xxydz.service.XdStarService;
import sqgxy.xxydz.vo.Result;


import java.util.Date;
import java.util.List;


/**
 * @author lzj
 * @date 2022-11-23 15:41
 */

@Api(tags = "信电之星")
@RestController
@RequestMapping("/XdStar")
public class XdStarController {

    @Autowired
    XdStarService xdStarService;

    @ApiOperation(value = "查询所有先进事例")
    @GetMapping("/all")
    public Result getAll(){
        List<XdStar> list = xdStarService.list();
        return new Result().ok().data(list);
    }

    @ApiOperation(value = "根据Id查询先进事例")
    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        XdStar byId = xdStarService.getById(id);
        return new Result().ok().data(byId);
    }


    @ApiOperation(value = "添加先进事例")
    @PutMapping
    public Result save(@RequestBody XdStar xdstar ){
        xdstar.setCreateTime(new Date());
        boolean issave = xdStarService.save(xdstar);
        if (issave){
            return new Result().ok();
        }
        return new Result().fail("添加失败！");
    }

    @ApiOperation(value = "删除先进事例")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean isremove = xdStarService.removeById(id);
        if (isremove){
            return new Result().ok();
        }
        return new Result().fail("删除失败！");
    }

    @ApiOperation(value = "修改先进事例")
    @PostMapping
    public Result updateById(@RequestBody XdStar xdstar ){
        xdstar.setUpdateTime(new Date());
        boolean b = xdStarService.updateById(xdstar);
        if (b){
            return new Result().ok();
        }
        return  new Result().fail("修改失败！");
    }


    /**
     * 分页
     @ApiOperation(value = "分页查询)
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/querypage")
    public Result pageuser(@RequestParam int currentpage, @RequestParam int pagesize){
        XdstarPageDto Xdstardto = xdStarService.querypage(currentpage, pagesize);
        return new Result().ok().data(Xdstardto);
    }

    /**
     * 模糊查询姓名
     * @param name
     * @return
     */
    @ApiOperation(value = "根据姓名模糊查询")
    @GetMapping("/like")
    public Result findLikeByName(@RequestParam  String name){
        List<XdStar> xdstarlist = xdStarService.LikeByName(name);
        if (xdstarlist==null){
            return new Result().fail("查询失败");
        }
        return new Result().ok().data(xdstarlist);
    }




}
