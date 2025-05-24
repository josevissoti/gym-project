package com.project.domains.dtos;

import com.project.domains.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BrandDTO {

    private Integer idBrand;

    @NotNull(message = "Field brandName cannot be null")
    @NotBlank(message = "Field brandName cannot be blank")
    private String brandName;

    @NotNull(message = "Field cnpj cannot be null")
    @NotBlank(message = "Field cnpj cannot be blank")
    private String cnpj;

    @NotNull(message = "Field originCountry cannot be null")
    @NotBlank(message = "Field originCountry cannot be blank")
    private String originCountry;

    @NotNull(message = "Field email cannot be null")
    @NotBlank(message = "Field email cannot be blank")
    private String email;

    private int status;

    public BrandDTO() {
    }

    public BrandDTO(Brand brand) {
        this.idBrand = brand.getIdBrand();
        this.brandName = brand.getBrandName();
        this.cnpj = brand.getCnpj();
        this.originCountry = brand.getOriginCountry();
        this.email = brand.getEmail();
        this.status = brand.getStatus().getIdStatus();
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
