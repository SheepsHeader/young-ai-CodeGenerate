package com.youngheart.youngaicodegenerate.core;

import com.youngheart.youngaicodegenerate.ai.AiCodeGeneratorService;
import com.youngheart.youngaicodegenerate.ai.model.HtmlCodeResult;
import com.youngheart.youngaicodegenerate.ai.model.MultiCodeResult;
import com.youngheart.youngaicodegenerate.core.parser.CodeParserExecutor;
import com.youngheart.youngaicodegenerate.core.saver.CodeSaverExecutor;
import com.youngheart.youngaicodegenerate.exception.BusinessException;
import com.youngheart.youngaicodegenerate.exception.ErrorCode;
import com.youngheart.youngaicodegenerate.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.File;

/**
 * AI 代码生成外观类，组合生成和保存功能
 */
@Service
public class AiCodeGeneratorFacade {

    private static final Logger log = LoggerFactory.getLogger(AiCodeGeneratorFacade.class);
    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    /**
     * 统一入口：根据类型生成并保存代码
     *
     * @param userMessage     用户提示词
     * @param codeGenTypeEnum 生成类型
     * @return 保存的目录
     */
    public File generateAndSaveCode(String userMessage, CodeGenTypeEnum codeGenTypeEnum,Long appId) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成类型为空");
        }
        return switch (codeGenTypeEnum) {
            case HTML -> generateAndSaveHtmlCode(userMessage,appId);
            case MULTI_FILE -> generateAndSaveMultiFileCode(userMessage,appId);
            default -> {
                String errorMessage = "不支持的生成类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }/**
     * 统一入口：根据类型生成并保存代码(流式输出)
     *
     * @param userMessage     用户提示词
     * @param codeGenTypeEnum 生成类型
     * @return 保存的目录
     */
    public  Flux<String> generateAndSaveCodeStream(String userMessage, CodeGenTypeEnum codeGenTypeEnum,Long appId) {
        if (codeGenTypeEnum == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成类型为空");
        }
        return switch (codeGenTypeEnum) {
            case HTML -> generateAndSaveHtmlCodeStream(userMessage,appId);
            case MULTI_FILE -> generateAndSaveMultiFileCodeStream(userMessage,appId);
            default -> {
                String errorMessage = "不支持的生成类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }

    private Flux<String> generateAndSaveMultiFileCodeStream(String userMessage,Long appId) {
        Flux<String> result = aiCodeGeneratorService.generatorMultiCodeStreaming(userMessage);
        StringBuilder stringBuilder = new StringBuilder();
        return result.doOnNext(chunk->stringBuilder.append(chunk))
                .doOnComplete(()->{
                    try {
                        String multiCode = stringBuilder.toString();
                        Object multiCodeResult = CodeParserExecutor.executorParser(multiCode, CodeGenTypeEnum.MULTI_FILE);
                        File file = CodeSaverExecutor.executorSaver(multiCodeResult, CodeGenTypeEnum.MULTI_FILE,appId);
                        log.info("多文件代码流保存成功，目录：{}", file.getAbsolutePath());
                    } catch (Exception e) {
                        log.error("生成多文件代码流时出错:{}", e.getMessage());
                    }
                });
    }

    private  Flux<String> generateAndSaveHtmlCodeStream(String userMessage,Long appId) {
        Flux<String> result = aiCodeGeneratorService.generatorHtmlCodeStreaming(userMessage);
        StringBuilder htmlCodeBuilder = new StringBuilder();
        return result.doOnNext(htmlCodeBuilder::append)
                .doOnComplete(()->{
                    try {
                        String html = htmlCodeBuilder.toString();
                        Object htmlCodeResult = CodeParserExecutor.executorParser(html, CodeGenTypeEnum.HTML);
                        File file = CodeSaverExecutor.executorSaver(htmlCodeResult, CodeGenTypeEnum.HTML,appId);
                        log.info("HTML 代码流保存成功，目录：{}", file.getAbsolutePath());
                    } catch (Exception e) {
                        log.error("生成 HTML 代码流时出错:{}", e.getMessage());
                    }
                });
    }

    /**
     * 生成 HTML 模式的代码并保存
     *
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private File generateAndSaveHtmlCode(String userMessage,Long appId) {
        HtmlCodeResult result = aiCodeGeneratorService.generatorHtmlCode(userMessage);
        return CodeSaverExecutor.executorSaver(result, CodeGenTypeEnum.HTML,appId);
    }

    /**
     * 生成多文件模式的代码并保存
     *
     * @param userMessage 用户提示词
     * @return 保存的目录
     */
    private File generateAndSaveMultiFileCode(String userMessage,Long appId) {
        MultiCodeResult result = aiCodeGeneratorService.generatorMultiCode(userMessage);
        return CodeSaverExecutor.executorSaver(result, CodeGenTypeEnum.MULTI_FILE,appId);
    }
}
