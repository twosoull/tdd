package chap03;

import org.junit.platform.engine.support.discovery.EngineDiscoveryRequestResolver;

import java.time.LocalDate;

public class PayData {
    private LocalDate firstBillingDate;
    private LocalDate billingDate;
    private int payAmount;

    private PayData(){}

    public PayData(LocalDate firstBillingDate, LocalDate billingDate, int payAmount) {
        this.firstBillingDate = firstBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public static Builder builder(){
        return  new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();

        public Builder billingDate(LocalDate billingDate){
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount){
            data.payAmount = payAmount;
            return this;
        }

        public Builder firstBillingDate(LocalDate firstBillingDate){
            data.firstBillingDate = firstBillingDate;
            return this;
        }

        public PayData build(){
            return data;
        }
    }
}
