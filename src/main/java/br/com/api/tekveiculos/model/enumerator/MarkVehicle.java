package br.com.api.tekveiculos.model.enumerator;

public enum MarkVehicle {

    HONDA("Honda"),

    VOLKSWAGEN("Volkswagen"),

    HYUNDAI("Hyundai");

    private String markVehicle;

    MarkVehicle(String markVehicle) {
        this.markVehicle = markVehicle;
    }

    public String getMarkVehicle() {
        return markVehicle;
    }
}
