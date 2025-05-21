package br.com.api.tekveiculos.model.enumerator;

public enum ModelVehicle {

    GOL("Gol"),

    HB20("HB20"),

    CG("CG 125 Fan");

    private String modelVehicle;

    ModelVehicle(String modelVehicle) {
        this.modelVehicle = modelVehicle;
    }

    public String getModelVehicle() {
        return modelVehicle;
    }
}
