package com.zhangqie.translation.entity;

import java.util.List;

/**
 * Created by zhangqie on 2018/10/8
 * Describe:
 */
public class PhotographInfo {


    /**
     * log_id : 1226814035357488382
     * direction : 0
     * words_result_num : 4
     * words_result : [{"words":"杭州市公共交通集团有限公司"},{"words":"IC卡先值证"},{"words":"人民币伍拾元整"},{"words":"NQ1283276"}]
     */

    private long log_id;
    private int direction;
    private int words_result_num;
    private List<WordsResultBean> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * words : 杭州市公共交通集团有限公司
         */

        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
