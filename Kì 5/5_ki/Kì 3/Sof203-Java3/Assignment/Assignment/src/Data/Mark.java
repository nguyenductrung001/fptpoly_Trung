/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author user-ma
 */
public class Mark {

    private String code, name;
    private Double enPoint, ITPoint, phyPoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getEnPoint() {
        return enPoint;
    }

    public void setEnPoint(Double enPoint) {
        this.enPoint = enPoint;
    }

    public Double getITPoint() {
        return ITPoint;
    }

    public void setITPoint(Double ITPoint) {
        this.ITPoint = ITPoint;
    }

    public Double getPhyPoint() {
        return phyPoint;
    }

    public void setPhyPoint(Double phyPoint) {
        this.phyPoint = phyPoint;
    }

    public Double getAvgPoint() {
        return (this.enPoint + this.ITPoint + this.phyPoint) / 3;
    }

    public Mark(String code, String name, Double enPoint, Double ITPoint, Double phyPoint) {
        this.code = code;
        this.name = name;
        this.enPoint = enPoint;
        this.ITPoint = ITPoint;
        this.phyPoint = phyPoint;
    }
}
