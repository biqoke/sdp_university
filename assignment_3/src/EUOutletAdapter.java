class EUOutletAdapter implements PowerSource {
    private EUOutlet euOutlet;

    public EUOutletAdapter(EUOutlet euOutlet) {
        this.euOutlet = euOutlet;
    }

    @Override
    public void connect() {
        euOutlet.plugInEUDevice();  // Use the European outlet-specific method to connect
    }

    @Override
    public void disconnect() {
        euOutlet.unplugEUDevice();  // Use the European outlet-specific method to disconnect
    }
}
