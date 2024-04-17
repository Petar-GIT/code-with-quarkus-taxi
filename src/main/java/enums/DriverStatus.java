package enums;

public enum DriverStatus {
    EXISTS("Student vec postoji");

    private String label;

    private DriverStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}