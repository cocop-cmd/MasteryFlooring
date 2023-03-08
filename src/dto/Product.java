package dto;

import java.math.BigDecimal;

public class Product {

    private BigDecimal materialCostPerSquareFoot;
    private String productType;
    private BigDecimal labourCostPerSquareFoot;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType){
        this.productType = productType;
    }

    public BigDecimal getMaterialCostPerSquareFoot(){
        return materialCostPerSquareFoot;
    }

    public void setMaterialCostPerSquareFoot(BigDecimal materialCostPerSquareFoot) {
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
    }

    public BigDecimal getLabourCostPerSquareFoot(){
        return labourCostPerSquareFoot;
    }

    public void setLabourCostPerSquareFoot(BigDecimal labourCostPerSquareFoot){
        this.labourCostPerSquareFoot = labourCostPerSquareFoot;
    }

    public void setLaborCostPerSquareFoot(BigDecimal bigDecimal) {
    }
}

