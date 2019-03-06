package com.simon.clipboard.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YdWordInfo{

    /**
     * ec : {"exam_type":["TOEFL","高中","IELTS","CET6","CET4","商务英语","考研"],"source":{"name":"有道词典","url":"http://dict.youdao.com"},"word":[{"return-phrase":{"l":{"i":"account"}},"trs":[{"tr":[{"l":{"i":["n. 账户；解释；账目，账单；理由；描述"]}}]},{"tr":[{"l":{"i":["vi. 解释；导致；报账"]}}]},{"tr":[{"l":{"i":["vt. 认为；把\u2026视为"]}}]}],"ukphone":"ə'kaʊnt","ukspeech":"account&type=1","usphone":"ə'kaʊnt","usspeech":"account&type=2"}]}
     * input : account
     * lang : eng
     * le : en
     * meta : {"dicts":["meta","simple","ec"],"guessLanguage":"eng","input":"account","lang":"eng","le":"en"}
     * simple : {"query":"account","word":[{"return-phrase":"account","ukphone":"ə'kaʊnt","ukspeech":"account&type=1","usphone":"ə'kaʊnt","usspeech":"account&type=2"}]}
     */

    private EcBean ec;
    private String input;
    private String lang;
    private String le;
    private MetaBean meta;
    private SimpleBean simple;

    public EcBean getEc() {
        return ec;
    }

    public void setEc(EcBean ec) {
        this.ec = ec;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLe() {
        return le;
    }

    public void setLe(String le) {
        this.le = le;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public SimpleBean getSimple() {
        return simple;
    }

    public void setSimple(SimpleBean simple) {
        this.simple = simple;
    }

    public static class EcBean {
        /**
         * exam_type : ["TOEFL","高中","IELTS","CET6","CET4","商务英语","考研"]
         * source : {"name":"有道词典","url":"http://dict.youdao.com"}
         * word : [{"return-phrase":{"l":{"i":"account"}},"trs":[{"tr":[{"l":{"i":["n. 账户；解释；账目，账单；理由；描述"]}}]},{"tr":[{"l":{"i":["vi. 解释；导致；报账"]}}]},{"tr":[{"l":{"i":["vt. 认为；把\u2026视为"]}}]}],"ukphone":"ə'kaʊnt","ukspeech":"account&type=1","usphone":"ə'kaʊnt","usspeech":"account&type=2"}]
         */

        private SourceBean source;
        private List<String> exam_type;
        private List<WordBean> word;

        public SourceBean getSource() {
            return source;
        }

        public void setSource(SourceBean source) {
            this.source = source;
        }

        public List<String> getExam_type() {
            return exam_type;
        }

        public void setExam_type(List<String> exam_type) {
            this.exam_type = exam_type;
        }

        public List<WordBean> getWord() {
            return word;
        }

        public void setWord(List<WordBean> word) {
            this.word = word;
        }

        public static class SourceBean {
            /**
             * name : 有道词典
             * url : http://dict.youdao.com
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class WordBean {
            /**
             * return-phrase : {"l":{"i":"account"}}
             * trs : [{"tr":[{"l":{"i":["n. 账户；解释；账目，账单；理由；描述"]}}]},{"tr":[{"l":{"i":["vi. 解释；导致；报账"]}}]},{"tr":[{"l":{"i":["vt. 认为；把\u2026视为"]}}]}]
             * ukphone : ə'kaʊnt
             * ukspeech : account&type=1
             * usphone : ə'kaʊnt
             * usspeech : account&type=2
             */

            @SerializedName("return-phrase")
            private ReturnphraseBean returnphrase;
            private String ukphone;
            private String ukspeech;
            private String usphone;
            private String usspeech;
            private List<TrsBean> trs;

            public ReturnphraseBean getReturnphrase() {
                return returnphrase;
            }

            public void setReturnphrase(ReturnphraseBean returnphrase) {
                this.returnphrase = returnphrase;
            }

            public String getUkphone() {
                return ukphone;
            }

            public void setUkphone(String ukphone) {
                this.ukphone = ukphone;
            }

            public String getUkspeech() {
                return ukspeech;
            }

            public void setUkspeech(String ukspeech) {
                this.ukspeech = ukspeech;
            }

            public String getUsphone() {
                return usphone;
            }

            public void setUsphone(String usphone) {
                this.usphone = usphone;
            }

            public String getUsspeech() {
                return usspeech;
            }

            public void setUsspeech(String usspeech) {
                this.usspeech = usspeech;
            }

            public List<TrsBean> getTrs() {
                return trs;
            }

            public void setTrs(List<TrsBean> trs) {
                this.trs = trs;
            }

            public static class ReturnphraseBean {
                /**
                 * l : {"i":"account"}
                 */

                private LBean l;

                public LBean getL() {
                    return l;
                }

                public void setL(LBean l) {
                    this.l = l;
                }

                public static class LBean {
                    /**
                     * i : account
                     */

                    private String i;

                    public String getI() {
                        return i;
                    }

                    public void setI(String i) {
                        this.i = i;
                    }
                }
            }

            public static class TrsBean {
                private List<TrBean> tr;

                public List<TrBean> getTr() {
                    return tr;
                }

                public void setTr(List<TrBean> tr) {
                    this.tr = tr;
                }

                public static class TrBean {
                    /**
                     * l : {"i":["n. 账户；解释；账目，账单；理由；描述"]}
                     */

                    private LBeanX l;

                    public LBeanX getL() {
                        return l;
                    }

                    public void setL(LBeanX l) {
                        this.l = l;
                    }

                    public static class LBeanX {
                        private List<String> i;

                        public List<String> getI() {
                            return i;
                        }

                        public void setI(List<String> i) {
                            this.i = i;
                        }
                    }
                }
            }
        }
    }

    public static class MetaBean {
        /**
         * dicts : ["meta","simple","ec"]
         * guessLanguage : eng
         * input : account
         * lang : eng
         * le : en
         */

        private String guessLanguage;
        private String input;
        private String lang;
        private String le;
        private List<String> dicts;

        public String getGuessLanguage() {
            return guessLanguage;
        }

        public void setGuessLanguage(String guessLanguage) {
            this.guessLanguage = guessLanguage;
        }

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getLe() {
            return le;
        }

        public void setLe(String le) {
            this.le = le;
        }

        public List<String> getDicts() {
            return dicts;
        }

        public void setDicts(List<String> dicts) {
            this.dicts = dicts;
        }
    }

    public static class SimpleBean {
        /**
         * query : account
         * word : [{"return-phrase":"account","ukphone":"ə'kaʊnt","ukspeech":"account&type=1","usphone":"ə'kaʊnt","usspeech":"account&type=2"}]
         */

        private String query;
        private List<WordBeanX> word;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public List<WordBeanX> getWord() {
            return word;
        }

        public void setWord(List<WordBeanX> word) {
            this.word = word;
        }

        public static class WordBeanX {
            /**
             * return-phrase : account
             * ukphone : ə'kaʊnt
             * ukspeech : account&type=1
             * usphone : ə'kaʊnt
             * usspeech : account&type=2
             */

            @SerializedName("return-phrase")
            private String returnphrase;
            private String ukphone;
            private String ukspeech;
            private String usphone;
            private String usspeech;

            public String getReturnphrase() {
                return returnphrase;
            }

            public void setReturnphrase(String returnphrase) {
                this.returnphrase = returnphrase;
            }

            public String getUkphone() {
                return ukphone;
            }

            public void setUkphone(String ukphone) {
                this.ukphone = ukphone;
            }

            public String getUkspeech() {
                return ukspeech;
            }

            public void setUkspeech(String ukspeech) {
                this.ukspeech = ukspeech;
            }

            public String getUsphone() {
                return usphone;
            }

            public void setUsphone(String usphone) {
                this.usphone = usphone;
            }

            public String getUsspeech() {
                return usspeech;
            }

            public void setUsspeech(String usspeech) {
                this.usspeech = usspeech;
            }
        }
    }
}