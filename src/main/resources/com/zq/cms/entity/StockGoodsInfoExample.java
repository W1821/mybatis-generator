package com.zq.cms.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockGoodsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockGoodsInfoExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeIsNull() {
            addCriterion("classification_type is null");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeIsNotNull() {
            addCriterion("classification_type is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeEqualTo(Integer value) {
            addCriterion("classification_type =", value, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeNotEqualTo(Integer value) {
            addCriterion("classification_type <>", value, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeGreaterThan(Integer value) {
            addCriterion("classification_type >", value, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("classification_type >=", value, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeLessThan(Integer value) {
            addCriterion("classification_type <", value, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("classification_type <=", value, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeIn(List<Integer> values) {
            addCriterion("classification_type in", values, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeNotIn(List<Integer> values) {
            addCriterion("classification_type not in", values, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeBetween(Integer value1, Integer value2) {
            addCriterion("classification_type between", value1, value2, "classificationType");
            return (Criteria) this;
        }

        public Criteria andClassificationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("classification_type not between", value1, value2, "classificationType");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdIsNull() {
            addCriterion("goods_classification_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdIsNotNull() {
            addCriterion("goods_classification_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdEqualTo(String value) {
            addCriterion("goods_classification_id =", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdNotEqualTo(String value) {
            addCriterion("goods_classification_id <>", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdGreaterThan(String value) {
            addCriterion("goods_classification_id >", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_classification_id >=", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdLessThan(String value) {
            addCriterion("goods_classification_id <", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdLessThanOrEqualTo(String value) {
            addCriterion("goods_classification_id <=", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdLike(String value) {
            addCriterion("goods_classification_id like", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdNotLike(String value) {
            addCriterion("goods_classification_id not like", value, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdIn(List<String> values) {
            addCriterion("goods_classification_id in", values, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdNotIn(List<String> values) {
            addCriterion("goods_classification_id not in", values, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdBetween(String value1, String value2) {
            addCriterion("goods_classification_id between", value1, value2, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassificationIdNotBetween(String value1, String value2) {
            addCriterion("goods_classification_id not between", value1, value2, "goodsClassificationId");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNull() {
            addCriterion("goods_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            addCriterion("goods_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusEqualTo(Integer value) {
            addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotEqualTo(Integer value) {
            addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThan(Integer value) {
            addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThan(Integer value) {
            addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIn(List<Integer> values) {
            addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotIn(List<Integer> values) {
            addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIsNull() {
            addCriterion("goods_code is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIsNotNull() {
            addCriterion("goods_code is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeEqualTo(String value) {
            addCriterion("goods_code =", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotEqualTo(String value) {
            addCriterion("goods_code <>", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeGreaterThan(String value) {
            addCriterion("goods_code >", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_code >=", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLessThan(String value) {
            addCriterion("goods_code <", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLessThanOrEqualTo(String value) {
            addCriterion("goods_code <=", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeLike(String value) {
            addCriterion("goods_code like", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotLike(String value) {
            addCriterion("goods_code not like", value, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeIn(List<String> values) {
            addCriterion("goods_code in", values, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotIn(List<String> values) {
            addCriterion("goods_code not in", values, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeBetween(String value1, String value2) {
            addCriterion("goods_code between", value1, value2, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andGoodsCodeNotBetween(String value1, String value2) {
            addCriterion("goods_code not between", value1, value2, "goodsCode");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceIsNull() {
            addCriterion("origin_place is null");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceIsNotNull() {
            addCriterion("origin_place is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceEqualTo(String value) {
            addCriterion("origin_place =", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotEqualTo(String value) {
            addCriterion("origin_place <>", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceGreaterThan(String value) {
            addCriterion("origin_place >", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("origin_place >=", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceLessThan(String value) {
            addCriterion("origin_place <", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceLessThanOrEqualTo(String value) {
            addCriterion("origin_place <=", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceLike(String value) {
            addCriterion("origin_place like", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotLike(String value) {
            addCriterion("origin_place not like", value, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceIn(List<String> values) {
            addCriterion("origin_place in", values, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotIn(List<String> values) {
            addCriterion("origin_place not in", values, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceBetween(String value1, String value2) {
            addCriterion("origin_place between", value1, value2, "originPlace");
            return (Criteria) this;
        }

        public Criteria andOriginPlaceNotBetween(String value1, String value2) {
            addCriterion("origin_place not between", value1, value2, "originPlace");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIsNull() {
            addCriterion("shelf_life is null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIsNotNull() {
            addCriterion("shelf_life is not null");
            return (Criteria) this;
        }

        public Criteria andShelfLifeEqualTo(Integer value) {
            addCriterion("shelf_life =", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotEqualTo(Integer value) {
            addCriterion("shelf_life <>", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeGreaterThan(Integer value) {
            addCriterion("shelf_life >", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shelf_life >=", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeLessThan(Integer value) {
            addCriterion("shelf_life <", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeLessThanOrEqualTo(Integer value) {
            addCriterion("shelf_life <=", value, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeIn(List<Integer> values) {
            addCriterion("shelf_life in", values, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotIn(List<Integer> values) {
            addCriterion("shelf_life not in", values, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeBetween(Integer value1, Integer value2) {
            addCriterion("shelf_life between", value1, value2, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andShelfLifeNotBetween(Integer value1, Integer value2) {
            addCriterion("shelf_life not between", value1, value2, "shelfLife");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNull() {
            addCriterion("goods_unit is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIsNotNull() {
            addCriterion("goods_unit is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitEqualTo(String value) {
            addCriterion("goods_unit =", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotEqualTo(String value) {
            addCriterion("goods_unit <>", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThan(String value) {
            addCriterion("goods_unit >", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitGreaterThanOrEqualTo(String value) {
            addCriterion("goods_unit >=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThan(String value) {
            addCriterion("goods_unit <", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLessThanOrEqualTo(String value) {
            addCriterion("goods_unit <=", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitLike(String value) {
            addCriterion("goods_unit like", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotLike(String value) {
            addCriterion("goods_unit not like", value, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitIn(List<String> values) {
            addCriterion("goods_unit in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotIn(List<String> values) {
            addCriterion("goods_unit not in", values, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitBetween(String value1, String value2) {
            addCriterion("goods_unit between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andGoodsUnitNotBetween(String value1, String value2) {
            addCriterion("goods_unit not between", value1, value2, "goodsUnit");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardIsNull() {
            addCriterion("goods_standard is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardIsNotNull() {
            addCriterion("goods_standard is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardEqualTo(String value) {
            addCriterion("goods_standard =", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardNotEqualTo(String value) {
            addCriterion("goods_standard <>", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardGreaterThan(String value) {
            addCriterion("goods_standard >", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardGreaterThanOrEqualTo(String value) {
            addCriterion("goods_standard >=", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardLessThan(String value) {
            addCriterion("goods_standard <", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardLessThanOrEqualTo(String value) {
            addCriterion("goods_standard <=", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardLike(String value) {
            addCriterion("goods_standard like", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardNotLike(String value) {
            addCriterion("goods_standard not like", value, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardIn(List<String> values) {
            addCriterion("goods_standard in", values, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardNotIn(List<String> values) {
            addCriterion("goods_standard not in", values, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardBetween(String value1, String value2) {
            addCriterion("goods_standard between", value1, value2, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andGoodsStandardNotBetween(String value1, String value2) {
            addCriterion("goods_standard not between", value1, value2, "goodsStandard");
            return (Criteria) this;
        }

        public Criteria andMaxStockIsNull() {
            addCriterion("max_stock is null");
            return (Criteria) this;
        }

        public Criteria andMaxStockIsNotNull() {
            addCriterion("max_stock is not null");
            return (Criteria) this;
        }

        public Criteria andMaxStockEqualTo(Integer value) {
            addCriterion("max_stock =", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotEqualTo(Integer value) {
            addCriterion("max_stock <>", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockGreaterThan(Integer value) {
            addCriterion("max_stock >", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_stock >=", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockLessThan(Integer value) {
            addCriterion("max_stock <", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockLessThanOrEqualTo(Integer value) {
            addCriterion("max_stock <=", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockIn(List<Integer> values) {
            addCriterion("max_stock in", values, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotIn(List<Integer> values) {
            addCriterion("max_stock not in", values, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockBetween(Integer value1, Integer value2) {
            addCriterion("max_stock between", value1, value2, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotBetween(Integer value1, Integer value2) {
            addCriterion("max_stock not between", value1, value2, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMinStockIsNull() {
            addCriterion("min_stock is null");
            return (Criteria) this;
        }

        public Criteria andMinStockIsNotNull() {
            addCriterion("min_stock is not null");
            return (Criteria) this;
        }

        public Criteria andMinStockEqualTo(Integer value) {
            addCriterion("min_stock =", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockNotEqualTo(Integer value) {
            addCriterion("min_stock <>", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockGreaterThan(Integer value) {
            addCriterion("min_stock >", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_stock >=", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockLessThan(Integer value) {
            addCriterion("min_stock <", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockLessThanOrEqualTo(Integer value) {
            addCriterion("min_stock <=", value, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockIn(List<Integer> values) {
            addCriterion("min_stock in", values, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockNotIn(List<Integer> values) {
            addCriterion("min_stock not in", values, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockBetween(Integer value1, Integer value2) {
            addCriterion("min_stock between", value1, value2, "minStock");
            return (Criteria) this;
        }

        public Criteria andMinStockNotBetween(Integer value1, Integer value2) {
            addCriterion("min_stock not between", value1, value2, "minStock");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlIsNull() {
            addCriterion("goods_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlIsNotNull() {
            addCriterion("goods_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlEqualTo(String value) {
            addCriterion("goods_picture_url =", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlNotEqualTo(String value) {
            addCriterion("goods_picture_url <>", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlGreaterThan(String value) {
            addCriterion("goods_picture_url >", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("goods_picture_url >=", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlLessThan(String value) {
            addCriterion("goods_picture_url <", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("goods_picture_url <=", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlLike(String value) {
            addCriterion("goods_picture_url like", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlNotLike(String value) {
            addCriterion("goods_picture_url not like", value, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlIn(List<String> values) {
            addCriterion("goods_picture_url in", values, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlNotIn(List<String> values) {
            addCriterion("goods_picture_url not in", values, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlBetween(String value1, String value2) {
            addCriterion("goods_picture_url between", value1, value2, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsPictureUrlNotBetween(String value1, String value2) {
            addCriterion("goods_picture_url not between", value1, value2, "goodsPictureUrl");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNull() {
            addCriterion("storehouse_id is null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIsNotNull() {
            addCriterion("storehouse_id is not null");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdEqualTo(String value) {
            addCriterion("storehouse_id =", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotEqualTo(String value) {
            addCriterion("storehouse_id <>", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThan(String value) {
            addCriterion("storehouse_id >", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("storehouse_id >=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThan(String value) {
            addCriterion("storehouse_id <", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLessThanOrEqualTo(String value) {
            addCriterion("storehouse_id <=", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdLike(String value) {
            addCriterion("storehouse_id like", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotLike(String value) {
            addCriterion("storehouse_id not like", value, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdIn(List<String> values) {
            addCriterion("storehouse_id in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotIn(List<String> values) {
            addCriterion("storehouse_id not in", values, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdBetween(String value1, String value2) {
            addCriterion("storehouse_id between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStorehouseIdNotBetween(String value1, String value2) {
            addCriterion("storehouse_id not between", value1, value2, "storehouseId");
            return (Criteria) this;
        }

        public Criteria andStockQuantityIsNull() {
            addCriterion("stock_quantity is null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityIsNotNull() {
            addCriterion("stock_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andStockQuantityEqualTo(BigDecimal value) {
            addCriterion("stock_quantity =", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityNotEqualTo(BigDecimal value) {
            addCriterion("stock_quantity <>", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityGreaterThan(BigDecimal value) {
            addCriterion("stock_quantity >", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_quantity >=", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityLessThan(BigDecimal value) {
            addCriterion("stock_quantity <", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_quantity <=", value, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityIn(List<BigDecimal> values) {
            addCriterion("stock_quantity in", values, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityNotIn(List<BigDecimal> values) {
            addCriterion("stock_quantity not in", values, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_quantity between", value1, value2, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andStockQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_quantity not between", value1, value2, "stockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityIsNull() {
            addCriterion("put_in_stock_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityIsNotNull() {
            addCriterion("put_in_stock_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityEqualTo(BigDecimal value) {
            addCriterion("put_in_stock_quantity =", value, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityNotEqualTo(BigDecimal value) {
            addCriterion("put_in_stock_quantity <>", value, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityGreaterThan(BigDecimal value) {
            addCriterion("put_in_stock_quantity >", value, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("put_in_stock_quantity >=", value, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityLessThan(BigDecimal value) {
            addCriterion("put_in_stock_quantity <", value, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("put_in_stock_quantity <=", value, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityIn(List<BigDecimal> values) {
            addCriterion("put_in_stock_quantity in", values, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityNotIn(List<BigDecimal> values) {
            addCriterion("put_in_stock_quantity not in", values, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("put_in_stock_quantity between", value1, value2, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutInStockQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("put_in_stock_quantity not between", value1, value2, "putInStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityIsNull() {
            addCriterion("put_out_stock_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityIsNotNull() {
            addCriterion("put_out_stock_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityEqualTo(BigDecimal value) {
            addCriterion("put_out_stock_quantity =", value, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityNotEqualTo(BigDecimal value) {
            addCriterion("put_out_stock_quantity <>", value, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityGreaterThan(BigDecimal value) {
            addCriterion("put_out_stock_quantity >", value, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("put_out_stock_quantity >=", value, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityLessThan(BigDecimal value) {
            addCriterion("put_out_stock_quantity <", value, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("put_out_stock_quantity <=", value, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityIn(List<BigDecimal> values) {
            addCriterion("put_out_stock_quantity in", values, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityNotIn(List<BigDecimal> values) {
            addCriterion("put_out_stock_quantity not in", values, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("put_out_stock_quantity between", value1, value2, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andPutOutStockQuantityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("put_out_stock_quantity not between", value1, value2, "putOutStockQuantity");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNull() {
            addCriterion("sales_volume is null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIsNotNull() {
            addCriterion("sales_volume is not null");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeEqualTo(BigDecimal value) {
            addCriterion("sales_volume =", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotEqualTo(BigDecimal value) {
            addCriterion("sales_volume <>", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThan(BigDecimal value) {
            addCriterion("sales_volume >", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_volume >=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThan(BigDecimal value) {
            addCriterion("sales_volume <", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sales_volume <=", value, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeIn(List<BigDecimal> values) {
            addCriterion("sales_volume in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotIn(List<BigDecimal> values) {
            addCriterion("sales_volume not in", values, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_volume between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andSalesVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sales_volume not between", value1, value2, "salesVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeIsNull() {
            addCriterion("return_volume is null");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeIsNotNull() {
            addCriterion("return_volume is not null");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeEqualTo(BigDecimal value) {
            addCriterion("return_volume =", value, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeNotEqualTo(BigDecimal value) {
            addCriterion("return_volume <>", value, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeGreaterThan(BigDecimal value) {
            addCriterion("return_volume >", value, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("return_volume >=", value, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeLessThan(BigDecimal value) {
            addCriterion("return_volume <", value, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("return_volume <=", value, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeIn(List<BigDecimal> values) {
            addCriterion("return_volume in", values, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeNotIn(List<BigDecimal> values) {
            addCriterion("return_volume not in", values, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_volume between", value1, value2, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andReturnVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("return_volume not between", value1, value2, "returnVolume");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andHitsIsNull() {
            addCriterion("hits is null");
            return (Criteria) this;
        }

        public Criteria andHitsIsNotNull() {
            addCriterion("hits is not null");
            return (Criteria) this;
        }

        public Criteria andHitsEqualTo(Integer value) {
            addCriterion("hits =", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotEqualTo(Integer value) {
            addCriterion("hits <>", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThan(Integer value) {
            addCriterion("hits >", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hits >=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThan(Integer value) {
            addCriterion("hits <", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThanOrEqualTo(Integer value) {
            addCriterion("hits <=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsIn(List<Integer> values) {
            addCriterion("hits in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotIn(List<Integer> values) {
            addCriterion("hits not in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsBetween(Integer value1, Integer value2) {
            addCriterion("hits between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("hits not between", value1, value2, "hits");
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