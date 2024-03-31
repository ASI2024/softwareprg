package VendorManagement;

public class PackageRequest {
    private String requestId;
    private String vendorId;
    private String details;

   
    public PackageRequest(String requestId, String vendorId, String details) {
        this.requestId = requestId;
        this.vendorId = vendorId;
        this.details = details;
    }

  
    public String getRequestId() {
        return requestId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getDetails() {
        return details;
    }
}
