import java.util.Date;

class Transfer{
    private String transferId;
    private Account sourceAccount;
    private Account destinationAccount;
    private double amount;
    private Date timestamp;
    private TransferStatus status;
    public Transfer(String transferId, Account sourceAccount, Account destinationAccount, double amount) {
        this.transferId = transferId;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.status = TransferStatus.PENDING;
    }
    public void setStatus(TransferStatus status) {
        this.status = status;
    }
    public String getTransferId() {
        return transferId;
    }
    public Account getSourceAccount() {
        return sourceAccount;
    }
    public Account getDestinationAccount() {
        return destinationAccount;
    }
    public double getAmount() {
        return amount;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public TransferStatus getStatus() {
        return status;
    }

    

}