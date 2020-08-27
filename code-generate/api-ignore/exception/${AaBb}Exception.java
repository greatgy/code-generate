package ${pkg_name};


/**
 * @author ${author}
 * @date ${date}
 * @description
 **/
public class ${AaBb}Exception extends BusinessException {

    public ${AaBb}Exception(ErrorCode errorCode) {
        super(errorCode);
    }

    public ${AaBb}Exception(int errorCode, Object errorMessage) {
        super(errorCode, errorMessage);
    }
}
