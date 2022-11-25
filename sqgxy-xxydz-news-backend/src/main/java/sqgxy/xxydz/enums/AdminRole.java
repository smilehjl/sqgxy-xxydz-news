package sqgxy.xxydz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-20 16:26
 * 枚举类型
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AdminRole {

    GENERAL_ADMIN(0, "普通管理员"),
    SUPER_ADMIN(1, "超级管理员");

    @EnumValue
    private Integer key;

    @JsonValue
    private String display;
}
