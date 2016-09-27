package com.echo.rxjavaretrofitwithmvp.entity;


/**
 * Created by EchoZhou on 2016/7/25.
 */
public class AnnexMode extends BaseModel {
    /**
     * Name : 保险相关
     * Value : 7
     * Code : Policy
     */

    private String Name;
    private int Value;
    private String Code;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

}
