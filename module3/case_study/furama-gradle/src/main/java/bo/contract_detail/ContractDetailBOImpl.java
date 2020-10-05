package bo.contract_detail;

import dao.contract_detail.ContractDetailDAO;
import dao.contract_detail.ContractDetailDAOImpl;
import model.contract.Contract;
import model.contract_detail.AttachService;
import model.contract_detail.ContractDetail;

import java.util.List;

public class ContractDetailBOImpl implements ContractDetailBO {
    ContractDetailDAO contractDetailDAO = new ContractDetailDAOImpl();

    @Override
    public String saveContractDetail(ContractDetail contractDetail) {
        String message;
        message = this.contractDetailDAO.saveContractDetail(contractDetail);
        return message;
    }

    @Override
    public List<Contract> findAllContract() {
        return this.contractDetailDAO.findAllContract();
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return this.contractDetailDAO.findAllAttachService();
    }
}
