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

    public static void main(String[] args) {
        System.out.println("Start code review runner...");
        try {
            String commitProject = env("COMMIT_PROJECT");
            String commitBranch = env("COMMIT_BRANCH");
            String commitAuthor = env("COMMIT_AUTHOR");

            System.out.println("Project: " + commitProject);
            System.out.println("Branch: " + commitBranch);
            System.out.println("Author: " + commitAuthor);

            GitCommand gitCommand = new GitCommand(
                    env("GITHUB_REVIEW_LOG_URI"),
                    env("GITHUB_TOKEN"),
                    commitProject,
                    commitBranch,
                    commitAuthor,
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
            System.out.println("Code review runner finished successfully.");
        } catch (Exception e) {
            System.out.println("Code review runner failed.");
            e.printStackTrace();
        }
    }
}