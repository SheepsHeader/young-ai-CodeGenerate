package com.youngheart.youngaicodegenerate.ai;

import com.youngheart.youngaicodegenerate.ai.model.HtmlCodeResult;
import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServiceFactoryTest {
    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generatorHtmlCode() {
        HtmlCodeResult htmlCode = aiCodeGeneratorService.generatorHtmlCode("请生成一个简单的博客页面，不超过20行");
        assertNotNull(htmlCode);// 检查生成的 HTML 代码是否不为空
    }

    @Test
    void generatorMultiCode() {
        MultiCodeResult multiCode = aiCodeGeneratorService.generatorMultiCode("请生成一个简单的博客页面，不超过20行");
        assertNotNull(multiCode);
    }
}