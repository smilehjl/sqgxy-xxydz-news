package sqgxy.xxydz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import sqgxy.xxydz.dto.NewsCategoryDTO;
import sqgxy.xxydz.dto.NewsCategoryQueryAllDTO;
import sqgxy.xxydz.dto.NewsCategorySaveDTO;
import sqgxy.xxydz.entity.NewsCategory;

import java.util.List;

/**
 * @author xmp
 * @date 2022-11-19 16:12
 */
public interface NewsCategoryService extends IService<NewsCategory> {

    String ID = "id";

    String NAME = "name";

    String NEWS_TYPE_ID = "news_type_id";

    String DISPLAY_CONTENT = "display_content";

    String CREATE_TIME = "create_time";

    String UPDATE_TIME = "update_time";

    /**
     * 添加新闻类别
     */
    boolean saveNewsCategory(NewsCategorySaveDTO dto);

    /**
     * 删除新闻类别
     */
    boolean removeNewsCategoryById(Integer id);

    /**
     * 修改新闻类别
     */
    boolean updateNewsCategoryById(NewsCategoryDTO dto);

    /**
     * 查询全部新闻类别
     */
    List<NewsCategoryQueryAllDTO> queryAll();

    /**
     * 按 NEWS_TYPE_ID 查找新闻类别
     */
    List<NewsCategoryDTO> queryNewCategoryByNewsTypeDd(Integer newsTypeId);
}
