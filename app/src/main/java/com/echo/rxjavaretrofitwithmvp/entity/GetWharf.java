package com.echo.rxjavaretrofitwithmvp.entity;

/**
 * Created by EchoZhou on 2016/9/27.
 */
public class GetWharf extends BaseModel {


    /**
     * Port : 5
     * Name : 广州黄埔港
     * Nano : 黄埔
     * Value : 25
     */

    private int Port;
    private String Name;
    private String Nano;
    private int Value;

    public int getPort() {
        return Port;
    }

    public void setPort(int Port) {
        this.Port = Port;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNano() {
        return Nano;
    }

    public void setNano(String Nano) {
        this.Nano = Nano;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }
}
