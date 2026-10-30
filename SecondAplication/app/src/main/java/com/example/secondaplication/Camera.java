package com.example.secondaplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Camera implements Parcelable {

    private float mp2;
    private boolean balcon;
    private boolean aerconditionat;
    private String incalzire;





    public Camera(float mp2, boolean balcon, boolean aerconditionat, String incalzire)
    {   this.mp2 = mp2;
        this.balcon=balcon;
        this.aerconditionat=aerconditionat;
        this.incalzire=incalzire;}


    protected Camera(Parcel in) {
        mp2 = in.readFloat();
        balcon = in.readByte() != 0;
        aerconditionat = in.readByte() != 0;
        incalzire = in.readString();
    }



    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeFloat(mp2);
        destination.writeByte((byte) (balcon ? 1 : 0));
        destination.writeByte((byte) (aerconditionat ? 1 : 0));
        destination.writeString(incalzire);
    }
    @Override
    public int describeContents() {return  0;}

    public static final Creator<Camera> CREATOR = new Creator<Camera>() {
        @Override
        public Camera createFromParcel(Parcel in) {
            return new Camera(in);
        }

        @Override
        public Camera[] newArray(int size) {
            return new Camera[size];
        }
    };




    public float getMp2() { return mp2; }
    public boolean getBalcon() { return balcon; }
    public boolean getAerConditionat() { return aerconditionat; }
    public String getIncalzire() { return incalzire; }

    @Override
    public String toString(){return "Camera are: " + mp2 + " mp2," + " Balcon: " + (balcon ? "Da" : "Nu") + " Aer Conditionat: " + (aerconditionat ? "Da" : "Nu") + " Incalzire: " + incalzire ;}}
