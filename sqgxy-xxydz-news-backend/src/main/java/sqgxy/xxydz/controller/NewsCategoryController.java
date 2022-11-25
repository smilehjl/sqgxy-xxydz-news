package sqgxy.xxydz.controller;

import sqgxy.xxydz.dto.NewsCategoryDTO;
import sqgxy.xxydz.dto.NewsCategorySaveDTO;
import sqgxy.xxydz.permission.annotation.SuperAdmin;
import sqgxy.xxydz.service.NewsCategoryService;
import sqgxy.xxydz.vo.Result;
import sqgxy.xxydz.vo.news.category.NewsCategoryAddVO;
import sqgxy.xxydz.vo.news.category.NewsCategoryListVO;
import sqgxy.xxydz.vo.news.category.NewsCategoryUpdateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xmp
 * @date 2022-11-19 13:51
 */
@Api(tags = "新闻类别操作（二级标题）")
@RestController
@RequestMapping("/news_category")
public class NewsCategoryController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsCategoryService newsCategoryService;

    @SuperAdmin
    @ApiOperation(value = "添加新闻类别")
    @PostMapping("/add")
    public Result addNewsCategory(NewsCategoryAddVO vo){
        return new Result().ok().data(newsCategoryService.saveNewsCategory(modelMapper.map(vo, NewsCategorySaveDTO.class)));
    }

    @SuperAdmin
    @ApiOperation(value = "删除新闻类别")
    @PostMapping("/delete")
    public Result deleteNewsCategory(Integer id) {
        return new Result().ok().data(newsCategoryService.removeNewsCategoryById(id));
    }

    @SuperAdmin
    @ApiOperation(value = "修改新闻类别")
    @PostMapping("/update")
    public Result updateNewsCategory(@RequestBody NewsCategoryUpdateVO vo) {
        return new Result().ok().data(newsCategoryService.updateNewsCategoryById(modelMapper.map(vo, NewsCategoryDTO.class)));
    }

    @ApiOperation(value = "查询全部新闻类别")
    @GetMapping("/all")
    public Result queryAll() {
        return new Result().ok().data(newsCategoryService.queryAll());
    }

    @ApiOperation(value = "查询新闻类别列表根据新闻类型id（大标题id）")
    @GetMapping("/list/{typeId}")
    public Result queryByNewsTypeId(@PathVariable("typeId") Integer id) {
        List<NewsCategoryDTO> list = newsCategoryService.queryNewCategoryByNewsTypeDd(id);
        return new Result().ok().data(modelMapper.map(list, new TypeToken<List<NewsCategoryListVO>>(){}.getType()));
    }
}
