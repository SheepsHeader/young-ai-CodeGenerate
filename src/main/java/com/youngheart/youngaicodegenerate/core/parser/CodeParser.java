package com.youngheart.youngaicodegenerate.core.parser;


import java.util.regex.Pattern;

/**
 * 代码解析器接口,采用策略模式
 * @param <T> 解析后的代码类型
 */
public interface CodeParser<T> {

    static final Pattern HTML_CODE_PATTERN = Pattern.compile("```html\\s*\\n([\\s\\S]*?)```", Pattern.CASE_INSENSITIVE);
    static final Pattern CSS_CODE_PATTERN = Pattern.compile("```css\\s*\\n([\\s\\S]*?)```", Pattern.CASE_INSENSITIVE);
    static final Pattern JS_CODE_PATTERN = Pattern.compile("```(?:js|javascript)\\s*\\n([\\s\\S]*?)```", Pattern.CASE_INSENSITIVE);

    /**
     * 解析代码
     * @param content 文本内容
     * @return 解析后的代码
     */
    T parseCode(String content);

}
