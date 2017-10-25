package erick.munoz.guerrero.modelos;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lenovo-PC on 18/10/2017.
 */

public class Lugar implements Parcelable{
    String nombre, foto, descripcion;

    public Lugar(String nombre, String foto, String descripcion) {
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
    }

    protected Lugar(Parcel in) {
        nombre = in.readString();
        foto = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Lugar> CREATOR = new Creator<Lugar>() {
        @Override
        public Lugar createFromParcel(Parcel in) {
            return new Lugar(in);
        }

        @Override
        public Lugar[] newArray(int size) {
            return new Lugar[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(foto);
        parcel.writeString(descripcion);
    }
}
