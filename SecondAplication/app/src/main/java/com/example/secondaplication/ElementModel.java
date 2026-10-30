package com.example.secondaplication;

import android.os.Parcel;
import android.os.Parcelable;

public class ElementModel implements Parcelable {
private String nume;
private int valoare;

public  void EelementModel (String nume, int valoare){
    this.nume=nume;
    this.valoare=valoare;
}

protected ElementModel(Parcel in){
    nume=in.readString();
    valoare=in.readInt();
}

public static final Parcelable.Creator<ElementModel> CREATOR=new Parcelable.Creator<ElementModel>(){
        @Override
    public ElementModel createFromParcel(Parcel in){
            return new ElementModel(in);
        }

        @Override
        public ElementModel[] newArray(int size){
            return new ElementModel[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeInt(valoare);
    }





















}


