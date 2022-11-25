package sqgxy.xxydz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import sqgxy.xxydz.dto.NewsCategoryDTO;
import sqgxy.xxydz.dto.NewsCategoryQueryAllDTO;
import sqgxy.xxydz.dto.NewsCategorySaveDTO;
import sqgxy.xxydz.entity.NewsCategory;
import sqgxy.xxydz.entity.NewsType;
import sqgxy.xxydz.exception.HintException;
import sqgxy.xxydz.mapper.NewsCategoryMapper;
import sqgxy.xxydz.mapper.NewsTypeMapper;
import sqgxy.xxydz.service.NewsCategoryService;
import sqgxy.xxydz.service.NewsTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xmp
 * @date 2022-11-19 16:32
 */
@Service
public class NewsCategoryServiceImpl extends ServiceImpl<NewsCategoryMapper, NewsCategory> implements NewsCategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsTypeMapper newsTypeMapper;

    @Override
    public boolean saveNewsCategory(NewsCategorySaveDTO dto) {
        if (nonentityNewsType(dto.getNewsTypeId())) {
            throw new HintException("此新闻类型不存在");
        }
        return save(modelMapper.map(dto, NewsCategory.class));
    }

    @Override
    public boolean removeNewsCategoryById(Integer id) {
        return removeById(id);
    }

    @Override
    public boolean updateNewsCategoryById(NewsCategoryDTO dto) {
        if (dto.getNewsTypeId() != null && nonentityNewsType(dto.getNewsTypeId())) {
            throw new HintException("此新闻类型不存在");
        }
        return updateById(modelMapper.map(dto, NewsCategory.class));
    }

    @Override
    public List<NewsCategoryQueryAllDTO> queryAll() {
        List<NewsCategory> list = list(new QueryWrapper<NewsCategory>().select(ID, NAME, NEWS_TYPE_ID, DISPLAY_CONTENT));
        return list.stream().map(this::newsTypeIdToString).collect(Collectors.toList());
    }

    @Override
    public List<NewsCategoryDTO> queryNewCategoryByNewsTypeDd(Integer newsTypeId) {
        List<NewsCategory> list = list(new QueryWrapper<NewsCategory>().select(ID, NAME, DISPLAY_CONTENT).eq(NEWS_TYPE_ID, newsTypeId));
        return modelMapper.map(list, new TypeToken<List<NewsCategoryDTO>>(){}.getType());
    }


    /**
     * 不存在 NewsType
     */
    private boolean nonentityNewsType(Integer newsTypeId) {
        Integer count = newsTypeMapper.selectCount(new QueryWrapper<NewsType>().eq(NewsTypeService.ID, newsTypeId));
        return count < 1;
    }

    /**
     * 通过NewsType 的 ID 获取 Name
     */
    public NewsCategoryQueryAllDTO newsTypeIdToString(NewsCategory newsCategory) {
        String name = newsTypeMapper.selectOne(new QueryWrapper<NewsType>().select(NewsTypeService.NAME).eq(NewsTypeService.ID, newsCategory.getNewsTypeId())).getName();
        NewsCategoryQueryAllDTO map = modelMapper.map(newsCategory, NewsCategoryQueryAllDTO.class);
        map.setNewsTypeName(name);
        return map;
    }
}
