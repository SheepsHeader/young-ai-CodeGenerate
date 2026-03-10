package com.youngheart.youngaicodegenerate.core.parser;

import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiFileParser implements CodeParser<MultiCodeResult> {

        @Override
        public MultiCodeResult parseCode(String codeContent) {
            MultiCodeResult result = new MultiCodeResult();
            // 提取各类代码
            String htmlCode = extractCodeByPattern(codeContent, HTML_CODE_PATTERN);
            String cssCode = extractCodeByPattern(codeContent, CSS_CODE_PATTERN);
            String jsCode = extractCodeByPattern(codeContent, JS_CODE_PATTERN);
            // 设置HTML代码
            if (htmlCode != null && !htmlCode.trim().isEmpty()) {
                result.setHtmlCode(htmlCode.trim());
            }
            // 设置CSS代码
            if (cssCode != null && !cssCode.trim().isEmpty()) {
                result.setCssCode(cssCode.trim());
            }
            // 设置JS代码
            if (jsCode != null && !jsCode.trim().isEmpty()) {
                result.setJsCode(jsCode.trim());
            }
            return result;

        }

    private static String extractCodeByPattern(String content, Pattern pattern) {
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
