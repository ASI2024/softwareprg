package VendorManagement;

public class ContractNegotiation {
    private String negotiationId;
    private String vendorId;
    private boolean agreed;
    private String terms;

    public ContractNegotiation(){

    }
    public ContractNegotiation(String negotiationId, String vendorId, boolean agreed, String terms) {
        this.negotiationId = negotiationId;
        this.vendorId = vendorId;
        this.agreed = agreed;
        this.terms = terms;
    }


    public String getNegotiationId() {
        return negotiationId;
    }

    public void setNegotiationId(String negotiationId) {
        this.negotiationId = negotiationId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    // Method to finalize the negotiation
    public void finalizeNegotiation(boolean agreed, String updatedTerms) {
        setAgreed(agreed);
        if ( agreed  && updatedTerms != null && !updatedTerms.isEmpty()) {
            setTerms(updatedTerms);
        }
        else{
            setTerms(null);
        }
    }
}