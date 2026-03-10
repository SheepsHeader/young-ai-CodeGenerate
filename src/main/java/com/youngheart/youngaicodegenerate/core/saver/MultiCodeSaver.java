package com.youngheart.youngaicodegenerate.core.saver;

import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;
import com.youngheart.youngaicodegenerate.model.enums.CodeGenTypeEnum;

import java.io.File;

public class MultiCodeSaver extends CodeSaverTemplate<MultiCodeResult> {

    @Override
    protected void saveFile(MultiCodeResult result, String dirPath) {
        writeCode(result.getHtmlCode(), "index.html", dirPath);
        writeCode(result.getCssCode(), "style.css", dirPath);
        writeCode(result.getJsCode(), "script.js", dirPath);
    }

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.MULTI_FILE;
    }
}
