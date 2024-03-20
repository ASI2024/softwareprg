package VendorManagement;

public class PackageRequest {
    private String requestId;
    private String vendorId;
    private String organizerId;
    private String details;


    public PackageRequest(String requestId, String vendorId, String organizerId, String details) {
        this.requestId = requestId;
        this.vendorId = vendorId;
        this.organizerId = organizerId;
        this.details = details;
    }
}