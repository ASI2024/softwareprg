package org.test;

import VendorManagement.ContractNegotiation;
import VendorManagement.PackageRequest;
import VendorManagement.Vendor;
import VendorManagement.VendorDatabase;
import eventPlaner.OrganizerLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class VendorManagement {
    private VendorDatabase vendorDatabase = new VendorDatabase();
    private Vendor selectedVendor;
    private List<Vendor> viewedVendors;
    private String expectedLocation;
    private boolean expectedAvailability;
    private double expectedPricing;
    private double expectedReviewScore;
    private PackageRequest packageRequest;
    private ContractNegotiation contractNegotiation;
    OrganizerLogin organizerLogin = new OrganizerLogin();

    @And("the organizer wants to find vendors for their event")
    public void theOrganizerWantsToFindVendorsForTheirEvent() {
        // This step might involve setting up the context or ensuring the vendor database is populated for the test
        // Populating the vendor database with example vendors for demonstration
        vendorDatabase.addVendor(new Vendor("1", "Catering Co", "Catering", "Food Services", "NYC", true, 500.0, 4.5));
    }
    @When("the organizer navigates to the {string} section")
    public void theOrganizerNavigatesToTheSection(String arg0) {
        if ("Vendors".equals(arg0)) {
            viewedVendors = vendorDatabase.getAllVendors();
        }}

    @Then("they should see a list of vendors")
    public void theyShouldSeeAListOfVendors() {
        assertFalse(viewedVendors.isEmpty());
    }

    @And("each vendor should be categorized by type and service")
    public void eachVendorShouldBeCategorizedByTypeAndService() {
        for (Vendor vendor : viewedVendors) {
            assertNotNull(vendor.getType());
            assertNotNull(vendor.getService());
        }
    }
    @And("the organizer is on the {string} section")
    public void theOrganizerIsOnTheSection(String arg0) {

    }
    @When("the organizer applies filters based on location, availability, pricing, and reviews")
    public void theOrganizerAppliesFiltersBasedOnLocationAvailabilityPricingAndReviews() {
        expectedLocation = "New York";
        expectedAvailability = true;
        expectedPricing = 200.00;
        expectedReviewScore = 4.5;

        viewedVendors = vendorDatabase.filterVendors(expectedLocation, expectedAvailability, expectedPricing, expectedReviewScore);

    }

    @Then("they should see a list of vendors that match the criteria")
    public void theyShouldSeeAListOfVendorsThatMatchTheCriteria() {
        assertTrue(viewedVendors.stream().allMatch(vendor ->
                vendor.getLocation().equalsIgnoreCase(expectedLocation) &&
                        vendor.isAvailable() == expectedAvailability &&
                        vendor.getPricing() <= expectedPricing &&
                        vendor.getReviewScore() >= expectedReviewScore));

    }

    @Given("the organizer has found a preferred vendor")
    public void theOrganizerHasFoundAPreferredVendor() {
        selectedVendor =new Vendor("1", "Catering Co", "Catering", "Food Services", "NYC", true, 500.0, 4.5);
        vendorDatabase.addVendor(selectedVendor);
        selectedVendor = vendorDatabase.findVendorById(selectedVendor.getId());
        assertNotNull(selectedVendor);

    }
    @When("they select the vendor and choose to {string}")
    public void theySelectTheVendorAndChooseTo(String string) {
        assertNotNull(selectedVendor);
        if ("Request Package".equals(string)) {
            packageRequest = new PackageRequest("req1", selectedVendor.getId(), "Details of the package request");
            vendorDatabase.requestPackageFromVendor(selectedVendor.getId(), packageRequest);
        }

    }
    @Then("they should be able to specify their needs and send a request to the vendor")
    public void theyShouldBeAbleToSpecifyTheirNeedsAndSendARequestToTheVendor() {
        assertTrue(selectedVendor.getPackageRequests().contains(packageRequest));

    }
    @Given("the organizer has requested a package from a vendor")
    public void theOrganizerHasRequestedAPackageFromAVendor() {
        theySelectTheVendorAndChooseTo("Request Package");
    }
    @Given("the vendor has responded with an offer")
    public void theVendorHasRespondedWithAnOffer() {
        contractNegotiation = new ContractNegotiation("neg1", selectedVendor.getId(), false, "Initial terms");
        selectedVendor.negotiateContract(contractNegotiation);
        assertNotNull(this.contractNegotiation);
    }
    @When("the organizer chooses to {string}")
    public void theOrganizerChoosesTo(String string) {
        assertNotNull(this.contractNegotiation);
        if ("Negotiate Contract".equals(string)) {

            this.contractNegotiation.finalizeNegotiation(true, "Finalized contract terms");
        }
    }
    @Then("they should be able to communicate with the vendor to discuss terms")
    public void theyShouldBeAbleToCommunicateWithTheVendorToDiscussTerms() {
        assertTrue(contractNegotiation.isAgreed());

    }

    @Given("the organizer has finalized a contract with a vendor")
    public void theOrganizerHasFinalizedAContractWithAVendor() {
        theOrganizerChoosesTo("Negotiate Contract");
    }
    @When("they navigate to the {string} section")
    public void theyNavigateToTheSection(String string) {
        if ("My Bookings".equals(string)) {
            viewedVendors = new ArrayList<>();
            viewedVendors.add(selectedVendor);
        }

    }
    @Then("they should see their booked vendors")
    public void theyShouldSeeTheirBookedVendors() {
        assertFalse( viewedVendors.isEmpty());
    }
    @Then("they should be able to manage these bookings, including updating or cancelling")
    public void theyShouldBeAbleToManageTheseBookingsIncludingUpdatingOrCancelling() {
        assertFalse(organizerLogin.Login("ex@gmail.com","os12112"));
    }



}