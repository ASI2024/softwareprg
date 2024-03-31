package VendorManagement;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
    private String id;
    private String name;
    private String type;
    private String service;
    private String location;
    private boolean availability;
    private double pricing;
    private double reviewScore;
    private List<PackageRequest> packageRequests;
    private List<ContractNegotiation> contractNegotiations;

   
    private Vendor(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.service = builder.service;
        this.location = builder.location;
        this.availability = builder.availability;
        this.pricing = builder.pricing;
        this.reviewScore = builder.reviewScore;
        this.packageRequests = builder.packageRequests;
        this.contractNegotiations = builder.contractNegotiations;
    }

    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getService() { return service; }
    public String getLocation() { return location; }
    public boolean isAvailability() { return availability; }
    public double getPricing() { return pricing; }
    public double getReviewScore() { return reviewScore; }
    public List<PackageRequest> getPackageRequests() { return packageRequests; }
    public List<ContractNegotiation> getContractNegotiations() { return contractNegotiations; }

   
    public static class Builder {
        private String id;
        private String name;
        private String type;
        private String service;
        private String location;
        private boolean availability;
        private double pricing;
        private double reviewScore;
        private List<PackageRequest> packageRequests = new ArrayList<>();
        private List<ContractNegotiation> contractNegotiations = new ArrayList<>();

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setService(String service) {
            this.service = service;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        public Builder setPricing(double pricing) {
            this.pricing = pricing;
            return this;
        }

        public Builder setReviewScore(double reviewScore) {
            this.reviewScore = reviewScore;
            return this;
        }

        public Builder addPackageRequest(PackageRequest packageRequest) {
            this.packageRequests.add(packageRequest);
            return this;
        }

        public Builder addContractNegotiation(ContractNegotiation contractNegotiation) {
            this.contractNegotiations.add(contractNegotiation);
            return this;
        }

        public Vendor build() {
            return new Vendor(this);
        }
    }
}
