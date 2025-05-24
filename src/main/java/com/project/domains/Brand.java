package com.project.domains;

import com.project.domains.dtos.BrandDTO;
import com.project.domains.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_brand")
    private Integer idBrand;

    @NotNull
    @NotBlank
    private String brandName;

    @NotNull
    @NotBlank
    private String cnpj;

    @NotNull
    @NotBlank
    private String originCountry;

    @NotNull
    @NotBlank
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    public Brand() {
        this.status = Status.ACTIVATED;
    }

    public Brand(Integer idBrand, String brandName, String cnpj, String originCountry, String email, Status status) {
        this.idBrand = idBrand;
        this.brandName = brandName;
        this.cnpj = cnpj;
        this.originCountry = originCountry;
        this.email = email;
        this.status = status;
    }

    public Brand(BrandDTO dto) {
        this.idBrand = dto.getIdBrand();
        this.brandName = dto.getBrandName();
        this.cnpj = dto.getCnpj();
        this.originCountry = dto.getOriginCountry();
        this.email = dto.getEmail();
        this.status = Status.toEnum(dto.getStatus());
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(idBrand, brand.idBrand) && Objects.equals(brandName, brand.brandName) && Objects.equals(email, brand.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBrand, brandName, email);
    }
}
