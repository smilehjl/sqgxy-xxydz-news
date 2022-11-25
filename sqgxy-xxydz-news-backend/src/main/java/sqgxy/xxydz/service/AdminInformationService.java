package sqgxy.xxydz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import sqgxy.xxydz.dto.AdminInformationDTO;
import sqgxy.xxydz.dto.AdminInformationSaveDTO;
import sqgxy.xxydz.dto.AdminInformationUpdateDTO;
import sqgxy.xxydz.entity.AdminInformation;

import java.util.List;

/**
 * @author xmp
 * @date 2022-11-23 16:31
 */
public interface AdminInformationService extends IService<AdminInformation> {

    String ID = "id";

    String USERNAME = "username";

    String PASSWORD = "password";

    String ROLE = "role";

    String CREATE_TIME = "create_time";

    String UPDATE_TIME = "update_time";

    /**
     * 检验密码是否正确
     */
    void checkPassword(String username, String password);

    /**
     * 添加普通管理员信息
     */
    boolean saveAdminInformation(AdminInformationSaveDTO dto);

    /**
     * 删除管理员信息根据id
     */
    boolean removeAdminInformationById(Integer id);

    /**
     * 修改普通管理员密码
     */
    boolean updateAdminInformation(AdminInformationUpdateDTO dto);

    /**
     * 根据用户名查询管理员信息
     */
    AdminInformationDTO getAdminInformationByUsername(String username);

    /**
     * 查找普通管理员列表
     */
    List<AdminInformationDTO> getAdminInformationList();
}
