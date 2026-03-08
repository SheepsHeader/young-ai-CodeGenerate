package com.youngheart.youngaicodegenerate.ai;

import com.youngheart.youngaicodegenerate.ai.model.HtmlCodeResult;
import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;
import dev.langchain4j.service.SystemMessage;
import reactor.core.publisher.Flux;

public interface AiCodeGeneratorService {

    /**
     * 生成代码
     *
     * @param userMessages 用户消息
     * @return 代码
     */
    @SystemMessage(fromResource = "prompt/html-system-prompt.txt")
    HtmlCodeResult generatorHtmlCode(String userMessages);


    /**
     * 生成多文件代码
     *
     * @param userMessages 用户消息
     * @return 代码
     */
    @SystemMessage(fromResource = "prompt/multi-system-prompt.txt")
    MultiCodeResult generatorMultiCode(String userMessages);

    /**
     * 生成代码
     *
     * @param userMessages 用户消息
     * @return 代码
     */
    @SystemMessage(fromResource = "prompt/html-system-prompt.txt")
    Flux<String> generatorHtmlCodeStreaming(String userMessages);


    /**
     * 生成多文件代码
     *
     * @param userMessages 用户消息
     * @return 代码
     */
    @SystemMessage(fromResource = "prompt/multi-system-prompt.txt")
    Flux<String> generatorMultiCodeStreaming(String userMessages);


}
