package sqgxy.xxydz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import sqgxy.xxydz.dto.*;
import sqgxy.xxydz.entity.News;
import sqgxy.xxydz.entity.NewsCategory;
import sqgxy.xxydz.enums.DisplayContent;
import sqgxy.xxydz.exception.HintException;
import sqgxy.xxydz.mapper.NewsCategoryMapper;
import sqgxy.xxydz.mapper.NewsMapper;
import sqgxy.xxydz.module.HeaderImgUpload;
import sqgxy.xxydz.service.NewsCategoryService;
import sqgxy.xxydz.service.NewsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author xmp
 * @date 2022-11-19 13:32
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    NewsCategoryMapper newsCategoryMapper;

    @Override
    public boolean saveNews(NewsAddDTO dto) throws IOException {
        if (nonentityNewsCategory(dto.getNewsCategoryId())) {
            throw new HintException("此新闻类别不存在");
        }
        Integer newCategoryId = dto.getNewsCategoryId();
        NewsCategory newsCategory = newsCategoryMapper.selectOne(new QueryWrapper<NewsCategory>().select(NewsCategoryService.DISPLAY_CONTENT).eq(NewsCategoryService.ID, newCategoryId));
        // 小标题为新闻类型时，该标题下只能存储一篇新闻
        if (newsCategory.getDisplayContent() == DisplayContent.NEWS) {
            // 检查该标题下是否存在新闻
            int count = count(new QueryWrapper<News>().eq(NEWS_CATEGORY_ID, newCategoryId));
            if (count >= 10) {//todo
                throw new HintException("该类别下只能存在一篇新闻");
            }
        }
        // 判断图片是否为空
        if (dto.getPictureFile() != null) {
            String s = HeaderImgUpload.headPortraitUpload(dto.getPictureFile());
            dto.setPicturePath(s);
        }
        return save(modelMapper.map(dto, News.class));
    }

    @Override
    public boolean removeNews(Integer id) {
        return removeById(id);
    }

    @Override
    public boolean updateNews(NewsUpdateDTO dto) throws IOException {
        // 查看新闻是否存在
        int count1 = count(new QueryWrapper<News>().eq(ID, dto.getId()));
        if (count1 < 1) {
            throw new HintException("id为" + dto.getId() + "的新闻不存在");
        }
        if (dto.getNewsCategoryId() != null && nonentityNewsCategory(dto.getNewsCategoryId())) {
            throw new HintException("此新闻类别不存在");
        }
        // dto.getNewsCategoryId() 不为null 说明新闻类别可能会更改，需要判断更改后的类别是否是只能存储一篇新闻的展示新闻类型
        if (dto.getNewsCategoryId() != null) {
            Integer newCategoryId = dto.getNewsCategoryId();
            NewsCategory newsCategory = newsCategoryMapper.selectOne(new QueryWrapper<NewsCategory>().select(NewsCategoryService.DISPLAY_CONTENT).eq(NewsCategoryService.ID, newCategoryId));
            if (newsCategory.getDisplayContent() == DisplayContent.NEWS) {
                // 检查该标题下是否存在新闻
                int count = count(new QueryWrapper<News>().eq(NEWS_CATEGORY_ID, newCategoryId));
                if (count >= 1) {
                    throw new HintException("该类别下只能存在一篇新闻");
                }
            }
        }
        // 需要修改图片
        if (dto.getPictureFile() != null) {
            String s = HeaderImgUpload.headPortraitUpload(dto.getPictureFile());
            dto.setPicturePath(s);
        }
        return updateById(modelMapper.map(dto, News.class));
    }

    @Override
    public NewsPaging getNewsListByNewsCategoryId(Integer newsCategoryId, Integer current, Integer size) {
        Page<News> page = page(new Page<>(current, size), new QueryWrapper<News>().select(ID, TITLE, RELEASE_TIME, PICTURE_PATH).eq(NEWS_CATEGORY_ID, newsCategoryId).orderByDesc(RELEASE_TIME));
        NewsPaging newsPaging = modelMapper.map(page, NewsPaging.class);
        List<News> records = page.getRecords();
        newsPaging.setRecords(modelMapper.map(records, new TypeToken<List<NewsQueryListDTO>>(){}.getType()));
        return newsPaging;
    }

    @Override
    public NewsQueryDTO getNewsById(Integer id) {
        // 新闻点击率加一
        News one = getOne(new QueryWrapper<News>().select(HITS).eq(ID, id));
        if (one == null) {
            return null;
        }
        update(new UpdateWrapper<News>().set(HITS, one.getHits() + 1).eq(ID, id));
        return modelMapper.map(getById(id), NewsQueryDTO.class);
    }

    @Override
    public NewsPaging fuzzyQueryListByTitle(String title, Integer current, Integer size) {
        Page<News> page = page(new Page<>(current, size), new QueryWrapper<News>().select(ID, TITLE, RELEASE_TIME, PICTURE_PATH).like(TITLE, title).orderByDesc(RELEASE_TIME));
        NewsPaging newsPaging = modelMapper.map(page, NewsPaging.class);
        List<News> records = page.getRecords();
        newsPaging.setRecords(modelMapper.map(records, new TypeToken<List<NewsQueryListDTO>>(){}.getType()));
        return newsPaging;
    }

    /**
     * 不存在 NewsCategory
     */
    private boolean nonentityNewsCategory(Integer newsCategoryId) {
        Integer count = newsCategoryMapper.selectCount(new QueryWrapper<NewsCategory>().eq(NewsCategoryService.ID, newsCategoryId));
        return count < 1;
    }
}
