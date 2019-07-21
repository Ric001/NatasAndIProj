package com.falcontech.gradeit.models;

public enum LetterGradeEnum {
    A, B, C, F;

    @Override
    public String toString() {
        switch(this) {
            case A: return "4";
            case B : return "3";
            case C: return "2";
            case F: return "0";
            default: return "Unduported letter";
        }
    }
}