package com.zhiyou.pojo;

import java.util.ArrayList;
import java.util.List;

public class SpeakerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpeakerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSpeakerIdIsNull() {
            addCriterion("speaker_id is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdIsNotNull() {
            addCriterion("speaker_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdEqualTo(Integer value) {
            addCriterion("speaker_id =", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotEqualTo(Integer value) {
            addCriterion("speaker_id <>", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdGreaterThan(Integer value) {
            addCriterion("speaker_id >", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("speaker_id >=", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdLessThan(Integer value) {
            addCriterion("speaker_id <", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdLessThanOrEqualTo(Integer value) {
            addCriterion("speaker_id <=", value, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdIn(List<Integer> values) {
            addCriterion("speaker_id in", values, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotIn(List<Integer> values) {
            addCriterion("speaker_id not in", values, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdBetween(Integer value1, Integer value2) {
            addCriterion("speaker_id between", value1, value2, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("speaker_id not between", value1, value2, "speakerId");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIsNull() {
            addCriterion("speaker_name is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIsNotNull() {
            addCriterion("speaker_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameEqualTo(String value) {
            addCriterion("speaker_name =", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotEqualTo(String value) {
            addCriterion("speaker_name <>", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameGreaterThan(String value) {
            addCriterion("speaker_name >", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_name >=", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLessThan(String value) {
            addCriterion("speaker_name <", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLessThanOrEqualTo(String value) {
            addCriterion("speaker_name <=", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameLike(String value) {
            addCriterion("speaker_name like", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotLike(String value) {
            addCriterion("speaker_name not like", value, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameIn(List<String> values) {
            addCriterion("speaker_name in", values, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotIn(List<String> values) {
            addCriterion("speaker_name not in", values, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameBetween(String value1, String value2) {
            addCriterion("speaker_name between", value1, value2, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerNameNotBetween(String value1, String value2) {
            addCriterion("speaker_name not between", value1, value2, "speakerName");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescIsNull() {
            addCriterion("speaker_desc is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescIsNotNull() {
            addCriterion("speaker_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescEqualTo(String value) {
            addCriterion("speaker_desc =", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescNotEqualTo(String value) {
            addCriterion("speaker_desc <>", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescGreaterThan(String value) {
            addCriterion("speaker_desc >", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_desc >=", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescLessThan(String value) {
            addCriterion("speaker_desc <", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescLessThanOrEqualTo(String value) {
            addCriterion("speaker_desc <=", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescLike(String value) {
            addCriterion("speaker_desc like", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescNotLike(String value) {
            addCriterion("speaker_desc not like", value, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescIn(List<String> values) {
            addCriterion("speaker_desc in", values, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescNotIn(List<String> values) {
            addCriterion("speaker_desc not in", values, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescBetween(String value1, String value2) {
            addCriterion("speaker_desc between", value1, value2, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerDescNotBetween(String value1, String value2) {
            addCriterion("speaker_desc not between", value1, value2, "speakerDesc");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobIsNull() {
            addCriterion("speaker_job is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobIsNotNull() {
            addCriterion("speaker_job is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobEqualTo(String value) {
            addCriterion("speaker_job =", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobNotEqualTo(String value) {
            addCriterion("speaker_job <>", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobGreaterThan(String value) {
            addCriterion("speaker_job >", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_job >=", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobLessThan(String value) {
            addCriterion("speaker_job <", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobLessThanOrEqualTo(String value) {
            addCriterion("speaker_job <=", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobLike(String value) {
            addCriterion("speaker_job like", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobNotLike(String value) {
            addCriterion("speaker_job not like", value, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobIn(List<String> values) {
            addCriterion("speaker_job in", values, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobNotIn(List<String> values) {
            addCriterion("speaker_job not in", values, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobBetween(String value1, String value2) {
            addCriterion("speaker_job between", value1, value2, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerJobNotBetween(String value1, String value2) {
            addCriterion("speaker_job not between", value1, value2, "speakerJob");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlIsNull() {
            addCriterion("speaker_head_url is null");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlIsNotNull() {
            addCriterion("speaker_head_url is not null");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlEqualTo(String value) {
            addCriterion("speaker_head_url =", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlNotEqualTo(String value) {
            addCriterion("speaker_head_url <>", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlGreaterThan(String value) {
            addCriterion("speaker_head_url >", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("speaker_head_url >=", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlLessThan(String value) {
            addCriterion("speaker_head_url <", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("speaker_head_url <=", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlLike(String value) {
            addCriterion("speaker_head_url like", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlNotLike(String value) {
            addCriterion("speaker_head_url not like", value, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlIn(List<String> values) {
            addCriterion("speaker_head_url in", values, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlNotIn(List<String> values) {
            addCriterion("speaker_head_url not in", values, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlBetween(String value1, String value2) {
            addCriterion("speaker_head_url between", value1, value2, "speakerHeadUrl");
            return (Criteria) this;
        }

        public Criteria andSpeakerHeadUrlNotBetween(String value1, String value2) {
            addCriterion("speaker_head_url not between", value1, value2, "speakerHeadUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}