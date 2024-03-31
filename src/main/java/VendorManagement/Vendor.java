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

    public Vendor(){

    }
    public Vendor(String id, String name, String type, String service, String location, boolean availability, double pricing, double reviewScore) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.service = service;
        this.location = location;
        this.availability = availability;
        this.pricing = pricing;
        this.reviewScore = reviewScore;
        this.packageRequests = new ArrayList<>();
        this.contractNegotiations = new ArrayList<>();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getService() {
        return service;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailable() {
        return availability;
    }

    public double getPricing() {
        return pricing;
    }

    public double getReviewScore() {
        return reviewScore;
    }
    public void handlePackageRequest(PackageRequest packageRequest) {

        this.packageRequests.add(packageRequest);
    }


    public void negotiateContract(ContractNegotiation negotiationDetails) {

        this.contractNegotiations.add(negotiationDetails);

    }


    public List<PackageRequest> getPackageRequests() {
        return new ArrayList<>(this.packageRequests);
    }


    public List<ContractNegotiation> getContractNegotiations() {
        return new ArrayList<>(this.contractNegotiations);
    }

}
