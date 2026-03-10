package com.youngheart.youngaicodegenerate.core.saver;

import com.youngheart.youngaicodegenerate.ai.model.HtmlCodeResult;
import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;
import com.youngheart.youngaicodegenerate.exception.BusinessException;
import com.youngheart.youngaicodegenerate.exception.ErrorCode;
import com.youngheart.youngaicodegenerate.model.enums.CodeGenTypeEnum;

import java.io.File;

public class CodeSaverExecutor {
    private final static HtmlCodeSaver htmlCodeSaver = new HtmlCodeSaver();
    private final static MultiCodeSaver multiCodeSaver = new MultiCodeSaver();

     /**
      * 执行保存代码
      * @param  result:代码生成结果
      * @return 保存的文件对象
      */
    public static File executorSaver(Object result, CodeGenTypeEnum codeGenType,Long appId) throws BusinessException {
        return switch (codeGenType) {
            case HTML -> htmlCodeSaver.saveCode((HtmlCodeResult) result,appId);
            case MULTI_FILE -> multiCodeSaver.saveCode((MultiCodeResult) result,appId);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型" + codeGenType);
        };
    }
}
