package com.example.vxhelper;



import android.os.Parcel;
import android.os.Parcelable;

public class UserBean implements Parcelable {
    private String name;
    private boolean videoEnabled;   //是否启用视频通话，默认不开启
    private boolean photoEnabled;   //朋友圈是否开启
    private String Image;


    protected UserBean(Parcel in) {
        name = in.readString();
        videoEnabled = in.readByte() != 0;
        photoEnabled = in.readByte() != 0;
        Image = in.readString();
    }

    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel in) {
            return new UserBean(in);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeByte((byte) (videoEnabled ? 1 : 0));
        dest.writeByte((byte) (photoEnabled ? 1 : 0));
        dest.writeString(Image);
    }
}
