package com.neusoft.DataDictionary;

/**
 * 文章审核状态
 */
public enum ArticleState {
    ARTICLE_STATE_UNAUDITED("000000000010", "未审核"),
    ARTICLE_STATE_PASS("000000000020", "审核通过"),
    ARTICLE_STATE_OUT("000000000030", "审核不通过");
    private String code;
    private String name;

    private ArticleState(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ArticleState getValue(String code) {
        ArticleState[] values = ArticleState.values();
        for (ArticleState articleState : values) {
            if (articleState.getCode().equals(code)) {
                return articleState;
            }
        }
        return null;
    }

    public static String getEleContractName(String code) {
        for (ArticleState eleContractName : ArticleState.values()) {
            if (eleContractName.getCode().equals(code)) {
                return eleContractName.getName();
            }
        }

        return null;
    }

}