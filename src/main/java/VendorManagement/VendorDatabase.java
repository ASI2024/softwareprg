package VendorManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class  VendorDatabase {
    private List<Vendor> vendors;

    public VendorDatabase() {
        this.vendors = new ArrayList<>();
    }

    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
    }

    public List<Vendor> getAllVendors() {
        return new ArrayList<>(vendors);
    }

    public List<Vendor> filterVendors(String location, Boolean availability, Double pricing, Double reviewScore) {
        return vendors.stream()
                .filter(vendor -> location == null || vendor.getLocation().equalsIgnoreCase(location))
                .filter(vendor -> availability == null || vendor.isAvailable() == availability)
                .filter(vendor -> pricing == null || vendor.getPricing() <= pricing)
                .filter(vendor -> reviewScore == null || vendor.getReviewScore() >= reviewScore)
                .collect(Collectors.toList());
    }

    public void requestPackageFromVendor(String vendorId, PackageRequest packageRequest) {
        Vendor vendor = findVendorById(vendorId);
        if (vendor != null) {
            vendor.handlePackageRequest(packageRequest);
        }
    }



    public Vendor findVendorById(String id) {
        return vendors.stream()
                .filter(vendor -> vendor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}