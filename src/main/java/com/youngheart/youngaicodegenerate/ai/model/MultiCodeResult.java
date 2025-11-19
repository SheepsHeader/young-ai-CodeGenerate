package com.youngheart.youngaicodegenerate.ai.model;

import lombok.Data;

import dev.langchain4j.model.output.structured.Description;

@Description("生成多代码文件的结果")
@Data
public class MultiCodeResult {
    /**
     * 多代码
     */
    @Description("HTML代码")
    private String htmlCode;

    @Description("CSS代码")
    private String cssCode;

    @Description("JS代码")
    private String jsCode;
     /**
     * 描述
     */
     @Description("生成代码的描述")
    private String description;
}
