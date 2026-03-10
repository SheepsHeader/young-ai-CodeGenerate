package com.youngheart.youngaicodegenerate.core.saver;

import com.youngheart.youngaicodegenerate.ai.model.HtmlCodeResult;
import com.youngheart.youngaicodegenerate.model.enums.CodeGenTypeEnum;

import java.io.File;

public class HtmlCodeSaver extends CodeSaverTemplate<HtmlCodeResult> {

    @Override
    protected void saveFile(HtmlCodeResult result, String dirPath) {
        writeCode(result.getHtmlCode(), "index.html", dirPath);
    }

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.HTML;
    }
}
