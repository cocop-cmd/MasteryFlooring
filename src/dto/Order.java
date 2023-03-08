package dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Order {

    private LocalDate date;
    private int orderNumber;

    private String customerName;
    private String state;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal area;
    private BigDecimal materialCostPerSquareFoot;
    private BigDecimal labourCostPerSquareFoot;
    private BigDecimal materialCost;
    private BigDecimal labourCost;
    private BigDecimal tax;
    private BigDecimal total;

@Override
 public int hashCode(){
    int hash = 3;
    hash = 79 * hash + Objects.hashCode(this.date);
    hash = 79 * hash + this.orderNumber;
    hash = 79 * hash + Objects.hashCode(this.customerName);
    hash = 79 * hash + Objects.hashCode(this.state);
    hash = 79 * hash + Objects.hashCode(this.taxRate);
    hash = 79 * hash + Objects.hashCode(this.productType);
    hash = 79 * hash + Objects.hashCode(this.area);
    hash = 79 * hash + Objects.hashCode(this.materialCostPerSquareFoot);
    hash = 79 * hash + Objects.hashCode(this.labourCostPerSquareFoot);
    hash = 79 * hash + Objects.hashCode(this.materialCost);
    hash = 79 * hash + Objects.hashCode(this.labourCost);
    hash = 79 * hash + Objects.hashCode(this.tax);
    hash = 79 * hash + Objects.hashCode(this.total);
    return hash;
}

@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Order other = (Order) obj;
    if (this.orderNumber != other.orderNumber) {
        return false;
    }
    if (!Objects.equals(this.customerName, other.customerName)) {
        return false;
    }

    if (!Objects.equals(this.state, other.state)) {
        return false;
    }
    if (!Objects.equals(this.productType, other.productType)) {
        return false;
    }

    if (!Objects.equals(this.taxRate, other.taxRate)) {
        return false;
    }

    if (!Objects.equals(this.area, other.area)) {
        return false;
    }
    if (!Objects.equals(this.materialCostPerSquareFoot, other.materialCostPerSquareFoot)) {
        return false;
    }

    if (!Objects.equals(this.labourCostPerSquareFoot, other.labourCostPerSquareFoot)) {
        return false;
    }
    if  (!Objects.equals(this.materialCost, other.materialCost)) {
        return false;
    }
    if (!Objects.equals(this.labourCost, other.labourCost)) {
        return false;
    }
    if (!Objects.equals(this.tax, other.tax)){
        return false;
    }

        if (!Objects.equals(this.total, other.total)){
            return  false;
        }
        return true;

}

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public BigDecimal getTaxRate(){
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;

    }
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getMaterialCostPerSquareFoot() {
        return materialCostPerSquareFoot;
    }

    public void setMaterialCostPerSquareFoot(BigDecimal materialCostPerSquareFoot) {
        this.materialCostPerSquareFoot = materialCostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return labourCostPerSquareFoot;

    }

    public void setLabourCostPerSquareFoot(BigDecimal bigDecimal){
        this.labourCostPerSquareFoot = labourCostPerSquareFoot;
    }

    public BigDecimal getArea(){
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost(){
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }


        public BigDecimal getLaborCost() {
            return labourCost;
    }

    public void setLabourCost(BigDecimal labourCost) {
        this.labourCost = labourCost;

    }

    public BigDecimal getTax(){
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal () {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }



    }


