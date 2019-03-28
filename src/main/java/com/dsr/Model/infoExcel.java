package com.dsr.Model;


import javax.persistence.*;

@Entity
@Table(name = "trs")
public class infoExcel {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entity_id_seq"
    )
    @SequenceGenerator(
            name = "entity_id_seq",
            sequenceName = "global_id_sequence",
            allocationSize = 1
    )
    @Column(
            name = "id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long id;
    private Integer rule_id;
    private String device_id;
    private String ts_date;
    private String ts_time;
    private String op_type;
    private String detail_pay;
    private String card_num;
    private String ref_num;
    private String tr_code;
    private String price;
    private String month_code;
    private Long tr_comm;


    public infoExcel() {
    }

    public infoExcel(String device_id, String ts_date, String ts_time, String op_type, String detail_pay, String card_num, String ref_num, String tr_code, String price, String month_code, Long tr_comm) {
        this.device_id = device_id;
        this.ts_date = ts_date;
        this.ts_time = ts_time;
        this.op_type = op_type;
        this.detail_pay = detail_pay;
        this.card_num = card_num;
        this.ref_num = ref_num;
        this.tr_code = tr_code;
        this.price = price;
        this.month_code = month_code;
        this.tr_comm = tr_comm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getTs_date() {
        return ts_date;
    }

    public void setTs_date(String ts_date) {
        this.ts_date = ts_date;
    }

    public String getTs_time() {
        return ts_time;
    }

    public void setTs_time(String ts_time) {
        this.ts_time = ts_time;
    }

    public String getOpr_type() {
        return op_type;
    }

    public void setOpr_type(String opr_type) {
        this.op_type = opr_type;
    }

    public String getDetail_pay() {
        return detail_pay;
    }

    public void setDetail_pay(String detail_pay) {
        this.detail_pay = detail_pay;
    }

    public String getCard_number() {
        return card_num;
    }

    public void setCard_number(String card_number) {
        this.card_num = card_number;
    }

    public String getReference_number() {
        return ref_num;
    }

    public void setReference_number(String reference_number) {
        this.ref_num = reference_number;
    }

    public String getTs_code() {
        return tr_code;
    }

    public void setTs_code(String ts_code) {
        this.tr_code = ts_code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMonth_code() {
        return month_code;
    }

    public void setMonth_code(String month_code) {
        this.month_code = month_code;
    }

    public Long getTs_com() {
        return tr_comm;
    }

    public void setTs_com(Long ts_com) {
        this.tr_comm = ts_com;
    }

    @Override
    public String toString() {
        return "infoExcel{" +
                "device_id='" + device_id + '\'' +
                ", ts_date='" + ts_date + '\'' +
                ", ts_time='" + ts_time + '\'' +
                ", opr_type='" + op_type + '\'' +
                ", card_number='" + card_num + '\'' +
                ", reference_number='" + ref_num + '\'' +
                ", ts_code='" + tr_code + '\'' +
                ", price='" + price + '\'' +
                ", month_code=" + month_code +
                ", ts_com=" + tr_comm +
                '}';
    }
}
