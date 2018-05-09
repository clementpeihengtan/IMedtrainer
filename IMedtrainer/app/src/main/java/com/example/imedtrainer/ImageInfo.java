package com.example.imedtrainer;

/**
 * Created by clementtan on 2/19/18.
 */

public class ImageInfo {
    private int image_id;
    private String ans;
    private int ans_image_id;
    private String patientinfo;

    public ImageInfo(int image_id, String ans, String patientinfo, int ans_image_id) {
        this.image_id = image_id;
        this.ans = ans;
        this.patientinfo = patientinfo;
        this.ans_image_id = ans_image_id;
    }
    public int getImage_id() {
        return image_id;
    }

    public String getans() {
        return ans;
    }

    public String gethint() {
        return patientinfo;
    }

    public int getAns_image_id() {return ans_image_id;}
}
