package com.youngheart.youngaicodegenerate.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.youngheart.youngaicodegenerate.exception.BusinessException;
import com.youngheart.youngaicodegenerate.exception.ErrorCode;
import com.youngheart.youngaicodegenerate.model.enums.CodeGenTypeEnum;

import java.io.File;

/**
 * 代码保存器
 * 这里采用模版模式,不同的代码生成类型有不同的保存器
 */
public abstract class CodeSaverTemplate<T> {

    protected static final String FILE_SAVE_ROOT_DIR = System.getProperty("user.dir") + "/tmp/code_output";

    /**
     * 保存代码:定义保存逻辑步骤
     * @param result
     * @return
     */
    protected final File saveCode(T result){
        //1.校验result是否为空
        verifyResult(result);
        // 2.创建目录
        String dirPath = buildUniqueDir();
        //3. 保存文件
        saveFile(result,dirPath);
        //4.返回文件对象
        return new File(dirPath);
    }

    /**
     * 保存文件:不同的代码生成类型有不同的保存逻辑,需要子类实现
     * @param result
     * @return
     */
    protected abstract void saveFile(T result, String dirPath);

    protected void verifyResult(T result) {
        if (result == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "代码生成结果为空");
        }
    }

    /**
     * 构建唯一目录路径：tmp/code_output/bizType_雪花ID
     */
    protected String buildUniqueDir() {
        String bizType = getCodeType().getValue();
        String uniqueDirName = StrUtil.format("{}_{}", bizType, IdUtil.getSnowflakeNextIdStr());
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    protected abstract CodeGenTypeEnum getCodeType();

    /**
     * 工具方法：将代码写入文件
     * @param content 代码内容
     * @param dirPath 目录路径
     */
    protected final void writeCode(String content, String fileName,String dirPath) {
        if (StrUtil.isBlank(content)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码内容为空");
        }
        FileUtil.writeString(content, dirPath + File.separator + fileName, "utf-8");
    }


}
