package com.movietmdb.amikom;

import java.io.Serializable;

public class Filem implements Serializable {
    private String txtTitle;
    private String txtOverview;
    private String releaseDate;
    private String imgPoster;
    private String rating;

    public Filem(String title, String overview, String releaseDate, String imgPoster, String rating) {
        this.txtTitle = title;
        this.txtOverview = overview;
        this.releaseDate = releaseDate;
        this.imgPoster = imgPoster;
        this.rating = rating;
    }

    public String getImgPoster() {
        return imgPoster;
    }

    public void setImgPoster(String imgPoster) {
        this.imgPoster = imgPoster;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtOverview() {
        return txtOverview;
    }

    public void setTxtOverview(String txtOverview) {
        this.txtOverview = txtOverview;
    }

    public String getReleaseDate() {return releaseDate;}

    public void setReleaseDate(String releaseDate) {this.releaseDate = releaseDate;}

    public String getRating() {return rating;}

    public void setRating(String rating) {this.rating = rating;}

}