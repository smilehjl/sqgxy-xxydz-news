package sqgxy.xxydz.controller;

import sqgxy.xxydz.dto.AdminInformationSaveDTO;
import sqgxy.xxydz.dto.AdminInformationUpdateDTO;
import sqgxy.xxydz.permission.annotation.GeneralAdmin;
import sqgxy.xxydz.permission.annotation.SuperAdmin;
import sqgxy.xxydz.service.AdminInformationService;
import sqgxy.xxydz.vo.Result;
import sqgxy.xxydz.vo.admin.AdminInformationAddVO;
import sqgxy.xxydz.vo.admin.AdminInformationUpdateVO;
import sqgxy.xxydz.vo.admin.AdminInformationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xmp
 * @date 2022-11-23 18:45
 */
@Api(tags = "管理员操作")
@RestController
@RequestMapping("/admin")
public class AdminInformationController {

    @Autowired
    private AdminInformationService adminInformationService;

    @Autowired
    private ModelMapper modelMapper;

    @SuperAdmin
    @ApiOperation(value = "添加普通管理员")
    @PostMapping("/add")
    public Result addAdminInformation(AdminInformationAddVO vo) {
        return new Result().ok().data(adminInformationService.saveAdminInformation(modelMapper.map(vo, AdminInformationSaveDTO.class)));
    }

    @SuperAdmin
    @ApiOperation(value = "删除普通管理员")
    @PostMapping("/delete")
    public Result deleteAdminInformation(Integer id) {
        return new Result().ok().data(adminInformationService.removeAdminInformationById(id));
    }

    @ApiOperation(value = "修改管理员密码")
    @PostMapping("/updatePassword")
    @GeneralAdmin
    public Result updateAdminPassword(AdminInformationUpdateVO vo) {
        // 校验密码
        adminInformationService.checkPassword(vo.getUsername(), vo.getOldPassword());

        return new Result().ok().data(adminInformationService.updateAdminInformation(modelMapper.map(vo, AdminInformationUpdateDTO.class)));
    }

    @ApiOperation(value = "获得普通管理员列表")
    @GetMapping("/list")
    @SuperAdmin
    public Result getAdminInformationList() {
        return new Result().ok().data(modelMapper.map(adminInformationService.getAdminInformationList(), new TypeToken<List<AdminInformationVO>>(){}.getType()));
    }
}
