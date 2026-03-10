package com.youngheart.youngaicodegenerate.core.parser;

import com.youngheart.youngaicodegenerate.ai.model.HtmlCodeResult;
import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;
import com.youngheart.youngaicodegenerate.model.enums.CodeGenTypeEnum;

public class CodeParserExecutor {

    private final static HtmlCodeParser htmlCodeParser = new HtmlCodeParser();

    private final static MultiFileParser multiFileCodeParser = new MultiFileParser();

    /**
     * 解析代码,返回Object是因为不同的parserCode返回的类型不同
     * @param content
     * @param codeGenTypeEnum
     * @return 解析后的代码
     */
    public static Object parseCode(String content, CodeGenTypeEnum codeGenTypeEnum) {
        switch (codeGenTypeEnum) {
            case HTML:
                return htmlCodeParser.parseCode(content);
            case MULTI_FILE:
                return multiFileCodeParser.parseCode(content);
            default:
                throw new IllegalArgumentException("不支持的代码生成类型: " + codeGenTypeEnum);
        }
    }
}
