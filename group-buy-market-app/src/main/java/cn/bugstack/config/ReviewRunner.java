package cn.bugstack.config;


import plus.gaga.middleware.sdk.domain.service.impl.OpenAiCodeReviewService;
import plus.gaga.middleware.sdk.infrastructure.git.GitCommand;
import plus.gaga.middleware.sdk.infrastructure.openai.IOpenAI;
import plus.gaga.middleware.sdk.infrastructure.openai.impl.ChatGLM;
import plus.gaga.middleware.sdk.infrastructure.weixin.WeiXin;

public class ReviewRunner {
    private static String env(String k) {
        String v = System.getenv(k);
        if (v == null || v.isEmpty()) throw new RuntimeException(k + " is empty");
        return v;
    }

    public static void main(String[] args) throws Exception {
        GitCommand gitCommand = new GitCommand(
                env("GITHUB_REVIEW_LOG_URI"),
                env("GITHUB_TOKEN"),
                env("COMMIT_PROJECT"),
                env("COMMIT_BRANCH"),
                env("COMMIT_AUTHOR"),
                env("COMMIT_MESSAGE")
        );
        WeiXin weiXin = new WeiXin(
                env("WEIXIN_APPID"),
                env("WEIXIN_SECRET"),
                env("WEIXIN_TOUSER"),
                env("WEIXIN_TEMPLATE_ID")
        );
        IOpenAI openAI = new ChatGLM(env("CHATGLM_APIHOST"), env("CHATGLM_APIKEYSECRET"));
        new OpenAiCodeReviewService(gitCommand, openAI, weiXin).exec();
    }
}