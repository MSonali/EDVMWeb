/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Welcome
 */
public class VoterDetailsModel {
    private String constituency;
    private String v_name;
    private String v_fname;
    private boolean isVoted;
    private String v_district ;
    private String v_gender;
    private int v_age;

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public String getV_fname() {
        return v_fname;
    }

    public void setV_fname(String v_fname) {
        this.v_fname = v_fname;
    }

    public boolean getIsVoted() {
        return isVoted;
    }

    public void setIsVoted(boolean voted) {
        this.isVoted = voted;
    }

    public String getV_district() {
        return v_district;
    }

    public void setV_district(String v_district) {
        this.v_district = v_district;
    }

    public String getV_gender() {
        return v_gender;
    }

    public void setV_gender(String v_gender) {
        this.v_gender = v_gender;
    }

    public int getV_age() {
        return v_age;
    }

    public void setV_age(int v_age) {
        this.v_age = v_age;
    }

  
    

}
