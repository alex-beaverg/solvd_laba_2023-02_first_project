package com.solvd.hospital_project.hospital.people;

public enum Diagnosis {
    FLU("Flu", "General"),
    COVID("Covid-19", "General"),
    BONE_FRACTURE("Bone fracture", "Injuries"),
    HAND_INJURY("Hand injury", "Injuries"),
    LEG_INJURY("Leg injury", "Injuries"),
    UNKNOWN("Unknown diagnosis", "General");

    private final String title;
    private final String type;

    Diagnosis(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return title;
    }
}
