package cn.soft.market_management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageVO {
    private Integer id;
    private String name;
    private String clas;
    private String sellprice;
    private String img;
    private String url;
    private Integer error;
    private Integer width;
    private Integer height;

    public ImageVO(Integer error, String url, Integer width, Integer height) {
        this.error = error;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public ImageVO() {
    }
    //失败
    public static ImageVO fail() {
        return  new ImageVO(0,null,null,null);
    }

    public static ImageVO success(String realUrl, int width, int height) {
        return  new ImageVO(1,realUrl,width,height);
    }


    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "ImageVO{" +
                "error=" + error +
                ", url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
