package com.Task_Mongodb_SpringBoot.library.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

public class MaterialDTO {

    private String id;
    @NotBlank
    private String typeMaterial;
    @NotBlank
    private String name;
    @NotBlank
    private String thematicArea;
    private boolean isAvailable;
    @NotBlank
    private int numberCopyMaterial;
    private LocalDate borrowDateMaterial;

    public MaterialDTO() {
    }

    public MaterialDTO(String id, String typeMaterial, String thematicArea, String name, boolean isAvailable, int numberCopyMaterial, LocalDate borrowDateMaterial) {
        this.id = id;
        this.typeMaterial = typeMaterial;
        this.thematicArea = thematicArea;
        this.name = name;
        this.isAvailable = isAvailable;
        this.numberCopyMaterial = numberCopyMaterial;
        this.borrowDateMaterial = borrowDateMaterial;
    }

    public MaterialDTO(String typeMaterial, String name, String thematicArea, int numberCopyMaterial, LocalDate borrowDateMaterial) {
        this.typeMaterial = typeMaterial;
        this.name = name;
        this.thematicArea = thematicArea;
        this.isAvailable = true;
        this.numberCopyMaterial = numberCopyMaterial;
        this.borrowDateMaterial = borrowDateMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialDTO that = (MaterialDTO) o;
        return isAvailable == that.isAvailable && numberCopyMaterial == that.numberCopyMaterial && Objects.equals(id, that.id) && Objects.equals(typeMaterial, that.typeMaterial) && Objects.equals(name, that.name) && Objects.equals(thematicArea, that.thematicArea) && Objects.equals(borrowDateMaterial, that.borrowDateMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeMaterial, name, thematicArea, isAvailable, numberCopyMaterial, borrowDateMaterial);
    }

    @Override
    public String toString() {
        return "MaterialDTO{" +
                "id='" + id + '\'' +
                ", typeMaterial='" + typeMaterial + '\'' +
                ", name='" + name + '\'' +
                ", thematicArea='" + thematicArea + '\'' +
                ", isAvailable=" + isAvailable +
                ", numberCopyMaterial=" + numberCopyMaterial +
                ", borrowDateMaterial=" + borrowDateMaterial +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(String typeMaterial) {
        this.typeMaterial = typeMaterial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThematicArea() {
        return thematicArea;
    }

    public void setThematicArea(String thematicArea) {
        this.thematicArea = thematicArea;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumberCopyMaterial() {
        return numberCopyMaterial;
    }

    public void setNumberCopyMaterial(int numberCopyMaterial) {
        this.numberCopyMaterial = numberCopyMaterial;
    }

    public LocalDate getBorrowDateMaterial() {
        return borrowDateMaterial;
    }

    public void setBorrowDateMaterial(LocalDate borrowDateMaterial) {
        this.borrowDateMaterial = borrowDateMaterial;
    }
}
