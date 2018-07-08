package com.example.lkoon.movieboja.model;

/**
 * Created by jwk on 2017. 6. 22..
 */

public class MovieData {
    private String titleKo;
    private String titleEn;
    private int showtime;
    private String admissionDesc;
    private String releaseDate;
    private String releaseDateStr;
    private MoviePhoto photo;
    private MovieRank rank;

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleKo() {
        return titleKo;
    }

    public void setTitleKo(String titleKo) {
        this.titleKo = titleKo;
    }

    public int getShowtime() {
        return showtime;
    }

    public void setShowtime(int showtime) {
        this.showtime = showtime;
    }

    public String getAdmissionDesc() {
        return admissionDesc;
    }

    public void setAdmissionDesc(String admissionDesc) {
        this.admissionDesc = admissionDesc;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public MoviePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(MoviePhoto photo) {
        this.photo = photo;
    }

    public MovieRank getRank() {
        return rank;
    }

    public void setRank(MovieRank rank) {
        this.rank = rank;
    }
}