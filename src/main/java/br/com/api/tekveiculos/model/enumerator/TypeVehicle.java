package br.com.api.tekveiculos.model.enumerator;

public enum TypeVehicle {

    CARRO("Carro"),

    MOTO("Moto");

    private String typeVehicle;

    TypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }
}
