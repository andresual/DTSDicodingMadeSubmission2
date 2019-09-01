package com.andresual.dicodingsubmission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvModel implements Parcelable {

    private String title;
    private String year;
    private String desc;
    private String date;
    private int img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.year);
        dest.writeString(this.desc);
        dest.writeString(this.date);
        dest.writeInt(this.img);
    }

    public TvModel() {
    }

    protected TvModel(Parcel in) {
        this.title = in.readString();
        this.year = in.readString();
        this.desc = in.readString();
        this.date = in.readString();
        this.img = in.readInt();
    }

    public static final Parcelable.Creator<TvModel> CREATOR = new Parcelable.Creator<TvModel>() {
        @Override
        public TvModel createFromParcel(Parcel source) {
            return new TvModel(source);
        }

        @Override
        public TvModel[] newArray(int size) {
            return new TvModel[size];
        }
    };
}
