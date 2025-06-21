package br.com.api.tekveiculos.model.enumerator;

public enum RoleMember {

    ADMIN("admin"),

    CONSULTANT("consultant");

    private String roleUser;

    RoleMember(String roleUser) {
        this.roleUser = roleUser;
    }
}
