import java.util.ArrayList;
import java.util.List;

public class TransferScheduler {
    private List<Transfer> transfers;

    public TransferScheduler() {
        this.transfers = new ArrayList<>();
    }

    public void scheduleTransfer(Transfer transfer) {
        transfers.add(transfer);
    }

    public TransferStatus checkTransferStatus(String transferId) {
        for (Transfer transfer : transfers) {
            if (transfer.getTransferId().equals(transferId)) {
                return transfer.getStatus();
            }
        }
        return TransferStatus.NOT_FOUND;
    }
}
