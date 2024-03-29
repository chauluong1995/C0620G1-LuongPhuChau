package model.contract_detail;

public class ContractDetail {
    private String id;
    private String quantity;
    private String idContract;
    private String idAttachService;

    public ContractDetail() {
    }

    public ContractDetail(String quantity, String idContract, String idAttachService) {
        this.quantity = quantity;
        this.idContract = idContract;
        this.idAttachService = idAttachService;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(String idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
