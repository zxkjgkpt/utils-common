package ${BasePackageName}${HystrixPackageName};

import ${BaseEntityPackageName}${ClassName}Entity;
import ${BasePackageName}${ServicePackageName}.${ClassName}Service;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ${Description}Hystrix
 * Author ${Author}
 * Date  ${Date}
 */
@Component
public class ${ClassName}Hystrix extends BaseHystrix<${ClassName}Entity> implements ${ClassName}Service {

    @Override
    public List<${ClassName}Entity> find${ClassName}ByCondition(${ClassName}Entity ${ClassName?uncap_first}) {
        return null;
    }

     @Override
     public List<${ClassName}Entity> find${ClassName}ByCondition(${ClassName}Entity ${ClassName?uncap_first}, int pageNum, int pageSize) {
         return null;
     }

}
