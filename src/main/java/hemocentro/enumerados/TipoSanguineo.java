package hemocentro.enumerados;

public enum TipoSanguineo {
    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-");

    private final String label;

    TipoSanguineo(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TipoSanguineo fromString(String texto) {
    if (texto != null) {
        for (TipoSanguineo tipo : TipoSanguineo.values()) {
            if (texto.equalsIgnoreCase(tipo.label) || texto.equalsIgnoreCase(tipo.name())) {
                return tipo;
            }
        }
    }
    return null;
}

}
