package model.contract;

public class ContractDetail {
    private String id;
    private String idContract;
    private String idAttachService;
    private String quantity;

    public ContractDetail() {
    }

    public ContractDetail(String id, String idContract, String idAttachService, String quantity) {
        this.id = id;
        this.idContract = idContract;
        this.idAttachService = idAttachService;
        this.quantity = quantity;
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
